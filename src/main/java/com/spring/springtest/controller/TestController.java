package com.spring.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/testinput")
    public String testinput(){
        return "testinput.html";
    }
}
