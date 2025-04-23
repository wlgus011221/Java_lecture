package com.kopo.game;

import java.util.Random;

/***
 * Cat2 클래스
 * 두 번째 고양이 캐릭터 "춘배"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 춘배
 * - 나이: 7살
 * - 성별: 수컷
 * - 민첩성: 2
 */
public class Cat2 extends Base {
	/***
	 * Cat2의 기본 생성자
	 * 춘배의 기본 특성을 초기화합니다.
	 * - 이름을 "춘배"로 설정
	 * - 나이를 7살로 설정
	 * - 성별을 수컷으로 설정
	 * - 이동 민첩성을 2로 설정
	 */
	Cat2(){
		super("춘배");
		this.age = 7;
		this.gender = "수컷";
		this.speed = 2;
	}
	
	/***
	 * 춘배를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 춘배를 발견함
	 *         false: 춘배를 발견하지 못함
	 */
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
	
	/***
	 * 춘배를 포획하는 메소드
	 * 약 33% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 춘배 포획 성공
	 *         false: 춘배 포획 실패
	 */
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
