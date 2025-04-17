package user;

import java.util.Scanner;

public class UserMethod {
	User[] user = new User[com.kopo.Config.MAX_LENGTH];
	
	public void signup() {
		this.user[User.count] = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.print("id : ");
		this.user[User.count].id = scanner.nextLine();
		System.out.print("pw : ");
		this.user[User.count].pw = scanner.nextLine();
		User.count++;
		System.out.println("회원가입 되었습니다.");
	}
	
	public String login() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("id : ");
		String id = scanner.nextLine();
		System.out.print("pw : ");
		String pw = scanner.nextLine();
		for (int i=0; i<User.count; i++) {
			if(this.user[i].id.equals(id) && this.user[i].pw.equals(pw)) {
				System.out.println(this.user[i].id + "님 환영합니다.");
				return this.user[i].id;
			}
		}
		return "fail";
	}
}
