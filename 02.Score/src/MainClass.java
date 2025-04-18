

public class MainClass {
	public static void main(String[] args) {
		Student student = new Student();
		
		// 1~5반 학생 데이터 입력 받기
		student.inputStudent();
		student.inputStudent();	
		student.inputStudent();
		student.inputStudent();
		student.inputStudent();
		
		// 5반 입력 후 초과 데이터 입력 시도
		student.inputStudent();
		
		// 1~5반 학생 10명의 총점 및 평균 출력
		student.printTotal();
		student.printTotal();
		student.printTotal();
		student.printTotal();
		student.printTotal();
		
		// 학생 1명의 총점 및 평균 출력
		student.printStudent();
		student.printStudent();
		student.printStudent();
		student.printStudent();
		student.printStudent();
		
		// 학생 10명 등수대로 정렬 후 출력
		student.printSortScore();
		student.printSortScore();
		student.printSortScore();
		student.printSortScore();
		student.printSortScore();
		
		// 1~5반 전체 총점 및 평균 출력
		student.printGradeTotal();
		
		// 1~5반 등수대로 정렬하고 출력
		student.printGradeRank();
	}
}

