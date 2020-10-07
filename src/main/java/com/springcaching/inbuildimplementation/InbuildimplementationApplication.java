package com.springcaching.inbuildimplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InbuildimplementationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InbuildimplementationApplication.class, args);
    }

}
