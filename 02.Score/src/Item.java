


public class Item {
	String name;	// 학생 이름
	int midtermScore;	// 중간고사 성적
	int finalScore;		// 기말고사 성적
	int totalScore;		// 총점
	double avg;		// 평균
	int rank;		// 등수
	int studentGrade;	// 반
	
	Item(int studentGrade, String name, int midtermScore, int finalScore){
		this.studentGrade = studentGrade;
		this.name = name;
		this.midtermScore = midtermScore;
		this.finalScore = finalScore;
		this.totalScore = midtermScore + finalScore;
		this.avg = (midtermScore + finalScore) / 2.0;
		this.rank = 1; // 랭크는 초반에는 다 1로 초기화. 후에 정렬 메소드로 랭크 업데이트 예정
	}
}
