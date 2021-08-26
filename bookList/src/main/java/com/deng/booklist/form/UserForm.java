package com.deng.booklist.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.deng.booklist.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserForm {
	
	@NotBlank(message = "帳號不可為空")
	private String username;
	
	@NotBlank(message = "暱稱不可為空")
	private String nickname;
	
	@NotBlank(message = "密碼不可為空")
	@Length(min = 6, message = "密碼最少6位數")
	private String password;
	
	@NotBlank(message = "確認密碼不可為空")
	@Length(min = 6, message = "密碼最少6位數")
	private String confirmPassword;
	
	@NotBlank
	@Pattern(regexp = "^09\\d{8}$", message = "請填寫正確手機號碼")
	private String phone;
	
	@NotBlank(message = "email不可為空")
	@Email(message = "請填寫正確email")
	private String email;
	
	private class UserFormConvert implements FormConvert<UserForm, User> {
		@Override
		public User convert(UserForm userForm) {
			User user = new User();
			BeanUtils.copyProperties(userForm, user);
			return user;
		}
	}
	
	public boolean confirmPassword() {
		if(this.getPassword().equals(this.getConfirmPassword())) {return true;}
		return false;
	}
	
	public User convertToUser() {
		User user = new UserFormConvert().convert(this);
		user.setSignDate(new Date());
		return user;
	}
}
