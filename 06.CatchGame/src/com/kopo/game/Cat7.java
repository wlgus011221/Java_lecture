package com.kopo.game;

import java.util.Random;

/***
 * Cat7 클래스
 * 일곱 번째 고양이 캐릭터 "별순이"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 별순이
 * - 나이: 4살
 * - 성별: 암컷
 * - 민첩성: 7
 */
public class Cat7 extends Base {
	/***
	 * Cat7의 기본 생성자
	 * 별순이의 기본 특성을 초기화합니다.
	 * - 이름을 "별순이"로 설정
	 * - 나이를 4살로 설정
	 * - 성별을 암컷으로 설정
	 * - 이동 민첩성을 7로 설정
	 */
	Cat7(){
		super("별순이");
		this.age = 4;
		this.gender = "암컷";
		this.speed = 7;
	}
	
	/***
	 * 별순이를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 별순이를 발견함
	 *         false: 별순이를 발견하지 못함
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
		System.out.println("이상하네요, 분명 여기 있었던 것 같은데...");
		return false;
	}
	
	/***
	 * 별순이를 포획하는 메소드
	 * 약 13% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 별순이 포획 성공
	 *         false: 별순이 포획 실패
	 */
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
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
