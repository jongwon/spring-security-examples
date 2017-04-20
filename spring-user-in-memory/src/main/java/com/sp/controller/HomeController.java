package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Controller
public class HomeController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}


	@RequestMapping(value="/home")
	public String home(){
		return "home";
	}


	@RequestMapping(value="/hello")
	public String hello(){
		return "hello";
	}

}
