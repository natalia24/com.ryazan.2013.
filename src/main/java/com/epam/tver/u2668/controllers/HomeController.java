package com.epam.tver.u2668.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/yar")
public class HomeController {

    final Logger logger = Logger.getLogger(HomeController.class.getName());

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
