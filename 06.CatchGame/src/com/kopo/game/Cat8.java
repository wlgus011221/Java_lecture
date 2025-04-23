package com.kopo.game;

import java.util.Random;

public class Cat8 extends Base {
	Cat8(){
		super("똘복이");
		this.age = 2;
		this.gender = "수컷";
		this.speed = 8;
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
		System.out.println("갑자기 바람이 불어 낙엽만 우수수 떨어졌습니다.");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(9);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 종이박스를 뒤엎다가 자기 몸이 갇혔다. 천하의 장난꾸러기답죠.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
