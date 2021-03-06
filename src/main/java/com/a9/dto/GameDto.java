package com.a9.dto;

import com.a9.entity.Car;
import com.a9.entity.User;
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
