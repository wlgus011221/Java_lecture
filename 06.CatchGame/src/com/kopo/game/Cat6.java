package com.kopo.game;

import java.util.Random;

public class Cat6 extends Base {
	Cat6(){
		super("뚱자");
		this.age = 9;
		this.gender = "수컷";
		this.speed = 6;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("소리 하나 없이 고요합니다. 고양이도 숨을 죽인 걸까요?");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(7);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 방 한가운데 떡하니 누워 있다가 느릿느릿 붙잡혔다. 움직임엔 관심이 없어요.");
			this.isCatch = true;
			return true;
		}
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
