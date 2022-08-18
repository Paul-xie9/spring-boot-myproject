package com.paul.springbootcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author Paul.x
 * @Date 2022/8/15 23:19
 * @Description
 */
@Data
@AllArgsConstructor
public class Book implements Serializable {
    private Long id;
    private String name;
    private String author;
}
