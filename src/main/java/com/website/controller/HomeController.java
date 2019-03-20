package com.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Map<String,Object> map){
        map.put("hello","初次见面");
        return "index";
    }
}
