package com.example.demo.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	private String userId; // ユーザー ID
	private String password; // パスワード
	private String userName; // ユーザー 名
	@DateTimeFormat( pattern = "yyyy/ MM/ dd")
	private Date birthday; // 誕生日
	private int age; // 年齢
	private boolean marriage; // 結婚 ステータス
}