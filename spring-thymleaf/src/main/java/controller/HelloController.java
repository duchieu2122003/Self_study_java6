package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hieundph25894
 */
@Controller
public class HelloController {

    @GetMapping()
   // @RequestMapping("/hello.th")
    public String hello(Model model) {
        model.addAttribute("message", "xin chao");
        model.addAttribute("banner","FPT <b>Poly</b>");
        return "a";
    }
}
