package com.paul.springbootswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 11098
 */
@SpringBootApplication
@EnableOpenApi
public class SpringBootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerApplication.class, args);
    }

}
