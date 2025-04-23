package com.kopo.game;

import java.util.Random;

public class Cat2 extends Base {
	Cat2(){
		super("춘배");
		this.age = 7;
		this.gender = "수컷";
		this.speed = 2;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println("[탐색 성공]");
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("[탐색 실패]");
		System.out.println("무심코 돌멩이를 들었지만... 벌레만 있었네요.");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(3);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 당신의 손에 고롱고롱하며 따라옵니다.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
