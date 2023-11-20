package com.goIt.Homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHomework14Application {

	public static void main(String[] args) {
		SpringApplication.from(Homework14Application::main).with(TestHomework14Application.class).run(args);
	}

}
