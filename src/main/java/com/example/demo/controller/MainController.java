package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MainController {
    private int count = 0;

    @GetMapping("/main")
    public String mainController(ModelMap mp){
        mp.addAttribute("test", count);
        return "main"; // Error 500
    }

    @GetMapping("/alek") // Get request
    public String setTest(ModelMap mp) {
        count++;
        mp.addAttribute("test", count);


        return "main";
    }



    @GetMapping("/hello")
    public String helloWorld(){

        return "main"; // Error 500
    }



}
