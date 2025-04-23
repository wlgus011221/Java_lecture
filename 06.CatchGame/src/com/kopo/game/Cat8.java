package com.kopo.game;

import java.util.Random;

/***
 * Cat8 클래스
 * 여덟 번째 고양이 캐릭터 "똘복이"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 똘복이
 * - 나이: 2살
 * - 성별: 수컷
 * - 민첩성: 8
 */
public class Cat8 extends Base {
	/***
	 * Cat8의 기본 생성자
	 * 똘복이의 기본 특성을 초기화합니다.
	 * - 이름을 "똘복이"로 설정
	 * - 나이를 2살로 설정
	 * - 성별을 수컷으로 설정
	 * - 이동 민첩성을 8로 설정
	 */
	Cat8(){
		super("똘복이");
		this.age = 2;
		this.gender = "수컷";
		this.speed = 8;
	}
	
	/***
	 * 똘복이를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 똘복이를 발견함
	 *         false: 똘복이를 발견하지 못함
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
		System.out.println("갑자기 바람이 불어 낙엽만 우수수 떨어졌습니다.");
		return false;
	}
	
	/***
	 * 똘복이를 포획하는 메소드
	 * 약 11% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 똘복이 포획 성공
	 *         false: 똘복이 포획 실패
	 */
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
