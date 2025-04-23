package com.kopo.game;

import java.util.Random;

/***
 * Cat4 클래스
 * 네 번째 고양이 캐릭터 "깜자"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 깜자
 * - 나이: 2살
 * - 성별: 암컷
 * - 민첩성: 4
 */
public class Cat4 extends Base {
	/***
	 * Cat4의 기본 생성자
	 * 깜자의 기본 특성을 초기화합니다.
	 * - 이름을 "깜자"로 설정
	 * - 나이를 2살로 설정
	 * - 성별을 암컷으로 설정
	 * - 이동 민첩성을 4로 설정
	 */
	Cat4(){
		super("깜자");
		this.age = 2;
		this.gender = "암컷";
		this.speed = 4;
	}
	
	/***
	 * 깜자를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 깜자를 발견함
	 *         false: 깜자를 발견하지 못함
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
		System.out.println("희미한 발자국만 남아있고 고양이는 사라졌네요.");
		return false;
	}
	
	/***
	 * 깜자를 포획하는 메소드
	 * 20% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 깜자 포획 성공
	 *         false: 깜자 포획 실패
	 */
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
