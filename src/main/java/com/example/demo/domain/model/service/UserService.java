package com.example.demo.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.repository.UserDao;

@Service
public class UserService {

@Autowired
UserDao dao;
}