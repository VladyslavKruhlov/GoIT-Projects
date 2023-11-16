package com.goIt.Homework.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//Завдання 2
@Controller
public class TestController {
        @RequestMapping(value = "/hello", method = {RequestMethod.GET})
        public ModelAndView getHelloWorld() {
            ModelAndView result = new ModelAndView("test");
            result.addObject("message", "Hello World");
            return result;
    }
}
