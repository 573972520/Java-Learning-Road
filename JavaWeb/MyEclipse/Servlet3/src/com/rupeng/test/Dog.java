package com.rupeng.test;

public class Dog {
	private int id;
	private String name;
	private Person master;
	private String birthDay;
	
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
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
	public Person getMaster() {
		return master;
	}
	public void setMaster(Person master) {
		this.master = master;
	}
	
}
