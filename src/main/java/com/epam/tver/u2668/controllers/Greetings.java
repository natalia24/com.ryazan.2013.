package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.upsa.AuthContext;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class Greetings {

    private final static Logger LOGGER = Logger.getLogger(Greetings.class.getName());

    @Autowired
    private UpsaRestClient restClient;

    @Autowired
    private AuthContext authContext;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return restClient.getEmployees("tver", "Java. Java");
    }
}
