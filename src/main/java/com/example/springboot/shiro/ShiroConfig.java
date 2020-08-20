package com.example.springboot.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.springboot.filter.UserAccessControlFilter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.*;

/**
 * 四个核心：登录认证，权限验证，会话管理，数据加密。
 * 六个支持：支持WEB开发，支持缓存，支持线程并发验证，支持测试，支持用户切换，支持"记住我"功能
 * • Authentication ：身份认证，也可以理解为登录，验证用户身份。
 * • Authorization ：权限验证，也可以理解为授权，验证用户是否拥有某个权限；即判断用户是否能进行什么操作。
 * • SessionManager ：会话管理，用户登录后就是一次会话，在退出前，用户的所有信息都在会话中。
 * • Cryptography ：数据加密，保护数据的安全性，常见的有密码的加盐加密。加密组件，Shiro提供了很多加解密算法的组件
 * • Web Support ：支持Web开发。
 * • Caching ：缓存，Shiro将用户信息、拥有的角色/权限数据缓存，以提高程序效率。
 * • Concurrency ：支持多线程应用的并发验证，即在一个线程中开启另一个线程，Shiro能把权限自动传播过去。
 * • Testing ：提供测试支持。
 * • Run As ：允许一个用户以另一个用户的身份进行访问；前提是两个用户运行切换身份。
 * • Remember Me ：记住我，常见的功能，即登录一次后，在指定时间内免登录。
 * • CacheManager：缓存控制器，Realm管理的数据（用户、角色、权限）可以放到缓存里由CacheManager管理，提高认证授权等的速度
 * • SessionDao：把Session的 CRUD和存储介质联系起来的工具，存储介质可以是数据库，也可以是缓存，比如把session放到redis里面
 */
@Configuration
public class ShiroConfig {

    /**
     * shiro 过滤器
     * <p>
     * 配置缩写                            对应的过滤器                                    功能
     * anon                          AnonymousFilter                            指定url可以匿名访问
     * authc                         FormAuthenticationFilter               指定url需要form表单登录，默认会从请求中获取username、password,rememberMe等参数并尝试登录，如果登录不了就会跳转到loginUrl配置的路径。我们也可以用这个过滤器做默认的登录逻辑，但是一般都是我们自己在控制器写登录逻辑的，自己写的话出错返回的信息都可以定制嘛。
     * authcBasic                 BasicHttpAuthenticationFilter        指定url需要basic登录
     * logout                        LogoutFilter                                   登出过滤器，配置指定url就可以实现退出功能，非常方便
     * noSessionCreation    NoSessionCreationFilter                 禁止创建会话
     * perms                        PermissionsAuthorizationFilter      需要指定权限才能访问
     * port                            PortFilter                                        需要指定端口才能访问
     * rest                            HttpMethodPermissionFilter          将http请求方法转化成相应的动词来构造一个权限字符串，这个感觉意义不大，有兴趣自己看源码的注释
     * roles                            RolesAuthorizationFilter               需要指定角色才能访问
     * ssl                                SslFilter                                        需要https请求才能访问
     * user                            UserFilter                                       需要已登录或“记住我”的用户才能访问
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 自定义拦截器
        Map<String, Filter> filtersMap = Maps.newLinkedHashMapWithExpectedSize(NUM_ONE);
        filtersMap.put(AUTHC, new UserAccessControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        // shiro 拦截器：（authc:所有url必须认证通过才可以访问  anon：所有url都可以匿名访问
        // 过滤链定义，从上向下顺序执行，一般将/**放在最后面
        LinkedHashMap<String, String> hashMap = Maps.newLinkedHashMapWithExpectedSize(NUM_SIXTY);

        // 退出（shiro 已实现）
        hashMap.put(LOGOUT, LOGOUT_WITHOUT_SLASH);

        // 静态资源匿名访问
        hashMap.put(CSS, ANON);
        hashMap.put(JS, ANON);
        hashMap.put(FONT, ANON);
        hashMap.put(IMG, ANON);
        hashMap.put(ASSETS, ANON);

        // swagger文档 匿名访问
        hashMap.put(UI, ANON);
        hashMap.put(WEB_JARS, ANON);
        hashMap.put(V2, ANON);
        hashMap.put(RESOURCES, ANON);

        // 登录页面、注册请求不拦截
        hashMap.put(LOGIN, ANON);
        hashMap.put(REGISTER, ANON);

        //阿里云 druid监控页面不拦截
        hashMap.put(DRUID, ANON);

        // 记住我或认证通过可以访问的地址
        hashMap.put(LEFT_SLASH, USER);
        hashMap.put(INDEX, USER);

        // 其他页面认证访问
        hashMap.put(ALL, USER);

        //原先我们在filterChainDefinitions属性的最后定义的是
        // /**=authc authc对应的是一个过滤器，
        // 这个过滤器要求用户必须经过认证才能访问相应的请求。
        // 记住我的功能有没有经过认证？没有经过认证的。
        //TODO 如果要启用记住我的功能，就不能再写/**=authc 。
        // 要写/**=user user也对应一个过滤器，这个过滤器要求，
        // 要么是经过认证的用户，要么是通过记住我过的用户 都可以访问相应的请求。

        //  登录的路径
        shiroFilterFactoryBean.setLoginUrl(LOGIN);

        //  登录成功后跳转的路径
        shiroFilterFactoryBean.setSuccessUrl(INDEX);

        //  验证失败后跳转的路径
        shiroFilterFactoryBean.setUnauthorizedUrl(STR_404);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);

        return shiroFilterFactoryBean;
    }

    /**
     * Subject：主体，一般指用户。
     * 安全管理器，管理所有Subject，(类似于SpringMVC中的DispatcherServlet)
     */
    @Bean
    public SecurityManager securityManager() {

        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();

        //设置自定义realm
        securityManager.setRealm(this.shiroRealm());

        //设置缓存管理器
        securityManager.setCacheManager(this.ehCacheManager());

        //设置记住我管理器
        securityManager.setRememberMeManager(this.rememberMeManager());

        //设置session管理器
        securityManager.setSessionManager(this.sessionManager());

        return securityManager;
    }

