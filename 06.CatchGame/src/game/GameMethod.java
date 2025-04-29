package game;

import java.util.Random;
import cat.Base;
import cat.Cat1;
import cat.Cat10;
import cat.Cat2;
import cat.Cat3;
import cat.Cat4;
import cat.Cat5;
import cat.Cat6;
import cat.Cat7;
import cat.Cat8;
import cat.Cat9;

/***
 * GameMethod 클래스 게임의 핵심 기능들을 구현한 클래스입니다. 고양이 관리, 탐색, 포획, 상태 출력 등의 주요 게임 메소드들을
 * 포함합니다.
 * 
 * <p><b>주요 기능:</b></p>
 * <ul>
 *   <li>고양이 객체 생성 및 관리</li>
 *   <li>고양이 탐색 및 포획 로직</li>
 *   <li>고양이 정보 출력 및 상태 관리</li>
 * </ul>
 */
public class GameMethod {
	// 게임에 등장하는 모든 고양이 객체를 저장하는 배열
	Base[] cat = new Base[Config.CAT_LENGTH];

	// 현재까지 포획한 고양이의 수를 저장하는 변수
	int catchCount = 0;
	
	// 아이템 (츄르) 개수
	int itemCount = 3;

	/***
	 * GameMethod 클래스의 생성자 게임에 등장하는 10마리의 고양이 객체를 생성하고 초기화합니다.
	 */
	public GameMethod() {
		// 10마리의 고양이 객체를 생성하여 배열에 할당
		this.cat[0] = new Cat1();
		this.cat[1] = new Cat2();
		this.cat[2] = new Cat3();
		this.cat[3] = new Cat4();
		this.cat[4] = new Cat5();
		this.cat[5] = new Cat6();
		this.cat[6] = new Cat7();
		this.cat[7] = new Cat8();
		this.cat[8] = new Cat9();
		this.cat[9] = new Cat10();
	}

	/***
	 * 모든 고양이의 목록과 포획 상태를 출력하는 메소드 각 고양이의 상세 정보를 조회할 수 있는 메뉴도 제공합니다.
	 * 
	 * 출력 정보: - 고양이 이름 - 포획 여부 (O/X) - 상세 조회 메뉴
	 */
	public void printAll() {
		System.out.println("고양이 수배 목록");
		// 고양이 이름과 포획 여부를 출력
		for (int i = 0; i < Config.CAT_LENGTH; i++) {
			System.out.println((i + 1) + "번째 고양이");
			System.out.print(this.cat[i].name + "(");
			if (this.cat[i].isCatch == true) {
				System.out.println(" O )");
			} else {
				System.out.println(" X )");
			}
		}

		System.out.println();
		// 상세 조회를 위한 사용자 입력을 받는 부분
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			System.out.println();
			System.out.println("상세 조회를 원하는 고양이의 번호를 입력해주세요. (나가기 q)");

			String input = Config.scanner.nextLine();

			if (input.equals("q")) {
				break;
			}

			// 사용자 입력값 검증 - 숫자인지 확인하여 잘못된 입력 처리
			if (!input.matches("\\d+")) { // 숫자를 의미하는 정규표현식 [0-9]와 같은 의미
				System.out.println("1~10 중에 입력해주세요.");
				continue;
			}

			int inputNum = Integer.parseInt(input);

			// 1~10번 사이의 고양이 번호에 대해 상세 조회
			if (inputNum < 11 && inputNum > 0) {
				this.printCat(inputNum);
			} else {
				System.out.println("1~10 중에 입력해주세요.");
			}
		}
		System.out.println();
	}

	/***
	 * 특정 고양이의 상세 정보를 출력하는 메소드
	 * 
	 * @param num 조회할 고양이의 번호 (1~10)
	 * <br>
	 * 출력 정보: - 이름 - 포획 여부 - 성별 - 나이 - 민첩성
	 */
	public void printCat(int num) {
		System.out.println();
		System.out.println("-----------" + this.cat[num - 1].name + "의 상세조회" + "-----------");
		if (this.cat[num - 1].isCatch == true) {
			System.out.println("포획여부 : O");
		} else {
			System.out.println("포획여부 : X");
		}
		System.out.println("성별 : " + this.cat[num - 1].gender);
		System.out.println("나이 : " + this.cat[num - 1].age);
		System.out.println("민첩성 : " + this.cat[num - 1].speed);
	}

	/***
	 * 현재까지 포획한 고양이 목록을 출력하는 메소드 전체 고양이 중 몇 마리를 포획했는지 진행 상황도 함께 표시합니다.
	 * <br>
	 * 출력 정보: - 포획한 고양이 이름 목록 - 진행 상황 (포획한 수/전체 수)
	 */
	public void printCatchList() {
		if (this.catchCount == 0) {
			System.out.println("잡은 고양이가 없습니다.");
		} else {
			System.out.println("-------------잡은 고양이 목록-------------");
			int count = 0;
			// 포획한 고양이 목록 출력
			for (int i = 0; i < Config.CAT_LENGTH; i++) {
				if (this.cat[i].isCatch == true) {
					System.out.println(this.cat[i].name);
					count++;
				}
			}
			// 진행 상황 출력
			System.out.println("진행사항 (" + count + "/" + Config.CAT_LENGTH + ")");
			System.out.println();
		}
	}

	/***
	 * 랜덤한 고양이를 탐색하고 포획을 시도하는 메소드 아직 포획하지 않은 고양이 중에서 무작위로 선택하여 탐색합니다. 탐색에 성공하면 포획 시도하며, 포획에 성공하면
	 * catchCount를 증가시킵니다.
	 * <br>
	 * 진행 순서: 1. 랜덤한 미포획 고양이 선택 2. 고양이 탐색 시도 3. 탐색 성공 시 포획 시도 4. 포획 성공 시 catchCount
	 * 증가
	 */
	public void searchCat() {
		Random random = new Random();

		int num = 0;
		for (int i = 0; i < Config.GAME_LENGTH; i++) {
			num = random.nextInt(Config.CAT_LENGTH);
			if (this.cat[num].isCatch == true) {
				continue;
			} else {
				break;
			}
		}

		// 고양이 탐색 시도
		boolean find = this.cat[num].findCat();
		boolean isCatch = false;
		if (find == true) {
			boolean isItem = false;
			// item을 다 소진하면 더 이상 아이템 사용 여부를 묻지 않음
			if(this.itemCount > 0) {
				System.out.println("츄르를 사용하시겠습니까? y/n (남은개수 : " + this.itemCount + ")");
				while(true){
					String input = Config.scanner.nextLine();
					if(input.equals("y")) {
						isItem = true;
						isCatch = this.cat[num].catchCat(isItem);
						this.itemCount--;
						break;
					} else if(input.equals("n")) {
						isCatch = this.cat[num].catchCat(isItem);
						break;
					} else {
						System.out.println("y와 n 중에서 입력해주세요.");
					}
				}
			} else {
				isCatch = this.cat[num].catchCat(isItem);
			}

			// 고양이 포획 성공 시 catchCount 증가
			if (isCatch == true) {
				this.catchCount++;
			}
		}
	}
}
