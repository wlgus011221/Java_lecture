

public class KaupIndex {
	double height; // 키
	int weight; // 몸무게
	
	public void setHeight(double userHeight) {
		height = userHeight;
	}
	
	public void setWeight(int userWeight) {
		weight = userWeight;
	}
	
	public void kaup(double userHeight, int userWeight) {
		int kaupIndex = (int) (userWeight / (userHeight * userHeight));
		
		System.out.println("카우프 지수 : " + kaupIndex);
		if(kaupIndex >= 30) {
			System.out.println("비만입니다.");
		} else if(kaupIndex >= 23) {
			System.out.println("과체중입니다.");
		} else if(kaupIndex >= 20) {
			System.out.println("정상입니다.");
		} else if(kaupIndex >= 15) {
			System.out.println("저체중입니다.");
		} else if(kaupIndex >= 13) {
			System.out.println("여윔입니다.");
		} else if (kaupIndex >= 10) {
			System.out.println("영양 실조증입니다.");
		} else {
			System.out.println("소모증입니다.");
		}
	}
}
