package product;

import java.util.Scanner;

public class ProductMethod {
	// 객체 배열 선언
	Product[] product = new Product[com.kopo.Config.MAX_LENGTH];
	Purchase[] purchase = new Purchase[com.kopo.Config.MAX_LENGTH];
	Cart[] cart = new Cart[com.kopo.Config.MAX_LENGTH];

	// 상품 입력 처리 - 계속 상품 등록이 가능하도록 반복문 처리
	public void inputData() {
		Scanner scanner = new Scanner(System.in);
		int i = Product.count;
		while(i < this.product.length) {
			System.out.println("상품 입력 : y (종료 : q)");
			String inputString = scanner.nextLine();

			// 입력 종료인지 확인
			if (inputString.equals("q")) {
				break;
			} else if(inputString.equals("y")) {
				// 상품 입력하기 위한 Product 객체 생성
				this.product[i] = new Product();
				int success = this.product[i].inputProduct(); // Product 객체에 있는 inputProduct() 메소드 실행
				
				// 상품 등록이 성공해야 i 1증가
				if (success == 1) {
					i++;
				}
			} else {
				System.out.println("y와 q 중에 입력해주세요.");
			}
		}
		
//		상품 등록 중에 오류가 나면 i가 증가하면서 null 값이 들어가는 오류가 발생하여 while문 형식으로 바꿈
//		for (int i = Product.count; i < this.product.length; i++) {
//			System.out.println("상품 입력할려면 enter키 (종료할려면 q)");
//			String inputString = scanner.nextLine();
//
//			// 입력 종료인지 확인
//			if (inputString.equals("q")) {
//				break;
//			}
//
//			// 상품 입력하기 위한 Product 객체 생성
//			this.product[i] = new Product();
//			this.product[i].inputProduct(); // Product 객체에 있는 inputProduct() 메소드 실행
//		}
	}

	// 전체 상품 조회
	public void printProduct() {
		// 등록된 상품이 없는 경우 "등록된 상품이 없습니다" 출력
		if (Product.count == 0) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}

