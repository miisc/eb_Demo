package com.demo.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HfExamApplication {

	private static final Logger log = LoggerFactory.getLogger(HfExamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HfExamApplication.class, args);
		log.info("program started");
	}

	@Bean
	public CommandLineRunner mockData() {
		return (args) -> {
			// log.info(this.questionMapper.findById(11).toString());
			// log.info(this.questionMapper.findById(1).toString());
		};
	}
}
