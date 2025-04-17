package user;

import java.util.Scanner;

public class UserManager {
	public void run() {
		UserMethod userMethod = new UserMethod();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.회원가입 | 2.로그인 | 3.비회원");
			String inputText = scanner.nextLine();
			int inputNum = Integer.parseInt(inputText);
			
			if(inputNum == 3) {
				break;
			}
			
			if(inputNum == 1) {
				userMethod.signup();
			} else if(inputNum == 2) {
				String id = userMethod.login();
				if(id.equals("fail")) {
					System.out.println("로그인 실패. 다시 로그인 해주세요.");
				} else {
					return;
				}
			} else {
				System.out.println("1, 2, 3중에 입력해주세요.");
			}
		}
	}
}
