package com.a9.mapper;

import com.a9.entity.MapGame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MapMapper {
    void create(@Param("body") MapGame body);

    List<MapGame> index();

    MapGame view(@Param("id") int id);

}
