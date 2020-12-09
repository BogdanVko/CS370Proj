package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/checkin")
    public String getCheckin(){
        return "checkin";
    }

    @GetMapping("/adminka")
    public String getAdmin(){
        return "adminka";
    }
}
