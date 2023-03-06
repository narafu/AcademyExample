package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram06 {

	public static void main(String[] args) {

		// ��ȣ ����
		Random random = new Random();
		int[] lotto = new int[6];
		int index = 6;

		for (int i = 0; i < index; i++) {
			lotto[i] = random.nextInt(45) + 1;
		}

		// ��ȣ ����
		for (int j = 0; j < index - 1; j++)
			for (int i = 0; i < index - 1 - j; i++) {
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
			}

		// ��ȣ ���
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}

	}

}
