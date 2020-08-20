package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysRole;
import com.example.springboot.entity.user.SysUser;
import com.example.springboot.entity.user.UserOnline;
import com.example.springboot.repository.SysUserRepository;
import com.example.springboot.service.SysUserService;
import com.example.springboot.utils.DateUtil;
import com.google.common.collect.Lists;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.utils.Md5Util.md5;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public SysUser queryByName(String username) {
        return sysUserRepository.selectByName(username);
    }

    @Override
    public List<SysUser> getRoleAndPermission(String username) {
        return sysUserRepository.findRoleAndPermission(username);
    }

    @Override
    public JsonDomainArray<SysUser> getUseList(SysUser sysUser) {
        Integer count = sysUserRepository.getUserCount(sysUser);
        sysUser.setPage((sysUser.getPage() - NUM_ONE) * NUM_TEN);//1,10  2,10
        List<SysUser> userList = sysUserRepository.findUserList(sysUser);
        return new JsonDomainArray<SysUser>().setCount(count).setData(userList);
    }

    @Override
    public boolean removeUser(Integer[] id) {
        return sysUserRepository.updateUser(id) > NUM_ZERO;
    }

    @Override
    public boolean updateOrUpdateUser(SysUser sysUser) {
        boolean flag;

        //设置账户创建时间
        sysUser.setCreateTime(DateUtil.format());

        if (sysUser.getId() == null) {
            //查询用户名是否存在
            SysUser user = sysUserRepository.selectByName(sysUser.getUsername());
            if (user != null) {
                return false;
            }

            //密码加密
            sysUser.setPassword(md5(sysUser.getPassword()));

            //新增用户
            flag = sysUserRepository.insertUser(sysUser) > NUM_ZERO;
        } else {

            //修改用户信息
            flag = sysUserRepository.modifyUser(sysUser) > NUM_ZERO;

            //删除用户和角色关系
            sysUserRepository.removeRelation(sysUser.getId());
        }


        if (!sysUser.getRoleLists().isEmpty()) {
            //插入新的关系
            sysUserRepository.insertRelation(sysUser.getId(), (List<SysRole>) sysUser.getRoleLists());
        }

        return flag;
    }

    @Override
    public List<SysRole> getRoleList() {
        return sysUserRepository.findRoleList();
    }

    @Override
    public boolean enableUser(Integer id) {
        return sysUserRepository.enable(id) > NUM_ZERO;
    }

    @Override
    public boolean accountIsEffective(Integer id) {
        return sysUserRepository.isEffective(id) > NUM_ZERO;
    }

    @Override
    public JsonDomainArray<UserOnline> list() {

        List<UserOnline> userOnlineList = Lists.newArrayList();

        Collection<Session> sessionCollection = sessionDAO.getActiveSessions();

        for (Session session : sessionCollection) {
            UserOnline userOnline = new UserOnline();
            SysUser sysUser;
            SimplePrincipalCollection simplePrincipalCollection;
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                simplePrincipalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                sysUser = (SysUser) simplePrincipalCollection.getPrimaryPrincipal();
                userOnline.setUsername(sysUser.getUsername());
                userOnline.setUserId(sysUser.getId().toString());
            }
            userOnline.setChinaName(sysUser.getChinaName());
            userOnline.setId((String) session.getId());
            userOnline.setHost(session.getHost());

            userOnline.setStartTimestamp(DateUtil.format(session.getStartTimestamp()));
            userOnline.setLastAccessTime(DateUtil.format(session.getLastAccessTime()));

            long timeout = session.getTimeout();
            if (timeout == LONG0L) {
                userOnline.setStatus(NOT_ON_LINE);
            } else {
                userOnline.setStatus(ON_LINE);
            }
            userOnlineList.add(userOnline);
        }
        return new JsonDomainArray<UserOnline>().setCount(userOnlineList.size()).setData(userOnlineList);
    }

    @Override
    public boolean forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(NUM_ZERO);
        return true;
    }

    @Override
    public boolean reset(SysUser sysUser) {
        sysUser.setPassword(md5(String.valueOf(NUM_ONE)));
        return sysUserRepository.resetPassword(sysUser) > NUM_ZERO;
    }

}
