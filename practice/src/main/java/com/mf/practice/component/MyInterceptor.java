package com.mf.practice.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义拦截器
@Component
public class MyInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 接收session
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            // 判断当前是否登录
            return true;
        }

        // 如果未登录  跳转登录页
        request.getRequestDispatcher("/login").forward(request, response);
        return false;

    }
}
