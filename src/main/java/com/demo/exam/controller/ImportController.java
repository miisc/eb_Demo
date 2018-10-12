package com.demo.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.exam.entity.Question;
import com.demo.exam.mapper.QuestionMapper;
import com.demo.exam.repo.QuestionRepo;
import com.demo.exam.util.ImportUtil;

@Controller
public class ImportController {
	private static final Logger log = LoggerFactory.getLogger(ImportController.class);

	QuestionRepo qRepo;
	QuestionMapper qMapper;

	public ImportController(QuestionMapper qMapper,QuestionRepo qRepo) {
		this.qMapper = qMapper;
		this.qRepo = qRepo;
	}

	@RequestMapping("/importExcel")
	// @ResponseBody
	public String Questions(Model model) {
		String filePath = "C:\\Users\\jine\\Downloads\\Book1.xlsx";

		List<Question> list = ImportUtil.importExcel(filePath, 0, 1, Question.class);

		qMapper.saveAll(list);
		int qCount = qRepo.count();
		model.addAttribute("qCount", qCount);

		log.info("Succeeded to import file " + filePath);
		return "index";
	}

	@RequestMapping("/")
	public String index(Model model) {
		int singleQuestionCount = qRepo.countByType("单选");
		int multipleQuestionCount = qRepo.countByType("多选");
		int trueFalseQuestionCount = qRepo.countByType("判断");

		model.addAttribute("singleQuestionCount", singleQuestionCount);
		model.addAttribute("multipleQuestionCount", multipleQuestionCount);
		model.addAttribute("trueFalseQuestionCount", trueFalseQuestionCount);
		
		Question q = qRepo.findById(1);
		List<Question> qlist = new ArrayList<Question>();
		qlist.add(q);
		qMapper.saveAll(qlist);		
		
		return "index";
	}
}
