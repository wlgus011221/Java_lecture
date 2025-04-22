package com.kopo.game;

import java.util.Random;

public class Cat1 extends Base {
	
	Cat1(){
		super("춘식이");
		this.age = 3;
		this.gender = "수컷";
		this.speed = 1;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("풀숲을 열심히 찾았지만 아무 수확이 없었습니다..");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 야옹 소리를 내며 다가왔습니다.");
			this.isCatch = true;
			return true;
		}
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
