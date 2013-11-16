/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tver.u2668.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Наташулька
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
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
        return "login_page";
    }
    
    @RequestMapping(value = "/gologin") 
    public String goLogin() {
        return "start";
    }
    
}
