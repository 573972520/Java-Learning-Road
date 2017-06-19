package com.rupeng.test;

import java.sql.Date;

public class StudentInfo {

	private int id;
	private String name;
	private boolean gender;
	private Date birthDay;
	private int classId;
	private boolean teChangSheng;
	private int minZuId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	//对于boolean类型的属性，获取方法即可以以get开头，也可以以is开头
	//如果is、get都存在，那么以is为准
	
	/*public boolean setTeChangSheng() {
		return teChangSheng;
	}*/
	public boolean isTeChangSheng() {
		return teChangSheng;
	}
	public void setTeChangSheng(boolean teChangSheng) {
		this.teChangSheng = teChangSheng;
	}
	public int getMinZuId() {
		return minZuId;
	}
	public void setMinZuId(int minZuId) {
		this.minZuId = minZuId;
	}
	
	
	
}
