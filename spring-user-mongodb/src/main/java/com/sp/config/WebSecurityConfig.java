package com.sp.config;

import com.sp.service.UserSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by jongwon on 2017. 4. 21..
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private UserSecService userSecService;

	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userSecService)
		.passwordEncoder(bCryptPasswordEncoder);
	}



	@Override
	public void init(WebSecurity webSecurity) throws Exception {
		super.init(webSecurity);

		System.out.println("===============");
		System.out.println(" Security config 초기화 했어요...");
		System.out.println("===============");

		// ADMIN, USER  role 이 없으면 추가한다.


	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/hello").hasAuthority("ADMIN")
				.anyRequest()
				.authenticated().and()
				.csrf()
				.disable()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/hello")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");


	}

	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/resources/**", "/static/**",
						"/css/**", "/js/**", "/images/**");

	}


}
