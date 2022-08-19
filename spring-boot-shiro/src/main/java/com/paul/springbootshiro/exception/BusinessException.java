package com.paul.springbootshiro.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Paul.x
 * @Date 2022/8/19 19:03
 * @Description
 */
@ControllerAdvice
public class BusinessException {
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e){
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        modelAndView.addObject("error",e.getMessage());
        return modelAndView;
    }
}
