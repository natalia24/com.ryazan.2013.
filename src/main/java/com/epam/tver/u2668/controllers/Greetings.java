package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.upsa.AuthContext;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

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
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public TokenResponse login(@RequestParam String email, @RequestParam String password) {
        return restClient.getToken(email, password, true);
    }
}
