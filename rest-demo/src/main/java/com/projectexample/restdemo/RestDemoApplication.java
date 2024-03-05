package com.projectexample.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@EnableJpaRepositories("CloudVendorRepository")
public class RestDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestDemoApplication.class, args);
	}
	@Bean
		public  RestTemplate restTemplate()
		{
			return new RestTemplate();
		}



}
