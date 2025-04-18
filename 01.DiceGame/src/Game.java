

import java.util.Random;

public class Game {
	int comDice = 0;
	int userDice = 0;
	String resultString = "";
	
	public void rollComDice() {
		Random random = new Random();
		this.comDice = random.nextInt(6) + 1;
		System.out.println("컴퓨터: " + this.comDice);
	}
	
	public void rollUserDice() {
		Random random = new Random();
		this.userDice = random.nextInt(6) + 1;
		System.out.println("사용자: " + this.userDice);
	}
	
	public void gameResult() {
		if (this.comDice > this.userDice) {
			this.resultString = "컴퓨터 승리"; 
			GameManager.comWin++;
		} else if (this.comDice < this.userDice) {
			this.resultString = "사용자 승리";
			GameManager.userWin++;
		} else {
			this.resultString = "비김";
		}
		System.out.println(this.resultString);
	}
}
