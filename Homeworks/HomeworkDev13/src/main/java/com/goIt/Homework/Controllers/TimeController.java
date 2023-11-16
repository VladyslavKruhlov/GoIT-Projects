package com.goIt.Homework.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Завдання 1
@Controller
public class TimeController {
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("current");
        result.addObject("now", LocalDateTime.now());
        return result;
    }
}
