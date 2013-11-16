package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.CharacterInfo;
import com.epam.tver.u2668.beans.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.epam.tver.u2668.beans.TestBean;
import com.epam.tver.u2668.services.TestService;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private TestService service;
    
    @Autowired
    private GameInfo gameInfo;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody List<TestBean> persistenceStatus(Model model) {
        List<TestBean> beans = service.getBeans();
        return beans;
    }
    
    @RequestMapping(value = "/coord", method = RequestMethod.GET)
    @ResponseBody
    public List<CharacterInfo> getCoord() {
        return gameInfo.getCaracterList();
    }
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    @ResponseBody
    public void startGame() {
        gameInfo.initGame();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String testgame() {
        return "index";
    }
}
