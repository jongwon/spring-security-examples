package com.sp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by jongwon on 2017. 4. 20..
 *
 * 참고 : http://stackoverflow.com/questions/35218354/difference-between-registerglobal-configure-configureglobal-configureglo
 */
//@EnableWebSecurity
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity
@EnableGlobalAuthentication
public class SecurityConfigGlobal {

	@Autowired
	public void configureGlobal(
			@SuppressWarnings("SpringJavaAutowiringInspection") AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
				.withUser("jongwon")
				.password("test3")
				.roles("ADMIN");
	}

}
