package com.mastery.java.task.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
