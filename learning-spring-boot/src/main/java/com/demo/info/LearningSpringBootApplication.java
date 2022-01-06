package com.demo.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//Need configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"com.demo.info>"})
//@EnableJpaRepositories(basePackages="com.demo.info.repository")
//@EnableTransactionManagement
//@EntityScan(basePackages="com.demo.info.model")
public class LearningSpringBootApplication {
	  // private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LearningSpringBootApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(LearningSpringBootApplication.class, args);
		
	}

}

