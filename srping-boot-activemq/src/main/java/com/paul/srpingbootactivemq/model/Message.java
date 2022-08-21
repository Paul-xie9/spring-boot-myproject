package com.paul.srpingbootactivemq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Paul.x
 * @Date 2022/8/20 0:49
 * @Description
 */
@Data
public class Message implements Serializable {
    private String name;
    private String content;
    private Date date;
}
