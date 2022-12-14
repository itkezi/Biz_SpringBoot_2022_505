package com.callor.book.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String login() {
        return "user/login";
    }

}
