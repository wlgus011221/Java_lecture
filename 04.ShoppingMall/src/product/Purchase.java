package product;

public class Purchase {
	// 구매 내역 객체
	String[] name;	// 여러개의 상품을 한번에 구매할 수 있기 때문에 상품명 배열 선언
	int[] price;	// 여러개의 상품을 한번에 구매할 수 있기 때문에 가격 배열 선언
	int[] num;	// 여러개의 상품을 한번에 구매할 수 있기 때문에 상품 개수 배열 선언
	String address;	// 배송지
	String phone;	// 전화번호
	
	public static int count = 0; // 구매 내역 개수 세기 위한 변수
	
	// 장바구니 크기에 맞춰 생성자 선언
	public Purchase(int cartSize) {
		name = new String[cartSize];
		price = new int[cartSize];
		num = new int[cartSize];
	}
}
