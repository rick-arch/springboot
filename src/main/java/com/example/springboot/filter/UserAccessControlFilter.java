package com.example.springboot.filter;

import com.alibaba.fastjson.JSON;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.entities.SysUser;
import com.example.springboot.service.SysUserService;
import com.example.springboot.utils.BeansUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.LOGIN;


/**
 * shiro提供的filter-AccessControlFilter
 */
@Slf4j
@Component
public final class UserAccessControlFilter extends AccessControlFilter {


    /**
     * 是否允许访问，返回true表示允许
     *
     * @param request  http请求
     * @param response http响应
     * @param object   请求参数
     * @return boolean 是否允许访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object object) {

        final Subject subject = SecurityUtils.getSubject();

        // 判断用户是否进行过登录认证，如果没经过认证则返回登录页
        if (subject.getPrincipal() == null || !subject.isAuthenticated()) {
            return Boolean.FALSE;
        }

        // 获取session
        final Session session = subject.getSession();
        final SysUser sysUser = (SysUser) session.getAttribute(SESSION_PRINCIPAL_KEY);

        if (sysUser == null) {
            return Boolean.FALSE;
        }

        // 使用@Autowired无效 service为null，因为过滤器在spring扫描bean之前加载,通过已经初始化之后applicationContext容器中去获取需要的bean
        final SysUserService sysUserService = (SysUserService) BeansUtil.getBean(SYS_USER_SERVICE_IMPL);

        // 判断账号是否有效
        final boolean isEffective = sysUserService.accountIsEffective(sysUser.getId());
        if (!isEffective) {
            return Boolean.FALSE;
        }

        final String requestURI = this.getPathWithinApplication(request);
        log.info("请求URL为:{}", requestURI);
        return Boolean.TRUE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        // 重定向到登录页面
        if (this.isAjax((HttpServletRequest) request)) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.setStatus(NUM_FOUR_HUNDRED_THREE);
            response.setContentType(APPLICATION_JSON_UTF8_VALUE);
            JSON.writeJSONString(response.getWriter(), new JsonResponseVO(Boolean.FALSE, SESSION_TIME_OUT));
        } else {
            //this.redirectToLogin(request, response);
            request.getRequestDispatcher(LOGIN).forward(request, response);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean isAjax(HttpServletRequest request) {
        return StringUtils.isNotBlank(request.getHeader(X_REQUESTED_WITH)) && XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
    }
}
