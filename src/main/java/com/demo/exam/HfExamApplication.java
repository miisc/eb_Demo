package com.demo.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.exam.repo.QuestionRepo;

@SpringBootApplication
public class HfExamApplication {

	private static final Logger log = LoggerFactory.getLogger(HfExamApplication.class);

	@Autowired
	QuestionRepo qRepo;

	public static void main(String[] args) {
		SpringApplication.run(HfExamApplication.class, args);
		log.info("program started");
	}

	@Bean
	public CommandLineRunner mockData() {
		return (args) -> {

			// for (int i = 1; i <= 10; i++) {
			// qRepo.save(new Question("question" + i, "answer" + i));
			// }

			// List<Question> qList = new ArrayList<Question>();
			// for (Question q : qRepo.findAll()) {
			// qList.add(q);
			// log.debug(q.toString());
			// }

		};
	}
}
