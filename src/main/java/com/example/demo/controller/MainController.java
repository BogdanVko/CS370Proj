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


///Tasks
@Controller
public class MainController {
<<<<<<< Updated upstream
    private int count = 0;
    private int count1 = 0;
=======
    private int count = 10;
>>>>>>> Stashed changes

    @GetMapping("/main")
    public String mainController(ModelMap mp){
        mp.addAttribute("test", count);
        return "main"; // Error 500
    }



    @GetMapping("/alek") // Get request
    public String setTest(ModelMap mp) {
        count+=10;
        mp.addAttribute("test", count);


        return "main";
    }
    @GetMapping("/wordchange") // Get request
    public String setWord(ModelMap mp) {
        String Alec;
        count1++;
        if(count1%2 == 0){
            Alec = "Back";
            mp.addAttribute("Word", Alec);
        }
        else{
            Alec = "Forth";
            mp.addAttribute("Word", Alec);
        }
        return "Alec";
    }

    @GetMapping("/Alec")
    public String Alec(){
        return "Alec"; // Error 500
    }



    @GetMapping("/hello")
    public String helloWorld(){

        return "main"; // Error 500
    }



}
