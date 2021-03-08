package com.a9.controller;

import com.a9.entity.MapGame;
import com.a9.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapController {

    @Autowired
    private MapService mapService;


    @PostMapping("")
    public  void  create(@RequestBody MapGame body){
        mapService.create(body);
    }

}
