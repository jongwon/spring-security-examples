package com.sp.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by jongwon on 2017. 4. 21..
 */
public class Role implements GrantedAuthority {

	private String role;

	public Role(){

	}

	public Role(String role){
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}

}
