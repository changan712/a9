package com.a9.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class GameDto {
    private Integer id;
    private String during;
    private Integer carScore;
    private Integer car;
    private Integer createdBy;
    private Date createdAt;

}
