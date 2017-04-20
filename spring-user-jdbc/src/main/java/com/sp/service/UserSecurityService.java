package com.sp.service;

import com.sp.dao.UserRepository;
import com.sp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Service("userDetailsService")
public class UserSecurityService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		User user = userDao.findByEmail(username);
		return user;
	}


}
