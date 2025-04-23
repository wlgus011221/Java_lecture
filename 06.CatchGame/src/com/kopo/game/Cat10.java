package com.kopo.game;

import java.util.Random;

/***
 * Cat10 클래스
 * 열 번째 고양이 캐릭터 "복실이"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 복실이
 * - 나이: 1살
 * - 성별: 암컷
 * - 민첩성: 10
 */
public class Cat10 extends Base {
	/***
	 * Cat10의 기본 생성자
	 * 복실이의 기본 특성을 초기화합니다.
	 * - 이름을 "복실이"로 설정
	 * - 나이를 1살로 설정
	 * - 성별을 암컷으로 설정
	 * - 이동 민첩성을 10으로 설정
	 */
	Cat10(){
		super("복실이");
		this.age = 1;
		this.gender = "암컷";
		this.speed = 10;
	}
	
	/***
	 * 복실이를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 복실이를 발견함
	 *         false: 복실이를 발견하지 못함
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
		System.out.println("고양이 털 한 올도 안 보입니다. 어디 숨은 걸까요?");
		return false;
	}
	
	/***
	 * 복실이를 포획하는 메소드
	 * 약 9% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 복실이 포획 성공
	 *         false: 복실이 포획 실패
	 */
	@Override
	public boolean catchCat() {
		Random random = new Random();
		int randNumber = random.nextInt(11);
		if(randNumber==1) {
			System.out.println("[잡았다!]");
			System.out.println(this.name + "가(이) 간식을 보자마자 폴짝 뛰어들었다. 털이 복슬복슬~ 보기만 해도 따뜻해요.");
			this.isCatch = true;
			return true;
		}
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
