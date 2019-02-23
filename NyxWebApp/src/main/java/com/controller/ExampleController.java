package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class ExampleController {

    @RequestMapping("/index3")
    public String index(){
        return "demo";
    }

    @RequestMapping("search")
    @ResponseBody
    public String foo(){
        return "foo";
    }

}
