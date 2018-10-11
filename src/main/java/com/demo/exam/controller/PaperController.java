package com.demo.exam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.exam.entity.Paper;
import com.demo.exam.entity.Question;
import com.demo.exam.repo.PaperRepo;
import com.demo.exam.repo.QuestionRepo;

@Controller
public class PaperController {

	private static final Logger log = LoggerFactory.getLogger(PaperController.class);

	@Autowired
	QuestionRepo qRepo;

	@Autowired
	PaperRepo pRepo;

	// @RequestMapping("/learning/queryByPage/{pageNumber:[0-9]*}")
	// @PathVariable

	@RequestMapping("/generatePaper")
	public String generatePaper(@RequestParam(required = false, defaultValue = "5", value = "count") int count,
			Model model) {
		int total = (int) qRepo.count();
		List<Question> qList = new ArrayList<Question>();
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			int id = r.nextInt((int) total) + 1;
			qRepo.findById((long) id).ifPresent(q -> {
				qList.add(q);
			});
		}
		Paper paper = new Paper();	
		paper.setQuestions(qList);
		paper.setAnswers(new ArrayList<String>());
		model.addAttribute("paper", paper);

		log.info("paper generated");
		return "paper";
	}

	@RequestMapping("/checkPaper")
	public String checkPaper(Paper paper, Model model) {

		return "forward:/";
	}
}
