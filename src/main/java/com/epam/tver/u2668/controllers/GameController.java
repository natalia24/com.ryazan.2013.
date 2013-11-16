package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.UserContext;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/game")
public class GameController {
    
    @Autowired
    private UserContext userContext;
    
    @RequestMapping(value = "coord", method = RequestMethod.GET)
    @ResponseBody
    public Map getCoord() {
        return Collections.singletonMap("userContext", userContext.toString());
    }
}
