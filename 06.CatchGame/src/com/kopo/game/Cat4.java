package com.kopo.game;

import java.util.Random;

public class Cat4 extends Base {
	Cat4(){
		super("깜자");
		this.age = 2;
		this.gender = "암컷";
		this.speed = 4;
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
		System.out.println("희미한 발자국만 남아있고 고양이는 사라졌네요.");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(5);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 호기심에 손가락을 톡 건드리다 덥석 잡혔다. 날쌔지만 가끔 실수해요.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
