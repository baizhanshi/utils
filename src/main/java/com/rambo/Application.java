package com.rambo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Configuration
@Slf4j
@ComponentScan(value = "com.rambo")
public class Application {

    public static void main(String[] args) {
        log.info("==================Application start .......======================");
        System.setProperty("DEPLOY_ENV", "test");
        SpringApplication.run(Application.class, args);
        log.info("==================Application start success======================");
    }
}
