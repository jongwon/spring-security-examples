package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@RestController
public class TestController {

	@RequestMapping(value="/hello")
	public String hello(){
		return "hello jongwon aa";
	}

}
