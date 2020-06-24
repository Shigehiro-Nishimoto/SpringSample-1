//登録画面で、入力するときの規則を定める。

package com.example.demo.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
//アノテーションを用いて、入力ルールをつくる。

	@NotBlank(groups=ValidGroup1.class, message="{require_check}")
	@Email(groups=ValidGroup2.class, message="{email_check}")
	private String userId; // ユーザー ID

	@NotBlank(groups=ValidGroup1.class, message="{require_check}")
	@Length(groups=ValidGroup2.class, min=4, max=100, message="{length_check}")
	@Pattern(groups=ValidGroup3.class, regexp="^[a-zA-Z0-9]+$", message="{pattern_check}")
	private String password; // パスワード

	@NotBlank(groups=ValidGroup1.class, message="{require_check}")
	private String userName; // ユーザー 名

	@NotNull(groups=ValidGroup1.class, message="{require_check}")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; // 誕生日

	@Min(groups=ValidGroup2.class, value=20, message="{min_check}")
	@Max(message="{max_check}", value=100, groups=ValidGroup2.class)
	private int age; // 年齢

	@AssertFalse(groups=ValidGroup2.class, message="{false_check}")
	private boolean marriage; // 結婚 ステータス
}