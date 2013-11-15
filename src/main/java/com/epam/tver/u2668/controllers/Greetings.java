package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Greetings {

    private final static Logger LOGGER = Logger.getLogger(Greetings.class.getName());

    @Autowired
    private UpsaRestClient restClient;

    @Autowired
    private UserContext userContext;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return restClient.getEmployees("tver", "Java. Java");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestParam String email, @RequestParam String password) {
        if (!userContext.isAuthorized()) {
            userContext.setToken(restClient.getToken(email, password, true));
        }
    }
}
