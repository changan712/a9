package com.a9.vo;

import com.a9.entity.Car;
import com.a9.entity.MapGame;
import com.a9.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class GameVo {
    private Integer id;
    private String during;
    private Integer carScore;
    private Car car;
    private MapGame map;
    private UserVo createdBy;
    private Date createdAt;

}
