package com.mf.practice.config;

import com.mf.practice.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MyConfig {

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
