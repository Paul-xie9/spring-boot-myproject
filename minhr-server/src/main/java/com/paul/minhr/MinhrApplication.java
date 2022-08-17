package com.paul.minhr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 11098
 */
@SpringBootApplication
@ServletComponentScan
public class MinhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinhrApplication.class, args);
        //关闭banner
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(MinhrApplication.class);
//        builder.bannerMode(Banner.Mode.OFF).run(args);
    }

}
