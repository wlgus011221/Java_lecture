package com.kopo.game;

public class Base {
	String name;
	int age;
	String gender;
	int speed;
	
	boolean isCatch = false;
	
	Base(){
		this.name = "기본";
	}
	
	Base(String name){
		this.name = name;
	}
	
	public boolean findCat() {
		return true;
	}
	
	public boolean catchCat() {
		return true;
	}
}
