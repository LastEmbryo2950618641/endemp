package cn.personal.endemp.controller;
import cn.personal.endemp.entity.SysUser;
import cn.personal.endemp.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User/SysUser")
public class SysUserController {

    @Autowired
    SysUserMapper sysUserMapper;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
     public String login(HttpServletRequest request){
       String username=request.getParameter("username");
       String password=request.getParameter("password");
       SysUser sysUser=sysUserMapper.selectByUsername(username);
       HttpSession session = request.getSession();

       if(sysUser==null){
           return "/login-error";
       }else if(sysUser.getPassword().equals(password)){
           session.setAttribute("username",username);
           session.setAttribute("password",password);
           return "/pass";
       }else{
           return "/login-error";
       }

    }

}
