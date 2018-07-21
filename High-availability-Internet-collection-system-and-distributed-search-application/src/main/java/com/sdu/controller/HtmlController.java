package com.sdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kkkkkk on 2018/7/6.
 */
@Controller
public class HtmlController {

    @GetMapping("/admin")
    public String admin(){
        return "/login.html";
    }

    @GetMapping("/index")
    public String index(){
        return "/Administration.html";
    }

    @GetMapping("/user")
    public String user(){
        return "/user.html";
    }
}
