package com.paul.minhr.Handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Paul.x
 * @Date 2022/8/16 16:38
 * @Description 拦截器中的方法将按preHandle → Controller → postHandle → afterCompletion的顺序执行
 */
@Log4j2
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("=================拦截器preHandle方法执行====================");
       //只有preHandle返回为true时才往后面执行
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("=================拦截器postHandle方法执行====================");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("=================拦截器afterCompletion方法执行====================");
    }
}
