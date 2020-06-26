package com.example.demo.domain.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.repository.UserDao;

@Service
public class UserService {

@Autowired
UserDao dao;

public boolean insert(User user) {

int rowNumber = dao.insertOne(user);
boolean result = false;
if(rowNumber > 0) {
result = true;
	}
return result;
}

public int count() {

return dao.count();
}

public List<User> selectMany() {

return dao.selectMany();
	}

public User selectOne(String userId) {
	//selectOne実行

	return dao.selectOne(userId);
	}
}