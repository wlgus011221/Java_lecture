package com.kopo.game;

import java.util.Random;

public class Cat9 extends Base {
	Cat9(){
		super("칠복이");
		this.age = 7;
		this.gender = "수컷";
		this.speed = 9;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("기척을 느꼈지만, 이번에도 놓쳤네요...");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(10);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 떨어진 간식이 자기 앞으로 굴러오자 덥석! 그 운으로 또 잡혔네요.");
			this.isCatch = true;
			return true;
		}
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
