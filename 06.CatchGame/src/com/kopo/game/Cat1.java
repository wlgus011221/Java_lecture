package com.kopo.game;

import java.util.Random;

/***
 * Cat1 클래스
 * 첫 번째 고양이 캐릭터 "춘식이"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 춘식이
 * - 나이: 3살
 * - 성별: 수컷
 * - 민첩성: 1
 */
public class Cat1 extends Base {
	
	/***
	 * Cat1의 기본 생성자
	 * 춘식이의 기본 특성을 초기화합니다.
	 * - 이름을 "춘식이"로 설정
	 * - 나이를 3살로 설정
	 * - 성별을 수컷으로 설정
	 * - 이동 민첩성를 1로 설정
	 */
	Cat1(){
		super("춘식이");
		this.age = 3;
		this.gender = "수컷";
		this.speed = 1;
	}
	
	/***
	 * 춘식이를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 춘식이를 발견함
	 *         false: 춘식이를 발견하지 못함
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
		System.out.println("풀숲을 열심히 찾았지만 아무 수확이 없었습니다..");
		return false;
	}
	
	/***
	 * 춘식이를 포획하는 메소드
	 * 50% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 춘식이 포획 성공
	 *         false: 춘식이 포획 실패
	 */
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(2);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 야옹 소리를 내며 다가왔습니다.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
