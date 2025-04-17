package shopping;

import java.util.Scanner;

import product.ProductMethod;
import product.Purchase;
import user.UserManager;

public class Shopping {
	
	public void run() {
		System.out.println("쇼핑몰에 오신 것을 환영합니다.");
		Scanner scanner = new Scanner(System.in);
		ProductMethod product = new ProductMethod();
		UserManager user = new UserManager();
		
		// 로그인 화면
		user.run();
		
		while(true) {
			System.out.println();
			System.out.println("1.상품 입력 | 2.상품 조회 | 3.상품 구매 | 4.구매 조회 | 5.장바구니 담기 | 6.장바구니 목록 조회 | 7.장바구니 비우기 | 쇼핑몰 종료(q)");
			System.out.println("숫자를 입력하여 원하는 기능을 사용하세요.");
			String inputText = scanner.nextLine();
			if(inputText.equals("q")){
				break;
			}
			
			// 숫자인지 판별. 숫자가 아닌 다른 문자 (예:ㅂ)를 입력하는 경우 방지
			if(!inputText.matches("\\d")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1, 2, 3, 4, 5, 6, 7, q중에 입력해주세요.");
				continue;
			} 
			
			int inputNum = Integer.parseInt(inputText);
			if(inputNum == 1) {
				product.inputData();
			} else if(inputNum == 2) {
				product.printProduct();
			} else if(inputNum == 3) {
				product.productPurchase();
			} else if(inputNum == 4) {
				product.printPurchase();
			} else if(inputNum == 5) {
				product.InputCart();
			} else if(inputNum == 6) {
				product.printCart();
			} else if(inputNum == 7) {
				product.clearCart();
			} else {
				System.out.println("없는 기능입니다. 1, 2, 3, 4, 5, 6, 7, q 중에 입력해주세요.");
			}
		}
	}
}