		System.out.println("---------- [ 상품 조회 ] ----------");
		// 등록된 상품 개수만큼 반복문 실행
		for (int i = 0; i < Product.count; i++) {
			if(this.product[i] != null) {
				System.out.println(this.product[i].productNum + "번째 상품");
				System.out.println("상품명 : " + this.product[i].name);
				System.out.println("가격 : " + this.product[i].price);
				System.out.println();
			} else {
				continue;
			}
		}
	}
	
	// 장바구니
	public void InputCart() {
		// 등록된 상품이 없는 경우 "등록된 상품이 없습니다" 출력
		if(Product.count == 0) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		
		// 상품 조회 메소드 실행
		this.printProduct();
		
		Scanner scanner = new Scanner(System.in);
		this.cart[Cart.count] = new Cart();

		System.out.println("구매하고자 하는 상품의 번호를 입력하세요.");
		String inputNum = scanner.nextLine();
		
		// 숫자를 입력하지 않은 경우
		if(!inputNum.matches("\\d")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
			System.out.println("상품 번호를 입력해주세요.");
			return;
		}
		
		int productNum = Integer.parseInt(inputNum);
		
		// 없는 상품 번호를 입력했을 경우
		if(productNum > Product.count || productNum <= 0) {
			System.out.println("없는 상품 번호 입니다. 상품 번호를 확인해주세요.");
			return;
		}
		
		String name = "";
		int price = 0;
		// 상품명, 가격은 product 객체에서 받아오기
		for (int i = 0; i < Product.count; i++) {
			if (this.product[i].productNum == productNum) {
				name = this.product[i].name;
				price = this.product[i].price;
			}
		}
		
		System.out.println("상품명 : " + name);
		System.out.println("개당 가격 : " + price);
		System.out.println("구매 개수를 입력해주세요.");
		inputNum = scanner.nextLine();
		
		// 숫자를 입력하지 않은 경우
		if(!inputNum.matches("\\d+")) {	// 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
			System.out.println("숫자를 입력해주세요.");
			return;
		}
		int num = Integer.parseInt(inputNum);
		
		// 0보다 작은 수를 입력할 경우 처리
		if(num <= 0) {
			System.out.println("잘못된 개수입니다. 0보다 큰 수를 입력해주세요.");
			return;
		}
		
		this.cart[Cart.count].num = num;
		this.cart[Cart.count].name = name;
		this.cart[Cart.count].price = price;
		
		// 총 가격 = 가격 * 개수
		this.cart[Cart.count].price = this.cart[Cart.count].price * this.cart[Cart.count].num;
		System.out.println("총 가격 : " + this.cart[Cart.count].price);
		
		// 장바구니의 count 1 증가
		Cart.count++;
	}
	
	// 장바구니 목록 조회
	public void printCart() {
		if(Cart.count == 0) {
			System.out.println("장바구니가 비었습니다.");
			return;
		}
		
		for (int i=0; i<Cart.count; i++) {
			System.out.println((i+1) + "번째 장바구니 상품");
			if(this.cart[i] != null) {
				System.out.println("상품명 : " + this.cart[i].name);
				System.out.println("개수 : " + this.cart[i].num);
				System.out.println("총 가격 : " + this.cart[i].price);
				System.out.println();
			}
		}
	}
	
	// 장바구니 비우기
	public void clearCart() {
		if(Cart.count == 0) {
			return;
		}
		
		for(int i=0; i<Cart.count; i++) {
			this.cart[i].name = null;
			this.cart[i].num = 0;
			this.cart[i].price = 0;
		}
		Cart.count = 0;
		System.out.println("장바구니 초기화 완료");
	}
	
	// 구매 입력
	public void productPurchase() {
		if(Product.count == 0) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		
		if(Cart.count == 0) {
			System.out.println("장바구니가 비었습니다. 장바구니에 상품을 담아주세요.");
			return;
		}
		
		this.printCart();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("구매하시겠습니까? (y/n)");
		String ok = scanner.nextLine();
		
		if(!ok.equals("y") && !ok.equals("n")) {
			System.out.println("y나 n 중에 입력해주세요.");
			return;
		} else if(ok.equals("n")) {
			return;
		}
		
		this.purchase[Purchase.count] = new Purchase(Cart.count);
		int total = 0;
		for(int i=0; i<Cart.count; i++) {
			this.purchase[Purchase.count].name[i] = this.cart[i].name;
			this.purchase[Purchase.count].price[i] = this.cart[i].price;
			this.purchase[Purchase.count].num[i] = this.cart[i].num;
			total = total + this.cart[i].price;
		}	

		System.out.println("배송지를 입력해주세요.");
		this.purchase[Purchase.count].address = scanner.nextLine();
		
		System.out.println("연락처를 입력해주세요. (000-0000-0000)");
		this.purchase[Purchase.count].phone = scanner.nextLine();
		Purchase.count++;
		
		System.out.println("총 구매액 : " + total);
		System.out.println("구매 완료 되었습니다.");
		
		// 장바구니 비우기
		this.clearCart();
	}

	// 구매 조회
	public void printPurchase() {
		// 구매한 이력이 없을 경우 "구매 이력이 없습니다" 출력
		if (Purchase.count == 0) {
			System.out.println("구매 이력이 없습니다.");
			return;
		}
		
		System.out.println("---------- [ 구매 조회 ] ----------");
		int total = 0;
		for (int i = 0; i < Purchase.count; i++) {
			System.out.println("" + (i + 1) + "번째 구매 목록");
			for(int j=0; j<this.purchase[i].name.length; j++) {
				System.out.println("상품명 : " + this.purchase[i].name[j]);
				System.out.println("개수 : " + this.purchase[i].num[j]);
				System.out.println("가격 : " + this.purchase[i].price[j]);
				System.out.println();
				total = total + this.purchase[i].price[j];
			}
			System.out.println("배송지 : " + this.purchase[i].address);
			System.out.println("전화번호 : " + this.purchase[i].phone);
			System.out.println("총 구매 가격 : " + total);
			System.out.println();
		}
		
	}
}
