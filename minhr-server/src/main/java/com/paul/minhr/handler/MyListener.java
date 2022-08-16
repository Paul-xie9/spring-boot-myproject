package com.paul.minhr.handler;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author Paul.x
 * @Date 2022/8/16 21:28
 * @Description
 */
@Log4j2
@WebListener
public class MyListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("==============MyListener.requestDestroyed()被调用=========================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("==============MyListener.requestInitialized()被调用=========================");
    }
}
