package com.example.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ConfigurationProperties
@ComponentScan(basePackages="com.example")
@EntityScan(basePackages="com.example.bean")
@EnableJpaRepositories(basePackages="com.example.Dao")
//@EnableAutoConfiguration  整个scan和路径有关，如果在根包也许不需要scan这么多
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);  
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}
