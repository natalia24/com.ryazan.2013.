package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.GameInfo;
import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @Autowired
    private GameInfo gameInfo;
    
    @RequestMapping(value = "/start")
    public ModelAndView persistenceStatus() {
        return new ModelAndView("start", "loggedIn", gameInfo.getLoggedUsers());
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
    public ModelAndView goLogin(String email, String password) {
        TokenResponse token = upsaRestClient.getToken(email, password, true);
        userContext.setToken(token);
        gameInfo.addLoggedUser(userContext.getInfo());
        return new ModelAndView("redirect:start");
    }
    
}
