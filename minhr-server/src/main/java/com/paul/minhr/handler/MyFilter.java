package com.paul.minhr.handler;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author Paul.x
 * @Date 2022/8/16 21:25
 * @Description
 */
@Log4j2
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("===========MyFilter.init()被调用=================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("===========MyFilter.doFilter()被调用=================");
    }

    @Override
    public void destroy() {
        log.info("===========MyFilter.destroy()被调用=================");
    }
}
