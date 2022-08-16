package com.paul.minhr.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/16 21:55
 * @Description
 */
@Log4j2
@Component
@Aspect
public class LogAspect {

    /**
     * execution
     * 第一个*表示方法返回任意值
     * 第二个*表示controller包下的任意类
     * 第三个*表示类中的任意方法
     * 括号中的两个点表示方法参数任意
     */
    @Pointcut("execution(* com.paul.minhr.controller.*.*(..))")
    public void pc1(){
    }

    /**
     * 这是一个前置通知，该方法在目标方法执行之前执行
     * @param joinPoint
     */
    @Before(value = "pc1()")
    public void before(JoinPoint joinPoint){
       log.info("=====LogAspect.before()被调用========"+joinPoint.getSignature().getName()+"方法开始执行===============");
    }

    /**
     * 这是一个后置通知，该方法在目标方法执行之后执行
     * @param joinPoint
     */
    @After(value = "pc1()")
    public void after(JoinPoint joinPoint){
        log.info("=====LogAspect.after()被调用========"+joinPoint.getSignature().getName()+"方法结束执行===============");
    }

    /**
     * 这是一个返回通知，在该方法中可以获取目标方法的返回值
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        log.info("=====LogAspect.afterReturning()被调用========"+joinPoint.getSignature().getName()+"方法返回值:"+result+"===============");
    }

    /**
     * 这是一个异常通知，即当目标方法发生异常时，该方法会被调用，异常类型为Exception表示所有的异常都会进入该方法中执行
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        log.info("=====LogAspect.afterThrowing()被调用========"+joinPoint.getSignature().getName()+"方法抛出的异常是:"+e+"===============");
    }

    /**
     * 表示这是一个环绕通知。环绕通知是所有通知里功能最为强大的通知，可以实现前置通知、后置通知、异常通知以及返回通知的功能。目标方法进入环绕通知后，通过调用ProceedingJoinPoint对象的proceed方法使目标方法继续执行
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "pc1()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.info("=====LogAspect.around()被调用======point.proceed()==>"+point.proceed());
        return point.proceed();
    }

}
