package com.kopo.game;

import java.util.Random;

/***
 * Cat6 클래스
 * 여섯 번째 고양이 캐릭터 "뚱자"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 뚱자
 * - 나이: 9살
 * - 성별: 수컷
 * - 민첩성: 6
 */
public class Cat6 extends Base {
	/***
	 * Cat6의 기본 생성자
	 * 뚱자의 기본 특성을 초기화합니다.
	 * - 이름을 "뚱자"로 설정
	 * - 나이를 9살로 설정
	 * - 성별을 수컷으로 설정
	 * - 이동 민첩성을 6으로 설정
	 */
	Cat6(){
		super("뚱자");
		this.age = 9;
		this.gender = "수컷";
		this.speed = 6;
	}
	
	/***
	 * 뚱자를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 뚱자를 발견함
	 *         false: 뚱자를 발견하지 못함
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
		System.out.println("소리 하나 없이 고요합니다. 고양이도 숨을 죽인 걸까요?");
		return false;
	}
	
	/***
	 * 뚱자를 포획하는 메소드
	 * 약 14% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 뚱자 포획 성공
	 *         false: 뚱자 포획 실패
	 */
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
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
