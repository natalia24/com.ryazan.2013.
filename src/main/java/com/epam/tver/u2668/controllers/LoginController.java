package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Наташулька
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private UserContext userContext;
    
    @Autowired
    private UpsaRestClient upsaRestClient;
    
    @RequestMapping(value = "/start")
    public String persistenceStatus() {
        return "main";
    }
    
    @RequestMapping(value = "/screen")
    public String getScreen() {
        return "epam_screen";
    }  
            
    @RequestMapping(value = "/login_page")
    public String getLoginPage() {
        return "login";
    }
    
    @RequestMapping(value = "/gologin") 
    public String goLogin(String email, String password) {
        TokenResponse token = upsaRestClient.getToken(email, password, true);
        userContext.setToken(token);
        return "start";
    }
    
}
