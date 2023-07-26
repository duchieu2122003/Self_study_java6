package com.example.springthymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hieundph25894
 */
@Controller
public class HelloController {

   // @GetMapping("/hello")
   @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "xin chao");
        model.addAttribute("banner","FPT <b>Poly</b>");
        model.addAttribute("c","FPT <b>Poly</b>");
        return "hello";
    }
}
