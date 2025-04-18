

import java.util.Arrays;
import java.util.Random;

public class SortClass {
	public static void main(String[] args) {
		// 0~100까지 임의의 수를 30개 발생시켜서 배열에 넣은 후 정렬하시오.
		// 조건1. 정렬 전/후의 값을 화면에 출력
		// Arrays.sort 이거 사용금지. 직접 알고리즘 짜서 정렬하기

		Random r = new Random();

		int[] numArray = new int[30];

		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = r.nextInt(100) + 1;
		}

		// 배열의 30개 들어갔는지 확인
		System.out.println("정렬 전 배열 : " + Arrays.toString(numArray));

		// 선택, 삽입, 버블 정렬 중에 선택
		// 선택 정렬 : 최소값을 찾아 첫번째 숫자와 위치 교환, 이를 정렬된 값을 제외한 최소 숫자를 정렬되지 않은 숫자 중 첫번째 숫자와 다시 위치 교환, 이를 반복
		for (int i = 0; i < numArray.length; i++) {
			int min = numArray[i];
			int index = i;
			for (int j = i + 1; j < numArray.length; j++) {
				if (numArray[j] < min) {
					min = numArray[j];
					index = j;
				}
			}
			int temp = numArray[i];
			numArray[i] = numArray[index];
			numArray[index] = temp;
		}
		System.out.println("선택 정렬 : " + Arrays.toString(numArray));

		// 삽입 정렬 : 두번째 숫자와 첫번째 숫자 비교하여 크기 순으로 정렬, 이후 3번째 숫자를 앞서 정렬된 숫자들 사이에 크기 순에 맞게 재정렬, 이를 반복
		// 두번째 숫자와 첫번째 숫자 비교하여 크기 순으로 정렬, 이후 3번째 숫자를 앞서 정렬된 숫자들 사이에 크기 순에 맞게
		// 2번째 숫자와 1번째 숫자 비교하여 정렬
		// 3번째 숫자와 2번째 비교 -> 1번쨰 비교
		// 4번째 숫자와 3번째 비교 -> 2번째 -> 1번째
		// 시작 숫자를 키라 하고 키와 비교하는 정렬된 숫자들에서 키가 크면 이제 더 비교 안 하고
		// 키가 작으면 전 배열로 가서 다시 비교
		// 다 비교하고 키 값은 직전까지 비교한 숫자 위치에 바꾸기
		
		// whlie 사용해서 나온 삽입 정렬
//		for (int i = 1; i < numArray.length; i++) {
//			int key = numArray[i];
//			int j = i - 1;
//
//			while (j >= 0 && numArray[j] > key) {
//				numArray[j + 1] = numArray[j];
//				j = j - 1;
//			}
//
//			numArray[j + 1] = key;
//		}

		
		for (int i = 1; i < numArray.length; i++) {
			int key = numArray[i];
			int j = i - 1;

			for (; j >= 0; j--) {
				if (numArray[j] < key) {
					break;
				} else {
					numArray[j + 1] = numArray[j];
				}
			}
			numArray[j + 1] = key;
		}

		System.out.println("삽입 정렬 : " + Arrays.toString(numArray));

		// 버블 정렬 : 왼쪽부터 인접한 두 숫자 간 크기 비교하여 위치 교환. 가장 큰 숫자를 오른쪽으로 밀어서 배치
		// 0과 1 비교. 0이 크면 1과 위치 교환
		// 1과 2 비교. 1이 크면 2와 위치 교환 ...
		// n-1과 n 비교. n-1이 크면 n과 위치 교환
		// 다음 비교는 n-1까지만 비교

		for (int i = 0; i < numArray.length; i++) {
			for (int j = 0; j < numArray.length - 1 - i; j++) {
				if (numArray[j] > numArray[j + 1]) {
					int temp = numArray[j];
					numArray[j] = numArray[j + 1];
					numArray[j + 1] = temp;
				}
			}
		}

		System.out.println("버블 정렬 : " + Arrays.toString(numArray));
	}
}
