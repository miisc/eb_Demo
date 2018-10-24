package com.demo.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class AuthorizedInterceptor implements HandlerInterceptor {

	public static final Logger log = Logger.getLogger(AuthorizedInterceptor.class);

	// before controller
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
		//log.debug("pre handle");
		return true;
	}

	// after controller
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView mv) {
	//	log.debug("post handle");
	}

	//after render view to clean resource
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) {
	//	log.debug("after completion");
	}
}