    /**
     * 自定义认证授权realm
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * 实现spring的自动代理
     * 用来扫描上下文，寻找所有的Advistor(通知器），将这些Advisor应用到所有符合切入点的Bean中。
     * 所以必须在lifecycleBeanPostProcessor创建之后创建，所以用了depends-on=”lifecycleBeanPostProcessor”>
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     */
    @Bean
    @DependsOn(LIFECYCLE_BEAN_POST_PROCESSOR)
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /***
     *  shiro aop 注解支持（controller 中使用@RequiresPermissions等注解）
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(this.securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * ShiroDialect 方言，为了在thymeleaf里使用shiro的标签的bean(之前没写这个bean，html shiro标签不生效)
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 缓存管理器(基于ecache实现)
     */
    @Bean
    public EhCacheManager ehCacheManager() {

        EhCacheManager ehCacheManager = new EhCacheManager();

        //设置ehcache配置文件
        ehCacheManager.setCacheManagerConfigFile(EHCACHE_SHIRO);

        return ehCacheManager;
    }


    /**
     * cookie对象
     */
    @Bean
    public SimpleCookie simpleCookie() {

        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie(REMEMBER_ME);

        //如果httpOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        simpleCookie.setHttpOnly(true);

        //记住我cookie生效时间,单位是秒
        simpleCookie.setMaxAge(NUM_ONE_HUNDRED_TWENTY);

        return simpleCookie;
    }

    /**
     * cookie管理对象
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {

        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();

        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
        rememberMeManager.setCipherKey(Base64.decode(CIPHER_KEY));

        //设置cookie对象
        rememberMeManager.setCookie(this.simpleCookie());

        return rememberMeManager;
    }

    @Bean
    public SessionDAO sessionDAO() {
        return new MemorySessionDAO();
    }

    /**
     * session管理器
     */
    @Bean
    public SessionManager sessionManager() {

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        Collection<SessionListener> listeners = Lists.newArrayListWithCapacity(NUM_ONE);
        listeners.add(new ShiroSession());

        //设置session监听集合
        sessionManager.setSessionListeners(listeners);

        sessionManager.setSessionDAO(this.sessionDAO());

        return sessionManager;
    }

}
