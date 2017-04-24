package com.sp.dao;

import com.sp.domain.User;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by jongwon on 2017. 4. 21..
 */
@Repository
public class UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;


	public User findByEmail(String email){
		return mongoTemplate.findOne(Query.query(Criteria.where("email").is(email)), User.class);
	}

	public void save(User user) {
		mongoTemplate.save(user);
	}


}
