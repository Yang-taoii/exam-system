package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExamGateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamGateway9527Application.class, args);
    }

}
