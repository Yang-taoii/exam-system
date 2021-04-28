package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExamSubjectQuestionTaskProvider8020Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamSubjectQuestionTaskProvider8020Application.class, args);
    }

}
