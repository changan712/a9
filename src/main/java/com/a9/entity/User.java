package com.a9.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private  String  name;
    private  String token;
    private Integer gender;
    private Integer qq;
    private  String email;
}
