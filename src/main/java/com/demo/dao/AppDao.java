package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.EmailPassword;
import com.demo.model.User;


@Repository
public class AppDao {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	public void saveEmailInfo(EmailPassword email) {
		mongoTemplate.save(email);
		
	}

	public void saveUserInfo(User user) {
		mongoTemplate.save(user);
		
	}
	


}
