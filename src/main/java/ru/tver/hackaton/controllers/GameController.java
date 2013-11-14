package ru.tver.hackaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tver.hackaton.beans.TestBean;
import ru.tver.hackaton.services.TestService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav_Zabara
 * Date: 11/14/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    TestService service;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody List<TestBean> persistenceStatus(Model model) {
        List<TestBean> beans = service.getBeans();
        return beans;
    }

    @RequestMapping(value = "/start")
    public String persistenceStatus() {
        return "main";
    }
}
