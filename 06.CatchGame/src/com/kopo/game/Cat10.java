package com.kopo.game;

import java.util.Random;

public class Cat10 extends Base {
	Cat10(){
		super("복실이");
		this.age = 1;
		this.gender = "암컷";
		this.speed = 10;
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
		System.out.println("고양이 털 한 올도 안 보입니다. 어디 숨은 걸까요?");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(11);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 간식을 보자마자 폴짝 뛰어들었다. 털이 복슬복슬~ 보기만 해도 따뜻해요.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
