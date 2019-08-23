package com.demo.eb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "index";
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/index";
	}
	
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("recordCount",0);
		return "search";
	}
	
}
