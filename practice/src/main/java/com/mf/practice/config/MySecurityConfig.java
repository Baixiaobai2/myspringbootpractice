package com.mf.practice.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//声明使用spring security  进行相应的配置
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    //授权
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/")//全路径匹配
                .permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")//定制请求权限
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //root有全部权限，可以访问level全部内容

        // 设置自定义登录页 和 登录参数
        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login");//login.html页面

        // 默认的表单处理逻辑
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String pwd = new BCryptPasswordEncoder().encode("123456");//密码加密
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(pwd).roles("VIP1","VIP2","VIP3")
                .and()
                .withUser("student").password(pwd).roles("VIP1","VIP2")
                .and()
                .withUser("guest").password(pwd).roles("VIP1");
    }
}
