

import java.util.Scanner;

public class KaupTest {
	public static void main(String[] args) {
		// 사용자의 체중, 신장을 입력받아 카우프 지수를 구하시오.
		Scanner s = new Scanner(System.in);
		KaupIndex k = new KaupIndex();
		
		System.out.println("사용자의 키를 입력해주세요. (예:1.8; 단위(m))");
		double height = s.nextDouble();
		
		System.out.println("사용자의 몸무게를 입력해주세요. (예:60; 단위(kg))");
		int weight = s.nextInt();
		
		k.setHeight(height);
		k.setWeight(weight);
		
		k.kaup(height, weight);
		
		s.close();
	}
}
