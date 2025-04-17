package product;

import java.util.Scanner;

public class Product {
	// 상품 객체
	public static int count = 0; // 등록된 상품 개수를 세기 위한 변수
	String name; // 상품명
	int price; // 상품 가격
	int productNum; // 상품 번호
	
	// 상품 정보 입력 받기 - 성공 여부를 숫자로 반환 (0: 등록 실패, 1: 등록 성공)
	public int inputProduct() {
		Scanner scanner = new Scanner(System.in);
		int success = 0;
		
		System.out.println("상품명을 입력해주세요.");
		String name = scanner.nextLine();
		
		System.out.println("상품 가격을 입력해주세요.");
		String inputText = scanner.nextLine();
		
		// 상품 가격이 숫자가 아닌 경우 등록 실패 처리
		if(!inputText.matches("\\d+")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미 (여러 자리 수)
			System.out.println("상품 가격은 숫자로 입력해주세요. (예:1000)");
			System.out.println("[!] 상품 등록에 실패했습니다.");
			System.out.println();
		} else {
			// 상품 등록 처리
			this.name = name;
			this.price = Integer.parseInt(inputText);
			
			// count 증가하여 상품 번호가 1부터 들어가도록 함
			Product.count++;
			this.productNum = Product.count;
			success = 1;
		}
		return success;
	}
}
