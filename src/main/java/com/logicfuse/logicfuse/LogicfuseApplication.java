package com.logicfuse.logicfuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication   
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.logicfuse.logicfuse"})
@EnableJpaRepositories(basePackages="com.logicfuse.logicfuse.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.logicfuse.logicfuse.models")	
public class LogicfuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogicfuseApplication.class, args);
	}

}
