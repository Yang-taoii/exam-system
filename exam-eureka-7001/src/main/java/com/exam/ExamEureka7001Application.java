package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangtao
 */
@SpringBootApplication
@EnableEurekaServer
public class ExamEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamEureka7001Application.class, args);
    }

}
