package com.purewatersellsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test123")
    public void testController(){
        System.out.println(123);
    }
}
