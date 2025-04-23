package com.kopo.game;

public class GameManager {
	boolean isAllCatch = false;
	public void run() {
		System.out.println("지금 폴리텍에 키우던 10마리의 고양이가 실종되었습니다.");
		System.out.println("여러분의 도움이 필요해요.. 힘을 합쳐 찾아주세요!!");
		System.out.println("(고양이의 민첩성에 따라 잡을 확률이 낮아집니다.)");
		
		GameMethod catList = new GameMethod();
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			if(catList.count == Config.CAT_LENGTH) {
				System.out.println();
				System.out.println("감사합니다! 덕분에 고양이들을 다 찾았어요.");
				this.isAllCatch = true;
				break;
			}
			
			System.out.println();
			System.out.println("============menu============");
			System.out.println("1.탐색 및 잡기 | 2.고양이 지명수배 (전체) | 3.내가 잡은 고양이들 | 종료(q)");
			System.out.println("번호를 선택해주세요.");
			String input = Config.scanner.nextLine();
			
			if(input.equals("q")) {
				break;
			}
			
			// 숫자인지 판별. 숫자가 아닌 다른 문자 (예:ㅂ)를 입력하는 경우 방지
			if(!input.matches("\\d")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1, 2, 3, q중에 입력해주세요.");
				continue;
			} 
						
			int inputNum = Integer.parseInt(input);
			
			if(inputNum == 1) {
				catList.searchCat();
			} else if(inputNum == 2) {
				catList.printAll();
			} else if(inputNum == 3) {
				catList.printCatchList();
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
		
		if(this.isAllCatch == false) {
			System.out.println();
			System.out.println("실패..");
			System.out.println("노력해주셔서 감사합니다.");
			catList.printCatchList();
		}

		Config.scanner.close();
	}
}
