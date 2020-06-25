package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.service.UserService;

@Controller
public class HomeController {

@Autowired
UserService userService;

//ホーム画面のGETメソッド
@GetMapping("/home")
public String getHome(Model model) {

//コンテンツ部分にホーム画面を表示するための文字列を登録
model.addAttribute("contents", "login/home :: home_contents");

return "login/homeLayout";
}

@GetMapping("/userList")
public String getUserList(Model model) {
	model.addAttribute("contents", "login/userList :: userList_contents");
	List<User> userList = userService.selectMany();
	model.addAttribute("uesrList", userList);
	int count = userService.count();
	model.addAttribute("userListCount", count);
	return "login/homeLayout";
}

//ログアウト用メソッド
@GetMapping("/logout")
public String postLogout() {

//ログイン画面にリダイレクト
return "redirect:/login";
	}

@GetMapping("/userList/csv")
public String getUserListCsv(Model model) {
	return getUserList(model);
	}
}