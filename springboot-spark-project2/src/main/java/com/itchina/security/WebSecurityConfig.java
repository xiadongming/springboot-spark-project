package com.itchina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Date: 2021/3/24 10:47
 * @Desc: spring security的安全配置类
 * WebSecurityConfigurerAdapter 类是security中的类，是显示security的基础
 */
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;


    @Autowired
    private DataSource dataSource;

    /**
     * 密码加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 定义认证用户信息获取来源，密码校验规则等
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 定义安全策略
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf防护
        //http.csrf().disable().
        http.csrf().disable()
                //表单登录
                .formLogin()
                //登录页面
                .loginPage("/login.html")
                //登录访问路径，与页面表单提交路径一致
                .loginProcessingUrl("/login")
                //登录成功后访问路径
                .defaultSuccessUrl("/index.html").permitAll()
                //.failureHandler(authenticationFailureHandler)
                .and()
                //认证配置
                .authorizeRequests()
                .antMatchers("/templates/login.html", "/login").permitAll()
                //配置静态页面可以访问
                .antMatchers("/js/**", "/css/**", "/images/**", "/favicon.ico").permitAll()
                //任何请求
                .anyRequest()
                //都需要身份验证
                .authenticated();
        //配置无权限访问页面
        //http.exceptionHandling().accessDeniedPage("/uanuth.html");
        //http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler);
        //配置记住我
        http.rememberMe()
                //持久层对象
                .tokenRepository(persistentTokenRepository())
                //失效时间(秒)
                .tokenValiditySeconds(60)
                //配置自定义登录逻辑
                .userDetailsService(userDetailsService);
        //配置退出
        http.logout()
                //退出路径
                .logoutUrl("/logout")
                //退出后跳转页面
                .logoutSuccessUrl("/templates/login.html");

    }

    /**
     * 配置记住我
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);//请求时创建表
        return jdbcTokenRepository;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/image/**");
    }

    /**
     * 硬编码几个用户
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("spring").password("123456").roles("LEVEL1", "LEVEL2")
                .and()
                .withUser("summer").password("123456").roles("LEVEL2", "LEVEL3")
                .and()
                .withUser("autumn").password("123456").roles("LEVEL1", "LEVEL3");
    }

}
