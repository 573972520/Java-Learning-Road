package com.zsz.dto;

import java.util.Date;

public class UserDTO {
	private long id;
	private String phoneNum;
	private String passwordHash;
	private String passwordSalt;
	private Date createDateTime;
	private int loginErrorTimes;
	private Date lastLoginErrorDateTimes;
	private Long cityId; //可以为null
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public int getLoginErrorTimes() {
		return loginErrorTimes;
	}
	public void setLoginErrorTimes(int loginErrorTimes) {
		this.loginErrorTimes = loginErrorTimes;
	}
	public Date getLastLoginErrorDateTimes() {
		return lastLoginErrorDateTimes;
	}
	public void setLastLoginErrorDateTimes(Date lastLoginErrorDateTimes) {
		this.lastLoginErrorDateTimes = lastLoginErrorDateTimes;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
}
