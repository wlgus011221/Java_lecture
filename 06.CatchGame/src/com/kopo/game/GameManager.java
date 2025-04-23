package com.kopo.game;

/***
 * GameManager 클래스
 * 게임의 전체적인 흐름을 관리하고 실행하는 메인 관리자 클래스입니다.
 * 게임의 시작, 진행, 종료 등 전반적인 게임 로직을 제어합니다.
 * 
 * 주요 기능:
 * - 게임 실행 및 메뉴 제공
 * - 고양이 탐색 및 포획 관리
 * - 게임 종료 조건 확인
 */
public class GameManager {
	// 모든 고양이를 잡았는지 확인하는 플래그 변수 (true: 모든 고양이 포획, false: 아직 남음)
	boolean isAllCatch = false;
	
	/***
	 * 게임을 실행하는 메인 메소드
	 * 게임의 전체 흐름을 제어하고 사용자 입력을 처리합니다.
	 * 
	 * 게임 진행 순서:
	 * 1. 게임 시작 메시지 출력
	 * 2. 메뉴 제공 및 사용자 입력 처리
	 * 3. 선택된 메뉴에 따른 기능 실행
	 * 4. 게임 종료 조건 확인
	 * 5. 결과 출력
	 */
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
			
			// 사용자 입력값 검증 - 숫자인지 확인하여 잘못된 입력 처리
			if(!input.matches("\\d")) {    // 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1, 2, 3, q중에 입력해주세요.");
				continue;
			}
						
			int inputNum = Integer.parseInt(input);
			
			// 메뉴 선택에 따른 기능 실행
			// 1: 고양이 탐색 및 포획 시도
			// 2: 전체 고양이 목록 출력
			// 3: 포획한 고양이 목록 출력
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
		
		// 게임 종료 처리 - 모든 고양이를 잡지 못한 경우 실패 메시지 출력
		if(this.isAllCatch == false) {
			System.out.println();
			System.out.println("실패..");
			System.out.println("노력해주셔서 감사합니다.");
			catList.printCatchList();
		}

		Config.scanner.close();
	}
}
