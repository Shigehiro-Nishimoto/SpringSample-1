package com.example.demo.login.domain.model.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.model.service.RestService;
import com.example.demo.login.domain.repository.UserDao;

@Transactional
@Service
public class RestServiceJdbcImpl implements

RestService {

@Autowired
@Qualifier("UserDaoJdbcImpl")
UserDao dao;

@Override
public boolean insert(User user) {
return false;
}

@Override
public User selectOne(String userId) {
return null;
}

@Override
public List<User> selectMany() {
return null;
}

@Override
public boolean update(User user) {
return false;
}

@Override
public boolean delete(String userId) {
return false;
	}
}