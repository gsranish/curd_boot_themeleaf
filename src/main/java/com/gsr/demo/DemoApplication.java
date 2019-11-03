package com.gsr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.gsr.demo"})
@EnableJpaRepositories(basePackages = {"com.gsr.demo.repo"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.gsr.demo.entity"})
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello Anish ! How are you??");
		SpringApplication.run(DemoApplication.class, args);
	}

}
