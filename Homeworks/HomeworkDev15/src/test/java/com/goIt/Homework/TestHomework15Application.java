package com.goIt.Homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHomework15Application {

	public static void main(String[] args) {
		SpringApplication.from(Homework15Application::main).with(TestHomework15Application.class).run(args);
	}

}
