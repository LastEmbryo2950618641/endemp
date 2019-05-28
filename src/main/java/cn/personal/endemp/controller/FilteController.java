package cn.personal.endemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libbox")
public class FilteController {

    @RequestMapping("/pass")
    public String pass(){

        return "/libbox/pass";
    }

}
