package com.paul.minhr.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author Paul.x
 * @Date 2022/8/17 16:59
 * @Description
 */
@Data
@Entity(name = "m_user")
public class MUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String usename;
}
