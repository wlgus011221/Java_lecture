

import java.util.Scanner;

public class GameManager {
	Game[] game;
	int gameIndex = 0;
	
	// 승률 계산을 위한 변수
	public static int userWin = 0;
	public static int comWin = 0;
	int realCount = 0;

	GameManager(){
		this.game = new Game[999999];
	}
	
	public void playGame() {
		this.game[this.gameIndex] = new Game();
		this.game[this.gameIndex].rollComDice();
		this.game[this.gameIndex].rollUserDice();
		this.game[this.gameIndex].gameResult();
		this.gameIndex++;
	}
	
	public void printHistory() {
		for (int j = 0; j < this.gameIndex; j++) {
			System.out.println("" + (j + 1) + "번째 게임 결과: "
					+ this.game[j].resultString);
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 999999; i++) {
			System.out.println();
			System.out.println();
			System.out.println("-------------------");
			System.out.println("게임을 시작하려면 엔터. 종료는 q. 이력 확인 h. 승률 조회 w");
			String inputString = scanner.nextLine();
			if (inputString.equals("q")) {
				System.out.println("게임이 종료되었습니다.");
				break;
			} else if (inputString.equals("h")) {
				this.printHistory();
				continue;
			} else if (inputString.equals("w")) {
				this.win();
				continue;
			} 
			this.playGame();
			realCount++;
		}
	}
	
	// 승률 조회
	public void win() {
		System.out.println("[ 승률 조회 ]");
		if (this.realCount == 0) {
			System.out.println("사용자 승률 : 0.0, 컴퓨터 승률 : 0.0");
			System.out.println();
			return;
		}
		double userWin = (GameManager.userWin / (double) this.realCount) * 100;
		double comWin = (GameManager.comWin / (double) this.realCount) * 100;
		
		System.out.println("사용자 승률 : " + userWin + ", 컴퓨터 승률 : " + comWin);
		System.out.println();
	}
}
