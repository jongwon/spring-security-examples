package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/", "/home")
					.permitAll()
				.anyRequest()
					.authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.failureUrl("/login?error=true")
					.defaultSuccessUrl("/hello")
					.permitAll()
					.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/home")
					.permitAll();
	}

}
