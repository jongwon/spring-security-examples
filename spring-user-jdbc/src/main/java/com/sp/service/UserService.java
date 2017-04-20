package com.sp.service;

import com.sp.dao.RoleRepository;
import com.sp.dao.UserRepository;
import com.sp.domain.Role;
import com.sp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		user.setRoles(new HashSet<Role>(Arrays.asList(
				roleRepository.findByRole("ADMIN"),
				roleRepository.findByRole("USER")
		)));
		userRepository.save(user);
	}

}
