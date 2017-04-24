package com.sp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by jongwon on 2017. 4. 21..
 *
 */
@Document(collection = "sp_user")
public class User implements UserDetails {

	@Id
	private String id;

	@Indexed(unique=true)
	private String email;

	private String name;

	private String password;

	private Set<Role> roles;

	private boolean enabled;

	private boolean expired;

	private boolean locked;

	private boolean credentialExpired;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setCredentialExpired(boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !expired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
