package com.example.springboot.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static com.example.springboot.constant.Constant.*;


/**
 * druid 监控页面配置
 */
@Configuration
@SuppressWarnings(SUPPRESS_WARNINGS_ALL)
public class DruidConfig {

    //*****************************************druid 监控页面配置****************************************************

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        //表示进行druid监控的配置处理操作
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(this.statViewServlet(), DRUID_URL_MAPPINGS);

        //设置登录名以及密码
        servletRegistrationBean.addInitParameter(LOGIN_USER_NAME, ADMIN);
        servletRegistrationBean.addInitParameter(LOGIN_PASS_WORD, ADMIN);

        //是否可以重置数据
        servletRegistrationBean.addInitParameter(RESET_ENABLE, FALSE);

        return servletRegistrationBean;
    }

    @Bean
    public StatViewServlet statViewServlet(){
        return new StatViewServlet();
    }

    @Bean
    public WebStatFilter webStatFilter() {
        return new WebStatFilter();
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(this.webStatFilter());

        // 添加过滤规则.所有请求进行监控处理
        filterRegistrationBean.addUrlPatterns(SLASH_WITH_STAR);

        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter(EXCLUSIONS_NAME, EXCLUSIONS_VALUE);

        return filterRegistrationBean;
    }
    //*****************************************druid 监控页面配置*****************************************************

    //*****************************************druid spring监控配置**************************************************
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    @Bean
    @Scope(PROTOTYPE)
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut() {
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPattern(MONITORING_PATH);
        return jdkRegexpMethodPointcut;
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(this.jdkRegexpMethodPointcut());
        defaultPointcutAdvisor.setAdvice(this.druidStatInterceptor());
        return defaultPointcutAdvisor;
    }
    //*****************************************druid spring监控配置**************************************************
}
