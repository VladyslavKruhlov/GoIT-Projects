package com.goIt.Homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHomework12Application {

	public static void main(String[] args) {
		SpringApplication.from(Homework12Application::main).with(TestHomework12Application.class).run(args);
	}

}
