package com.a9.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("")
public class testController {

    @GetMapping("test")
    String test(){
        return  "test";
    }
}
