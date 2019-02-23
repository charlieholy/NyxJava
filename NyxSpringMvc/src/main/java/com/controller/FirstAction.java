package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstAction {

    @RequestMapping("/nani")
    public String login(){
        return "aa";
    }
}
