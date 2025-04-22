package com.kopo.game;

import java.util.Random;

public class Cat3 extends Base {
	Cat3(){
		super("나비");
		this.age = 8;
		this.gender = "암컷";
		this.speed = 3;
	}
	
	@Override
	public boolean findCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println(this.name + "을(를) 발견했습니다!!");
			return true;
		}
		System.out.println("수풀 사이를 샅샅이 뒤졌지만 고양이는 없었습니다.");
		return false;
	}
	
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(4);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 밥그릇에 고개를 푹 박고 있다가 들켰다. 밥 욕심이 유별나답니다..");
			this.isCatch = true;
			return true;
		}
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
