

import java.util.Scanner;

public class Student {
	String name; // 학생 이름
	int midtermScore; // 중간고사 성적
	int finalScore; // 기말고사 성적
	int totalScore; // 총점
	double avg; // 평균
	int rank; // 등수
	int studentGrade; // 반

	Item[] item = new Item[50]; // 학생 수 만큼 배열 선언

	int count = 0; // 총 학생을 얼마나 입력했는지 확인하는 변수
	int studentCount = 10; // 한반에는 최대 학생 10명
	int classCount = 0; // 학년에 최대 5개의 반만 입력할 수 있도록 count 변수 선언

	// 1. 학생 10명 데이터 입력받기
	public void inputStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력할 반 : ");
		String temp = scanner.nextLine();
		int studentGrade = Integer.parseInt(temp);
		
		// 최대 5개의 반만 입력 가능
		if (this.classCount > 4) {
			System.out.println("이미 1~5반까지 입력했습니다.");
			return;
		}

		System.out.println("10명의 학생을 입력합니다.");

		for (int i = 0; i < this.studentCount; i++) {
			System.out.println((i + 1) + "번째 학생 입력");
			System.out.print("이름 : ");
			String name = scanner.nextLine();

			System.out.print("중간고사 성적 : ");
			temp = scanner.nextLine();
			int midtermScore = Integer.parseInt(temp);

			System.out.print("기말고사 성적 : ");
			temp = scanner.nextLine();
			int finalScore = Integer.parseInt(temp);

			item[this.count] = new Item(studentGrade, name, midtermScore, finalScore);
			count++;
			System.out.println();
		}
		classCount++;
		System.out.println();

