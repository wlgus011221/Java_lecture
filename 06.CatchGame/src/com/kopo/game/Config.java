package com.kopo.game;

import java.util.Scanner;

/***
 * Config 클래스
 * 게임의 전역 설정값과 공통으로 사용되는 상수들을 관리하는 클래스입니다.
 * 모든 상수는 public static final로 선언되어 어디서든 접근 가능합니다.
 */
public class Config {
	
	// 게임에 등장하는 총 고양이의 수
	// Cat1부터 Cat10까지 총 10마리의 고양이를 의미합니다.
	public static final int CAT_LENGTH = 10;
	
	// 게임의 최대 진행 가능 턴 수
	// 실질적으로 무제한에 가까운 큰 수를 설정했습니다.
	public static final int GAME_LENGTH = 999999999;
	
	// 게임 전체에서 공통으로 사용되는 Scanner 객체 (사용자 입력용)
	public static Scanner scanner = new Scanner(System.in);
}