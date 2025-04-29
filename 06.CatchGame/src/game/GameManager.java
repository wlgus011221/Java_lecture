package game;

import java.util.Scanner;

/***
 * GameManager 클래스는 게임의 전체적인 흐름을 관리하고 실행하는 메인 관리자 클래스입니다.
 * 게임의 시작, 진행, 종료 등 전반적인 게임 로직을 제어합니다.
 * 
 * <p><b>주요 기능:</b></p>
 * <ul>
 *   <li>게임 실행 및 메뉴 제공</li>
 *   <li>고양이 탐색 및 포획 관리</li>
 *   <li>게임 종료 조건 확인</li>
 * </ul>
 */
public class GameManager {
	// 모든 고양이를 잡았는지 확인하는 플래그 변수 (true: 모든 고양이 포획, false: 아직 남음)
	boolean isAllCatch = false;
	
	/***
	 * 게임을 실행하는 메인 메소드
	 * 게임의 전체 흐름을 제어하고 사용자 입력을 처리합니다.
	 * 
	 * <p><b>게임 진행 순서:</b></p>
	 * <ol>
	 *   <li>게임 시작 메시지 출력</li>
	 *   <li>메뉴 제공 및 사용자 입력 처리</li>
	 *   <li>선택된 메뉴에 따른 기능 실행</li>
	 *   <li>게임 종료 조건 확인</li>
	 *   <li>결과 출력</li>
	 * </ol>
	 */
	public void run() {
		// 게임 시작 메시지 출력
		System.out.println("지금 폴리텍에 키우던 10마리의 고양이가 실종되었습니다.");
		System.out.println("여러분의 도움이 필요해요.. 힘을 합쳐 찾아주세요!!");
		System.out.println("------------------------------------------");
		System.out.println("게임 설명");
		System.out.println("1. 고양이의 민첩성에 따라 잡을 확률이 낮아집니다.");
		System.out.println("2. 츄르는 단 3개만 사용할 수 있습니다. 신중하게 사용하세요.");
		System.out.println("3. 츄르를 사용하면 100% 확률로 고양이를 포획할 수 있습니다.");
		
		// 실행 시간 측정
		long startTime = System.currentTimeMillis();
		
		// 고양이 목록을 관리하는 GameMethod 객체 생성
		GameMethod catList = new GameMethod();
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			// 모든 고양이를 포획한 경우 게임 종료
			if(catList.catchCount == Config.CAT_LENGTH) {
				System.out.println();
				System.out.println(Config.BLUE + "✨성공✨" + Config.RESET);
				System.out.println("감사합니다! 덕분에 고양이들을 다 찾았어요.");
				this.isAllCatch = true;
				break;
			}
			
			// 메뉴 출력
			System.out.println();
			System.out.println("===========================menu===========================");
			System.out.println("1.탐색 및 잡기 | 2.고양이 지명수배 (전체) | 3.내가 잡은 고양이들 | 종료(q)");
			System.out.println("번호를 선택해주세요.");
			String input = Config.scanner.nextLine();
			
			// 게임 종료 조건: 사용자가 'q'를 입력하면 게임 종료
			if(input.equals("q")) {
				break;
			}
			
			// 사용자 입력값 검증 - 숫자인지 확인하여 잘못된 입력 처리
			if(!input.matches("\\d")) {    // 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1, 2, 3, q중에 입력해주세요.");
				continue;
			}
						
			// 입력된 숫자를 정수로 변환
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
			System.out.println(Config.RED + "실패.." + Config.RESET);
			System.out.println("노력해주셔서 감사합니다.");
			catList.printCatchList();
		}
		
		// 소요시간 계산
		long endTime = System.currentTimeMillis();
		long durationMillis = endTime - startTime;

		// 게임 진행 시간을 분:초 형식으로 출력
		long totalSeconds = durationMillis / 1000;
		long minutes = totalSeconds / 60;
		long seconds = totalSeconds % 60;

		System.out.printf(Config.RED + "소요 시간 : %02d분 %02d초\n", minutes, seconds);

		// Scanner 객체 닫기
		Config.scanner.close();
	}
}
