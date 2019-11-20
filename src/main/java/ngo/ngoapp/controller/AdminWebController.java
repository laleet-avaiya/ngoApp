package ngo.ngoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminWebController {

    @RequestMapping("/index")
    public String Home(){
        System.out.println("index call");
        return "index";
    }
}
