package com.limin.mywod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
public class MywodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywodApplication.class, args);
	}
}
