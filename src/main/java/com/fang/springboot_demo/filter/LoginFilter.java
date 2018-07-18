package com.fang.springboot_demo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义过滤器
 */

@WebFilter(urlPatterns = "/api/*",filterName = "loginFilter")  //urlPattern:拦截内容，filterName：拦截器名称
public class LoginFilter implements Filter {


    /**
     * 容器启动时调用
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter");
    }

    /**
     * 请求拦截时调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter doFilter");

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String userName=request.getParameter("username");
        if("fang".equals(userName)){
            filterChain.doFilter(servletRequest,servletResponse);  //放行
        }else{
            return;
        }

    }

    /**
     * 容器销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("destory LoginFilter");
    }
}
