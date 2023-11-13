package com.goIt.Homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHomework11Application {

	public static void main(String[] args) {
		SpringApplication.from(Homework11Application::main).with(TestHomework11Application.class).run(args);
	}

}
