package com.demo.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AppDao;
import com.demo.model.EmailPassword;
import com.demo.model.User;

@Service
public class AppService {
	@Autowired
	AppDao appDao;

	public void saveEmail(JSONObject jsonObject) {
		
		appDao.saveEmailInfo(new EmailPassword(jsonObject.getString("email"), jsonObject.getString("password")));	
	}

	public void saveUserInfo(JSONObject jsonObject) {
		User user=new User();
		user.setUserId(jsonObject.getInt("UserId"));
		user.setUserName(jsonObject.getString("Username"));
		user.setDepartment(jsonObject.getString("Department"));
		user.setEmail(jsonObject.getString("Email"));
		user.setFirstName(jsonObject.getString("FirstName"));
		user.setLastName(jsonObject.getString("LastName"));
		user.setLocation(jsonObject.getString("Location"));
		appDao.saveUserInfo(user);
		
	}

}
