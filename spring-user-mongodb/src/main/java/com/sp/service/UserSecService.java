package com.sp.service;

import com.sp.dao.UserDao;
import com.sp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by jongwon on 2017. 4. 21..
 */
@Service("userDetailsService")
public class UserSecService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public void saveUser(User user){
		userDao.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findUserByEmail(username);
	}

	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
