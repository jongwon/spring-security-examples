package com.sp.dao;

import com.sp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);


}
