package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram09 {

	public static void main(String[] args) {

		Random random = new Random();
		int index = 6;
		int[] lotto = new int[index];

		// 뽑기
		for (int i = 0; i < index; i++)
			lotto[i] = random.nextInt(45) + 1;

		// 뽑기 출력
		System.out.print("뽑     기: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// 일차정렬
		for (int j = 0; j < index - 1; j++) {
			for (int i = 0; i < index - 1 - j; i++)
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
		}

		// 일차정렬 출력
		System.out.print("일차정렬: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// 중복제거 & 새로 뽑기
		for (int i = 0; i < index - 1; i++) {
			if (lotto[i] == lotto[i + 1]) {
				lotto[i] = random.nextInt(45) + 1;
			}
		}

		// 중복제거 출력
		System.out.print("중복제거: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// 이차정렬
		for (int j = 0; j < index - 1; j++) {
			for (int i = 0; i < index - 1 - j; i++)
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
		}

		// 이차정렬 출력
		System.out.print("이차정렬: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

	}
}

// 뽑     기: 30 1 10 29 1 10 
// 일차정렬: 1 1 10 10 29 30 
// 중복제거: 10 1 2 10 29 30 
// 이차정렬: 1 2 10 10 29 30 
