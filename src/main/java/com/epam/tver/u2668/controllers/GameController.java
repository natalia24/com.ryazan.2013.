package com.epam.tver.u2668.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.epam.tver.u2668.beans.TestBean;
import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.services.TestService;
import java.util.Collections;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    TestService service;

    @Autowired
    private UserContext userContext;

    @RequestMapping(value = "coord", method = RequestMethod.GET)
    @ResponseBody
    public Map getCoord() {
        return Collections.singletonMap("userContext", userContext.toString());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    List<TestBean> persistenceStatus(Model model) {
        List<TestBean> beans = service.getBeans();
        return beans;
    }

    @RequestMapping(value = "/start")
    public String persistenceStatus() {
        return "main";
    }

    @RequestMapping(value = "/screen")
    public String getScreen() {
        return "epam_screen";
    }

    @RequestMapping(value = "/login_page")
    public String goLogin() {
        return "login";
    }

    @RequestMapping(value = "/dologin")
    public String doLogin() {
        return "start";
    }
}
