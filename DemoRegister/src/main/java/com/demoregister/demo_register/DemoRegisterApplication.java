package com.demoregister.demo_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRegisterApplication.class, args);
    }

}
