package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class ExampleController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/index3")
    public String index(){
        System.out.println(httpServletRequest.getSession().getId());
        return "demo";
    }

    static int i = 0;

    @RequestMapping(value = "/let")
    public String letGo(String name, HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("name",name);
        System.out.println("nani" + i++);
        System.out.println(httpServletRequest.getSession().getId());
        return "demo";
    }

    @RequestMapping("search")
    @ResponseBody
    public String foo(){
        return "foo";
    }

}
