package ru.tver.hackaton.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        logger.info("index default method");
        model.addAttribute("message", "Homer like eat all");
        return "index";
    }

    @RequestMapping(value = "/{something}",method = RequestMethod.GET)
    public String indexMessage(@PathVariable("something") String something ,Model model){
        logger.info("indexMessage method");
        model.addAttribute("message", "Homer like eat " + something);
        return "index";
    }
}
