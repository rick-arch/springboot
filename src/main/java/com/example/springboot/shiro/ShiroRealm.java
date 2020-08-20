package com.example.springboot.shiro;

import com.example.springboot.entities.SysUser;
import com.example.springboot.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static com.example.springboot.constant.Constant.NUM_ZERO;
import static com.example.springboot.constant.Constant.SESSION_PRINCIPAL_KEY;
import static com.example.springboot.utils.Md5Util.md5;
import static org.apache.shiro.SecurityUtils.getSubject;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 授权（获取用户角色和权限）
     *
     * @param principals 用户主体信息
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取用户主体信息
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        String username = user.getUsername();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //根据用户名查询对应的角色和权限
        List<SysUser> userList = sysUserService.getRoleAndPermission(username);

        userList.forEach(sysUser -> sysUser.getRoleLists().forEach(
                sysRole -> {
                    //添加角色
                    authorizationInfo.addRoles(Collections.singleton(sysRole.getRoleName()));
                    sysRole.getPermissionsLists().forEach(
                            sysPermissions ->
                                    //添加权限
                                    authorizationInfo.addStringPermission(sysPermissions.getPermissionName())
                    );
                }));

        return authorizationInfo;
    }

    /**
     * 认证用户信息
     *
     * @param token token 用户主体信息
     * @return SimpleAuthenticationInfos
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //根据用户名查询用户是否存在
        SysUser user = sysUserService.queryByName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户【" + userName + "】不存在！");
        }

        if (!md5(password).equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户【" + userName + "】密码错误！");
        }

        if (NUM_ZERO.toString().equals(user.getStatus())) {
            throw new LockedAccountException("用户【" + userName + "】已锁定，请联系管理员！");
        }

        getSubject().getSession().setAttribute(SESSION_PRINCIPAL_KEY, user);

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
