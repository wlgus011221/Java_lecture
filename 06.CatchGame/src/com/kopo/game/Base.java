package com.kopo.game;

/***
 * Base 클래스
 * 게임의 기본이 되는 클래스로, 고양이의 기본 속성과 행동을 정의합니다.
 * 모든 고양이들의 부모 클래스 역할을 합니다.
 */
public class Base {
	// 고양이의 이름을 저장하는 변수
	String name;
	
	// 고양이의 나이를 저장하는 변수
	int age;
	
	// 고양이의 성별을 저장하는 변수
	String gender;
	
	// 고양이의 민첩성을 나타내는 변수 (높을수록 잡기 어려움)
	int speed;
	
	// 고양이를 잡았는지 여부를 저장하는 변수 (true: 잡은 상태, false: 아직 잡지 못한 상태)
	boolean isCatch = false;
	
	/***
	 * 기본 생성자
	 * 이름을 "기본"으로 초기화합니다.
	 */
	Base(){
		this.name = "기본";
	}
	
	/***
	 * 매개변수가 있는 생성자
	 * @param name 고양이의 이름
	 */
	Base(String name){
		this.name = name;
	}
	
	/***
	 * 고양이를 찾는 메소드
	 * @return 고양이를 찾으면 true, 못 찾으면 false를 반환
	 */
	public boolean findCat() {
		return true;
	}
	
	/***
	 * 고양이를 잡는 메소드
	 * @return 고양이를 잡으면 true, 못 잡으면 false를 반환
	 */
	public boolean catchCat() {
		return true;
	}
}
