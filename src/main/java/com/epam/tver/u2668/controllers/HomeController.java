package com.epam.tver.u2668.controllers;

import com.epam.tver.u2668.upsa.UpsaRestClient;
import com.epam.tver.u2668.upsa.apibeans.Employee;
import com.epam.tver.u2668.upsa.apibeans.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UpsaRestClient restClient;

    @RequestMapping(value = "skills", method = RequestMethod.GET)
    @ResponseBody
    public Skill[] skills(@RequestParam String id) {
        return restClient.getEmployeeSkills(id);
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    @ResponseBody
    public Employee[] employees(@RequestParam String city) {
        return restClient.getEmployees(city);
    }

    @RequestMapping(value = "location", method = RequestMethod.GET)
    @ResponseBody
    public String location(@RequestParam String id) {
        return restClient.getLocation(id);
    }
}
