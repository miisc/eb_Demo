package com.demo.exam.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.exam.entity.User;
import com.demo.exam.repo.UserRepo;

@Controller
@SessionAttributes(types = { User.class }, value = { "user" })
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserRepo userRepo;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, User user, BindingResult result,
			Model model) {
		String username = user.getUsername();
		String password = user.getPassword();

		if (username == "") {
			log.error("username is blank");
			result.rejectValue("username", "", "username is blank");
			return "index";
		}

		if (password == "") {
			log.error("password is blank");
			result.rejectValue("password", "", "password is blank");
			return "index";
		}

		User loginUser = userRepo.verifyUser(username, password);
		if (loginUser == null) {
			log.error("no such an user");
			result.reject("notFound", "can not find this user");
			user.setUsername("");
			return "index";
		} else {
			log.info("succeeded to login and write cookie");
			user = loginUser;
			model.addAttribute(user);
			
			log.debug("username: " + user.getUsername());
			log.debug("password: " + user.getPassword());
			log.debug("role: " + user.getRole());
			
			Cookie userNameCookie = new Cookie("username", user.getUsername());
			Cookie pwdCookie = new Cookie("password", user.getPassword());
			Cookie roleCookie = new Cookie("role", user.getRole());
			userNameCookie.setMaxAge(3600);
			pwdCookie.setMaxAge(3600);
			roleCookie.setMaxAge(3600);
			userNameCookie.setPath("/");
			pwdCookie.setPath("/");
			roleCookie.setPath("/");
			response.addCookie(userNameCookie);
			response.addCookie(pwdCookie);
			response.addCookie(roleCookie);
			
			return "index";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {

		User loginUser = (User) request.getSession().getAttribute("user");
		// 删除登录cookie
		Cookie userNameCookie = new Cookie("username", loginUser.getUsername());
		Cookie passwordCookie = new Cookie("password", loginUser.getPassword());
		Cookie roleCookie = new Cookie("role", loginUser.getRole());
		userNameCookie.setMaxAge(0);
		userNameCookie.setPath("/");
		passwordCookie.setMaxAge(0);
		passwordCookie.setPath("/");
		roleCookie.setMaxAge(0);
		roleCookie.setPath("/");
		response.addCookie(userNameCookie);
		response.addCookie(passwordCookie);
		response.addCookie(roleCookie);
		
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		request.getSession().removeAttribute("role");
		
		model.addAttribute("user", new User());
		return "redirect:/";
	}
}
