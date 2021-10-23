package com.zj.demologin.web;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class Controller {

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request){
        if (username.isEmpty() || password.isEmpty()){
            return "无效用户名";
        }
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);

        return (String) session.getAttribute("username") + "==>" + session.getAttribute("password");
    }

}
