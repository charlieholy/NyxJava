package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class ExampleController {

    @RequestMapping("/index3")
    public String index(){
        return "demo";
    }

    @RequestMapping("/let")
    public String letGo(String name, HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("name",name);
        return "demo";
    }

    @RequestMapping("search")
    @ResponseBody
    public String foo(){
        return "foo";
    }

}
