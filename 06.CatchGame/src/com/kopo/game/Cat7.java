package com.kopo.game;

import java.util.Random;

public class Cat7 extends Base {
	Cat7(){
		super("별순이");
		this.age = 4;
		this.gender = "암컷";
		this.speed = 7;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("이상하네요, 분명 여기 있었던 것 같은데...");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(8);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 별을 보며 멍때리다 살금살금 다가간 손에 걸렸다. 로맨틱 고양이에요.");
			this.isCatch = true;
			return true;
		}
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
