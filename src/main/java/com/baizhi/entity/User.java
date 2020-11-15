package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userId;
    private String email;
    private String password;
    private String salt;
    private String nickname;
    private String status;
    private String code;
    private Date createDate;
	public User(String userId, String email, String password, String salt,
			String nickname, String status, String code, Date createDate) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.createDate = createDate;
	}
	public User() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password="
				+ password + ", salt=" + salt + ", nickname=" + nickname
				+ ", status=" + status + ", code=" + code + ", createDate="
				+ createDate + "]";
	}
	
}
