package com.a9.entity;


import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class Game {
    private Integer id;
    private Date during;
    private Integer carScore;
    private Integer car;
    private Integer map;
    private Integer createdBy;
    private Date createdAt;
}

