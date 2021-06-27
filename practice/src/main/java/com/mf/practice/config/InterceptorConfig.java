package com.mf.practice.config;

import com.mf.practice.component.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 把拦截器配置进去
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**")//对所有资源拦截
                .excludePathPatterns("/login","/*.css","/*.js");//放行指定资源
    }

}
