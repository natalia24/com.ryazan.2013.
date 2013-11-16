package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.beans.CharacterInfo;
import com.epam.tver.u2668.beans.GameInfo;
import com.epam.tver.u2668.gamelogic.MainLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private MainLogic logic;

    @Autowired
    private GameInfo gameInfo;

    @RequestMapping(value = "/coord", method = RequestMethod.GET)
    @ResponseBody
    public List<CharacterInfo> getCoord() {
        return gameInfo.getCaracterList();
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
    public String testgame() {
        return "index";
    }
}
