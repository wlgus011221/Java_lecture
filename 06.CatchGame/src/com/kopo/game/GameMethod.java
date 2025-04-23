package com.kopo.game;

import java.util.Random;

public class GameMethod {
	Base[] b = new Base[Config.CAT_LENGTH];
	int count = 0; // 잡은 고양이수

	public GameMethod() {
		this.b[0] = new Cat1();
		this.b[1] = new Cat2();
		this.b[2] = new Cat3();
		this.b[3] = new Cat4();
		this.b[4] = new Cat5();
		this.b[5] = new Cat6();
		this.b[6] = new Cat7();
		this.b[7] = new Cat8();
		this.b[8] = new Cat9();
		this.b[9] = new Cat10();
	}

	// 고양이 전체 목록 출력
	public void printAll() {
		System.out.println("고양이 수배 목록");
		for (int i = 0; i < Config.CAT_LENGTH; i++) {
			System.out.println((i + 1) + "번째 고양이");
			System.out.print(this.b[i].name + "(");
			if (this.b[i].isCatch == true) {
				System.out.println(" O )");
			} else {
				System.out.println(" X )");
			}
		}

		System.out.println();
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			System.out.println();
			System.out.println("상세 조회를 원하는 고양이의 번호를 입력해주세요. (나가기 q)");

			String input = Config.scanner.nextLine();

			if (input.equals("q")) {
				break;
			}
			
			// 숫자인지 판별. 숫자가 아닌 다른 문자 (예:ㅂ)를 입력하는 경우 방지
			if(!input.matches("\\d")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1~10 중에 입력해주세요.");
				continue;
			}
						
			int inputNum = Integer.parseInt(input);
			
			if(inputNum < 11 && inputNum > 0) {
				this.printCat(inputNum);
			} else {
				System.out.println("1~10 중에 입력해주세요.");
			}
			
		}
		System.out.println();
	}

	// 상세조회
	public void printCat(int num) {
		System.out.println();
		System.out.println("-----------" + this.b[num - 1].name + "의 상세조회" + "-----------");
		if (this.b[num - 1].isCatch == true) {
			System.out.println("포획여부 : O");
		} else {
			System.out.println("포획여부 : X");
		}
		System.out.println("성별 : " + this.b[num - 1].gender);
		System.out.println("나이 : " + this.b[num - 1].age);
		System.out.println("민첩성 : " + this.b[num - 1].speed);
	}

	// 잡은 고양이 목록 출력
	public void printCatchList() {
		System.out.println("-------------잡은 고양이 목록-------------");
		int count = 0;
		for (int i = 0; i < Config.CAT_LENGTH; i++) {
			if (this.b[i].isCatch == true) {
				System.out.println(this.b[i].name);
				count++;
			}
		}
		System.out.println("진행사항 (" + count + "/" + Config.CAT_LENGTH + ")");
		System.out.println();
	}

	// 탐색
	public void searchCat() {
		Random random = new Random();

		int num = 0;
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			num = random.nextInt(Config.CAT_LENGTH);
			if (b[num].isCatch == true) {
				continue;
			} else {
				break;
			}
		}

		boolean find = b[num].findCat();
		if (find == true) {
			boolean isCatch = b[num].catchCat();
			if (isCatch == true) {
				this.count++;
			}
		}
	}

}