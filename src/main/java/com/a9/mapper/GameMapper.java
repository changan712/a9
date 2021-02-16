package com.a9.mapper;

import com.a9.dto.GameDto;
import com.a9.entity.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameMapper {

    void create(@Param("body") Game body);


    List<Game> index();


    Game view(@Param("id") int id);


    void update(@Param("body") Game body);

}
