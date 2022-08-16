package com.paul.minhr.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.x
 * @Date 2022/8/15 23:19
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "book")
@Data
public class Book {
    private String name;
    private String author;
}
