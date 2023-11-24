package com.goIt.Homework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/note").setViewName("list");
        registry.addViewController("/").setViewName("list");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/list/id").setViewName("noteById");
        registry.addViewController("/login").setViewName("login");
    }
}
