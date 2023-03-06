package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram02 {
	public static void main(String[] args) {

		Random random = new Random();
		int[] lotto = new int[6];

		// ��ȣ ����
		for (int i = 0; i < 6; i++)
			lotto[i] = random.nextInt(45) + 1;

		// ��ȣ ���
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);

		System.out.println();

		// ��ȣ ����
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5 - j; i++) {
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
			}
		}

		// ��ȣ ���
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);

	}
}