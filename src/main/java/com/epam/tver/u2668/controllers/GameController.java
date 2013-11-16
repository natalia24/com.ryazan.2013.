package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.CharacterInfo;
import com.epam.tver.u2668.beans.GameInfo;
import com.epam.tver.u2668.beans.UserContext;
import com.epam.tver.u2668.gamelogic.MainLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {
    
    @Autowired
    private UserContext userCtx;
    
    @Autowired
    private MainLogic logic;

    @Autowired
    private GameInfo gameInfo;

    @RequestMapping(value = "/coord", method = RequestMethod.GET)
    @ResponseBody
    public List<CharacterInfo> getCoord() {
        return gameInfo.getCaracterList();
    }
    
    @RequestMapping(value = "/coord", method = RequestMethod.POST)
    @ResponseBody
    public void setCoord(@RequestParam int x, @RequestParam int y) {
        logic.goTo(x, y);
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    @ResponseBody
    public void startGame() {
        logic.startGame();
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ResponseBody
    public void stopGame() {
        logic.stopGame();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView testgame() {
        ModelAndView modelAndView = new ModelAndView("index", "userCtx", userCtx);
        modelAndView.addObject("allPMs", gameInfo.getLoggedUsers());
        return modelAndView;
    }
}
