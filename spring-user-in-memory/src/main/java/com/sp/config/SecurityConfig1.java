package com.sp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 어떤 메쏘드이든 AuthenticationManagerBuilder 를 받아서 직접 설정해 주면 된다.
 *
 * 참고 : http://stackoverflow.com/questions/35218354/difference-between-registerglobal-configure-configureglobal-configureglo
 *
 * Created by jongwon on 2017. 4. 24..
 */
//@EnableWebSecurity
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity
//@EnableGlobalAuthentication
public class SecurityConfig1 {

	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("jongwon").password("test1").roles("ADMIN").and()
				.withUser("jongwon2").password("test12").roles("USER","ADMIN");
	}

}
