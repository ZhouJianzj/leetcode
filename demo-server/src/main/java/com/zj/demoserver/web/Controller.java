package com.zj.demoserver.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class Controller {

    @RequestMapping("server")
    public String login( HttpServletRequest request){

        HttpSession session = request.getSession();

        return (String) session.getAttribute("username") + "==>"
                + session.getAttribute("password");
    }

}
