package com.kopo.game;

import java.util.Random;

/***
 * Cat3 클래스
 * 세 번째 고양이 캐릭터 "나비"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 나비
 * - 나이: 8살
 * - 성별: 암컷
 * - 민첩성: 3
 */
public class Cat3 extends Base {
	/***
	 * Cat3의 기본 생성자
	 * 나비의 기본 특성을 초기화합니다.
	 * - 이름을 "나비"로 설정
	 * - 나이를 8살로 설정
	 * - 성별을 암컷으로 설정
	 * - 이동 민첩성을 3으로 설정
	 */
	Cat3(){
		super("나비");
		this.age = 8;
		this.gender = "암컷";
		this.speed = 3;
	}
	
	/***
	 * 나비를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 나비를 발견함
	 *         false: 나비를 발견하지 못함
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
		System.out.println("수풀 사이를 샅샅이 뒤졌지만 고양이는 없었습니다.");
		return false;
	}
	
	/***
	 * 나비를 포획하는 메소드
	 * 25% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 나비 포획 성공
	 *         false: 나비 포획 실패
	 */
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
		System.out.println("[포획 실패..]");
		System.out.println(this.name + "이(가) 도망쳤다...");
		return false;
	}
}