		// 입력받고 등수 업데이트
		this.studentRank(studentGrade);
	}

	// 학생 등수 부여
	public void studentRank(int studentGrade) {
		for (int i = 0; i < this.count; i++) {
			// 같은 반 학생만 비교
			if (this.item[i].studentGrade == studentGrade) {
				for (int j = i + 1; j < this.count; j++) {
					// 같은 반 학생만 비교
					if (this.item[j].studentGrade == studentGrade) {
						if (this.item[i].totalScore < this.item[j].totalScore) {
							this.item[i].rank++;
						} else if (this.item[i].totalScore > this.item[j].totalScore) {
							this.item[j].rank++;
						}
					}
				}
			}
		}
	}

	// 2. 학생 10명의 총점 및 평균 출력
	public void printTotal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.print("조회할 반 : ");
		String temp = scanner.nextLine();
		int studentGrade = Integer.parseInt(temp);

		System.out.println("[ " + studentGrade + "반 ] 학생 10명의 총점 및 평균 출력");

		for (int i = 0; i < this.count; i++) {
			if ((this.item[i] != null) && (this.item[i].studentGrade == studentGrade)) {
				System.out.println("이름 : " + this.item[i].name);
				System.out.println("중간고사 점수 : " + this.item[i].midtermScore);
				System.out.println("기말고사 점수 : " + this.item[i].finalScore);
				System.out.println("총점 : " + this.item[i].totalScore + ", 평균 : " + this.item[i].avg);
				System.out.println();
			}
		}
		System.out.println();
	}

	// 3. 학생 1명(이름 입력받기)의 총점 및 평균 출력
	public void printStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.print("조회할 반 : ");
		String temp = scanner.nextLine();
		int studentGrade = Integer.parseInt(temp);

		System.out.println("조회하고 싶은 학생의 이름을 입력하세요");
		String name = scanner.nextLine();

		for (int i = 0; i < this.count; i++) {
			if ((this.item[i].studentGrade == studentGrade) && (this.item[i].name.equals(name))) {
				System.out.println("이름 : " + this.item[i].name);
				System.out.println("중간고사 점수 : " + this.item[i].midtermScore);
				System.out.println("기말고사 점수 : " + this.item[i].finalScore);
				System.out.println("총점 : " + this.item[i].totalScore + ", 평균 : " + this.item[i].avg);
				System.out.println("등수 : " + this.item[i].rank);
			}
		}
		System.out.println();
	}

	// 4. 학생 10명 등수대로 정렬
	// 입력했던 순서가 안 바뀌도록 rank 변수의 값 1~10까지 비교해서 순서대로 데이터가 나오도록 함
	public void printSortScore() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.print("조회할 반 : ");
		String temp = scanner.nextLine();
		int studentGrade = Integer.parseInt(temp);

		System.out.println("[ " + studentGrade + "반 ] 학생 10명 등수 순으로 출력");

		for (int i = 0; i < this.count; i++) {
			for (int j = 0; j < this.count; j++) {
				if ((this.item[j].studentGrade == studentGrade) && ((i + 1) == this.item[j].rank)) {
					System.out.println(this.item[j].rank + "등 : " + this.item[j].name + "(총점 : "
							+ this.item[j].totalScore + ", 평균 : " + this.item[j].avg + ")");
				}
			}
		}
		System.out.println();
	}

	// 5. 1~5반 전체 총점 및 평균 출력
	public void printGradeTotal() {
		System.out.println("----------------------------");
		System.out.println("1~5반 전체 총점 및 평균");
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		int total4 = 0;
		int total5 = 0;

		for (int i = 0; i < this.classCount; i++) {
			for (int j = 0; j < this.count; j++) {
				if (this.item[j].studentGrade == (i + 1)) {
					if (this.item[j].studentGrade == 1) {
						total1 = total1 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 2) {
						total2 = total2 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 3) {
						total3 = total3 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 4) {
						total4 = total4 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 5) {
						total5 = total5 + this.item[j].totalScore;
					}
				}
			}
		}
		System.out.println("1반 총점 : " + total1 + ", 평균 : " + (total1 / (double) this.studentCount));
		System.out.println("2반 총점 : " + total2 + ", 평균 : " + (total2 / (double) this.studentCount));
		System.out.println("3반 총점 : " + total3 + ", 평균 : " + (total3 / (double) this.studentCount));
		System.out.println("4반 총점 : " + total4 + ", 평균 : " + (total4 / (double) this.studentCount));
		System.out.println("5반 총점 : " + total5 + ", 평균 : " + (total5 / (double) this.studentCount));
		System.out.println();
	}

	// 6. 1~5반 등수대로 정렬하고 출력
	public void printGradeRank() {
		System.out.println("----------------------------");
		System.out.println("1~5반 등수");

		// 각 반의 총점 계산
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		int total4 = 0;
		int total5 = 0;

		for (int i = 0; i < this.classCount; i++) {
			for (int j = 0; j < this.count; j++) {
				if (this.item[j].studentGrade == (i + 1)) {
					if (this.item[j].studentGrade == 1) {
						total1 = total1 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 2) {
						total2 = total2 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 3) {
						total3 = total3 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 4) {
						total4 = total4 + this.item[j].totalScore;
					} else if (this.item[j].studentGrade == 5) {
						total5 = total5 + this.item[j].totalScore;
					}
				}
			}
		}

		// 각 반의 총점, 평균, 등수를 배열에 저장 -> 입력했던 순서가 안 바뀌도록 함
		int[] total = { total1, total2, total3, total4, total5 };
		double[] avg = { (total1 / (double) this.studentCount), (total2 / (double) this.studentCount),
				(total3 / (double) this.studentCount), (total4 / (double) this.studentCount),
				(total5 / (double) this.studentCount) };
		int[] studentGrade = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < this.classCount; i++) {
			for (int j = i + 1; j < this.classCount; j++) {
				if (total[i] < total[j]) {
					int tempTotal = total[i];
					double tempAvg = avg[i];
					int tempGrade = studentGrade[i];

					total[i] = total[j];
					avg[i] = avg[j];
					studentGrade[i] = studentGrade[j];

					total[j] = tempTotal;
					avg[j] = tempAvg;
					studentGrade[j] = tempGrade;
				}
			}
		}

		for (int i = 0; i < this.classCount; i++) {
			System.out.println((i + 1) + "등반 : " + studentGrade[i] + "반 (반총점 : " + total[i] + ", 평균 : " + avg[i] + ")");
		}
		System.out.println();
	}
}
