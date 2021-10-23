package com.rambo;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
@Configuration
@Slf4j
@ComponentScan(value = "com.rambo")
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {
        log.info("==================Application start .......======================");
        System.setProperty("DEPLOY_ENV", "test123");
        SpringApplication.run(Application.class, args);
        log.info("==================Application start success======================");
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        return Redisson.create(Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream()));
    }
}
