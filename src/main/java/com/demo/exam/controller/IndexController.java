package com.demo.exam.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.exam.entity.User;
import com.demo.exam.repo.QuestionRepo;
import com.demo.exam.repo.UserRepo;

@Controller
@SessionAttributes(types = { User.class }, value = { "user" })
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	UserRepo userRepo;

	QuestionRepo qRepo;

	public IndexController(QuestionRepo qRepo) {
		this.qRepo = qRepo;
	}

	/*
	 * No cookie or no UserName in cookie: first login, show login form Found
	 * cookie: show user name, no login form and auto login
	 */
	@RequestMapping("/")
	public String index(User user, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			user.setUsername("");
			log.debug("no cookie now and need to login" );
			return "index";
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username") && cookie.getValue() != null) {
				user.setUsername(cookie.getValue());
				log.debug("found cookie now and this user is logged before, username: " + user.getUsername());
			}
		}

		model.addAttribute("user", user);
		log.debug("username: " + user.getUsername()+ " password: " + user.getPassword()+" role: " + user.getRole());

		int singleQuestionCount = qRepo.countByType("单选");
		int multipleQuestionCount = qRepo.countByType("多选");
		int trueFalseQuestionCount = qRepo.countByType("判断");

		model.addAttribute("singleQuestionCount", singleQuestionCount);
		model.addAttribute("multipleQuestionCount", multipleQuestionCount);
		model.addAttribute("trueFalseQuestionCount", trueFalseQuestionCount);

		return "index";
	}
}
