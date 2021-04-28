package com.exam.exameureka7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangtao
 */
@SpringBootApplication
@EnableEurekaServer
public class ExamEureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamEureka7002Application.class, args);
    }

}
