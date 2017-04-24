package com.sp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 참고 : http://stackoverflow.com/questions/35218354/difference-between-registerglobal-configure-configureglobal-configureglo
 *
 * IN memory로 security 를 테스트 할 때는 다음 네가지 annotation 들 중에 아무거나 한가지 선언한 빈에서
 *	- @EnableWebSecurity,  @EnableWebMvcSecurity, @EnableGlobalMethodSecurity, @EnableGlobalAuthentication
 *
 *  UserDetailsService 를 정의히거나, AuthenticationManagerBuilder 를 autowired 시켜서 직접 security 를 설정해주면 된다.
 *
 *
 * Created by jongwon on 2017. 4. 24..
 *
 */
//@EnableWebSecurity
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity
//@EnableGlobalAuthentication
public class SecurityConfig2 {

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("jongwon").password("test1").roles("ADMIN").build());
		return manager;
	}
}
