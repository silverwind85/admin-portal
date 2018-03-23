package com.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping(value = "/")
    public String admin() {
        return "user/form/admin";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "user/form/login";
    }


}
