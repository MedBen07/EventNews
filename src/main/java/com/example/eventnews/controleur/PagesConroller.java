package com.example.eventnews.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PagesConroller {

    @GetMapping("/")
    public String index(HttpServletRequest request){
        return "index";
    }
}


