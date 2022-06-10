package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() {
        return "logout";
    }

}
