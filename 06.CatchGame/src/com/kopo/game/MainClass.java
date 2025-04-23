package com.kopo.game;

/***
 * MainClass 클래스
 * 프로그램의 진입점(Entry Point)이 되는 메인 클래스입니다.
 * GameManager를 생성하고 게임을 시작하는 역할을 합니다.
 */
public class MainClass {
	/***
	 * 프로그램의 시작점이 되는 main 메소드
	 * GameManager 객체를 생성하고 run() 메소드를 호출하여 게임을 시작합니다.
	 * 
	 * @param args 명령행 매개변수 (사용하지 않음)
	 */
	public static void main(String[] args) {
		GameManager g = new GameManager();
		g.run();
	}
}
