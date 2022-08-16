package com.paul.minhr.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Paul.x
 * @Date 2022/8/16 2:54
 * @Description
 */
@ControllerAdvice
public class BusinessException {
    /**
     * 处理文件大小超出限制的异常
     * @param e
     * @param res
     * @throws IOException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        PrintWriter writer = res.getWriter();
        writer.write("上传文件大小超出限制");
        writer.flush();
        writer.close();
    }
}
