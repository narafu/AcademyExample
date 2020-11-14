package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram09 {

	public static void main(String[] args) {

		Random random = new Random();
		int index = 6;
		int[] lotto = new int[index];

		// �̱�
		for (int i = 0; i < index; i++)
			lotto[i] = random.nextInt(45) + 1;

		// �̱� ���
		System.out.print("��     ��: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// ��������
		for (int j = 0; j < index - 1; j++) {
			for (int i = 0; i < index - 1 - j; i++)
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
		}

		// �������� ���
		System.out.print("��������: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// �ߺ����� & ���� �̱�
		for (int i = 0; i < index - 1; i++) {
			if (lotto[i] == lotto[i + 1]) {
				lotto[i] = random.nextInt(45) + 1;
			}
		}

		// �ߺ����� ���
		System.out.print("�ߺ�����: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

		// ��������
		for (int j = 0; j < index - 1; j++) {
			for (int i = 0; i < index - 1 - j; i++)
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
		}

		// �������� ���
		System.out.print("��������: ");
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		System.out.println();

	}
}

// ��     ��: 30 1 10 29 1 10 
// ��������: 1 1 10 10 29 30 
// �ߺ�����: 10 1 2 10 29 30 
// ��������: 1 2 10 10 29 30 
