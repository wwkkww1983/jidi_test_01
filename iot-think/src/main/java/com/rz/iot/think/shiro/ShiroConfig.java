package com.rz.iot.think.shiro;

import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * Author by xuxiake, Date on 2019/3/1.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Configuration
public class ShiroConfig {

    //注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
        creator.setUsePrefix(true);
        return creator;
    }

    @Bean("authenticator")
    public Authenticator authenticator() {
        Authenticator authenticator = new ModularRealmAuthenticator();
        return authenticator;
    }

    @Bean("authorizer")
    public Authorizer authorizer() {
        Authorizer authorizer = new ModularRealmAuthorizer();
        return authorizer;
    }

    @Bean("sessionManager")
    public SessionManager sessionManager() {
        SessionManager sessionManager = new DefaultWebSessionManager();
        return sessionManager;
    }

    /**
     * 注入 securityManager
     * @return
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        // 自定义拦截器（实现未登录返回json）,自定义拦截器需要手动new，不能交给spring管理，否则会报错
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("ShiroLoginFilter", new ShiroLoginFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //开放登陆接口
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/websocket/**", "anon");

        //测试用
        filterChainDefinitionMap.put("/playStrategy/**", "anon");
        filterChainDefinitionMap.put("/test/**", "anon");

        //其余接口一律拦截
//        filterChainDefinitionMap.put("/**", "ShiroLoginFilter");
        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
