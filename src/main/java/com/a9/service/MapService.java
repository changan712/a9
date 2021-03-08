package com.a9.service;

import com.a9.entity.MapGame;
import com.a9.mapper.MapMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    @Autowired
    private MapMapper mapMapper;

    public void create(MapGame body) {

        mapMapper.create(body);

    }
}
