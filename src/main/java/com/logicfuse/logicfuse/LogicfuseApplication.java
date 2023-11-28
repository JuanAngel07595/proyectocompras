package com.logicfuse.logicfuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
