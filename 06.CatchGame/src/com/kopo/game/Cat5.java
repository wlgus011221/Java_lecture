package com.kopo.game;

import java.util.Random;

/***
 * Cat5 클래스
 * 다섯 번째 고양이 캐릭터 "막례"를 구현한 클래스입니다.
 * Base 클래스를 상속받아 기본적인 고양이의 특성을 확장합니다.
 * 
 * 특징:
 * - 이름: 막례
 * - 나이: 9살
 * - 성별: 암컷
 * - 민첩성: 5
 */
public class Cat5 extends Base {
	/***
	 * Cat5의 기본 생성자
	 * 막례의 기본 특성을 초기화합니다.
	 * - 이름을 "막례"로 설정
	 * - 나이를 9살로 설정
	 * - 성별을 암컷으로 설정
	 * - 이동 민첩성을 5로 설정
	 */
	Cat5(){
		super("막례");
		this.age = 9;
		this.gender = "암컷";
		this.speed = 5;
	}
	
	/***
	 * 막례를 찾는 메소드
	 * 50% 확률로 고양이를 발견할 수 있습니다.
	 * 
	 * @return boolean - 고양이 발견 성공 여부
	 *         true: 막례를 발견함
	 *         false: 막례를 발견하지 못함
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
		System.out.println("낮잠 자던 새 한 마리만 깜짝 놀라 날아올랐습니다.");
		return false;
	}
	
	/***
	 * 막례를 포획하는 메소드
	 * 약 17% 확률로 고양이를 잡을 수 있습니다.
	 * 성공 시 isCatch 상태가 true로 변경됩니다.
	 * 
	 * @return boolean - 포획 성공 여부
	 *         true: 막례 포획 성공
	 *         false: 막례 포획 실패
	 */
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
