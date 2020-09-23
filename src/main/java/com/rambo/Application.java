package com.rambo;

import java.io.IOException;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

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

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        return Redisson.create(Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream()));
    }
}
