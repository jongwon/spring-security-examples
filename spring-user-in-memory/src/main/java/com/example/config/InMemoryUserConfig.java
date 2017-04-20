package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Configuration
public class InMemoryUserConfig {


	@Autowired
	public void configureGlobal(
			@SuppressWarnings("SpringJavaAutowiringInspection") AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
				.withUser("jongwon")
				.password("test")
				.roles("ADMIN");
	}

}
