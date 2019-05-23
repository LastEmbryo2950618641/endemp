package cn.personal.endemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：刘奇
 * @ Date       ：Created in 20:45 2019/5/22
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
@RequestMapping("/")
public class PageController {


    @RequestMapping("login")
    public String login()
    {
        return "login";

    }

    @RequestMapping("login-error")
    public String loginError()
    {
        return "login-error";

    }
    @RequestMapping("index")
    public String index()
    {
        return "index";

    }


}
