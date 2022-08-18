package com.paul.minhr.model;

import lombok.Data;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Paul.x
 * @Date 2022/8/16 22:43
 * @Description
 * [@Entity]:表的名称即@Entity注解中name的值，如果不配置name，默认表名为类名
 * [@Id]:表示该属性是一个主键
 * [@GeneratedValue]:表示主键自动生成，strategy则表示主键的生成策略
 * [@Column]:可以定制生成的字段的属性，name表示该属性对应的数据表中字段的名称，nullable表示该字段非空
 *           默认情况下，生成的表中字段的名称就是实体类中属性的名称
 *[@Transient]:表示在生成数据库中的表时，该属性被忽略，即不生成对应的字段
 */
//@Data
//@Entity(name = "Student")
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name",nullable = false)
//    private String name;
//    private Date birthday;
//    @Transient
//    private boolean isDel;
//
//}


@Data
public class Student implements Serializable {
    private Long id;
    private String name;
    private Date birthday;
}
