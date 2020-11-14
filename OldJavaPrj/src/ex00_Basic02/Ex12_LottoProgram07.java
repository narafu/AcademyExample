package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram07 {

	public static void main(String[] args) {

		Random random = new Random();
		int index = 6;
		int[] lotto = new int[index];

		// 번호 생성
		for (int i = 0; i < index; i++)
			lotto[i] = random.nextInt(45) + 1;

		// 번호 정렬
		for (int j = 0; j < index - 1; j++)
			for (int i = 0; i < index - 1 - j; i++) {
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
			}
		// 번호 출력
		for (int i = 0; i < index; i++)
			System.out.printf("%d ", lotto[i]);

	}

}
