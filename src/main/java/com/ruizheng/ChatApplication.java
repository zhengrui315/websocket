package com.ruizheng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ChatApplication {
    public static void main(String[] args) {
        System.out.println("RZ: starting SpringBoot Application.");
        log.info("RZ: starting chat app");
        SpringApplication.run(ChatApplication.class, args);
    }
}