package com.limin.mywodwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MywodWebapp {

    public static void main(String[] args) {
        SpringApplication.run(MywodWebapp.class, args);
    }
}
