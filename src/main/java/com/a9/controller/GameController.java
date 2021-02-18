package com.a9.controller;

import com.a9.dto.GameDto;
import com.a9.entity.Game;
import com.a9.service.GameService;
import com.a9.vo.GameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {


    @Autowired
    public GameService gameService;

    @PostMapping("")
    public void create(@RequestBody GameDto body) {

         gameService.create(body);
    }

    @GetMapping("")
    public List<GameDto> index(){
        return  gameService.index();
    }

    @GetMapping("{id}")
    public GameVo view(@PathVariable int id){
        return  gameService.view(id);
    }

}
