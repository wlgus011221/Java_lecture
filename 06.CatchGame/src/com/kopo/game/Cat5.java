package com.kopo.game;

import java.util.Random;

public class Cat5 extends Base {
	Cat5(){
		super("막례");
		this.age = 9;
		this.gender = "암컷";
		this.speed = 5;
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
		System.out.println("낮잠 자던 새 한 마리만 깜짝 놀라 날아올랐습니다.");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(6);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 구석에서 조용히 잠들었다가 포박(?)당했다. 조용하지만 정이 가는 고양이예요.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
