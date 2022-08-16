package com.paul.minhr.controller;

import com.paul.minhr.model.Book;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * @Author Paul.x
 * @Date 2022/8/15 21:14
 */
@Log4j2
@RestController
public class TestController {

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] uploadFiles, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/uploadFile/");
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String s = format.format(new Date());
        File file = new File(path + s);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        for (MultipartFile uploadFile : uploadFiles) {
            String oldName = uploadFile.getOriginalFilename()!=null?uploadFile.getOriginalFilename():"oldName.txt";
            String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
            try {
                uploadFile.transferTo(new File(file,newName));
                return request.getScheme() + "://" + request.getServerName() + ":"
                        + request.getServerPort() + "/uploadFile/" + s + newName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error!";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/uploadFile/");
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String s = format.format(new Date());
        File file = new File(path + s);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename()!=null?uploadFile.getOriginalFilename():"oldName.txt";
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(file,newName));
            return request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/uploadFile/" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error!";
    }

    @Autowired
    Book book;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     *@CrossOrigin
     * value表示支持的域，这里表示来自http://localhost:8081域的请求是支持跨域的
     * maxAge表示探测请求的有效期(在执行过程中会先发送探测请求，探测请求不用每次都发送，
     * 可以配置一个有效期，有效期过了之后才会发送探测请求。这个属性默认是1800秒，即30分钟。)
     * allowedHeaders表示允许的请求头，*表示所有的请求头都被允许。
     * @return
     */
    @RequestMapping("/t")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*",allowCredentials = "true")
    public String test(){
        return "test";
    }

    @RequestMapping("/b/b")
    public ModelAndView getBooks(){
        ModelAndView modelAndView = new ModelAndView();
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        modelAndView.addObject("books",books);
        modelAndView.setViewName("bookList");
        log.info(Arrays.toString(books.toArray()));
        return modelAndView;
    }
}
