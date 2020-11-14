package ex03_FunctionTopDown;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		final int GEN_AUTO = 1;
		final int GEN_MANUAL = 2;
		final int END = 3;
		boolean end = true;

		while (end) {
			int menu = inputMenu();
			System.out.println();

			switch (menu) {
			case GEN_AUTO:
				genAuto(lotto);
				break;
			case GEN_MANUAL:
				genManual(lotto);
				break;
			case END:
				System.out.print("����!!");
				end = false;
				break;
			default:
				System.out.println("������ ������ϴ�.");
			}

			sortLotto(lotto);
			printLotto(lotto);

		}
	}

	public static void sortLotto(int[] lotto) {

		// ũ������
		for (int i = 0; i < 6 - 1; i++) {
			for (int j = 0; j < 6 - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}

	}

	public static void printLotto(int[] lotto) {

		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);
		System.out.println();
	}

	public static void genManual(int[] lotto) {

		Scanner scan = new Scanner(System.in);

		System.out.println("2. ���� ����");
		System.out.println("���ϴ� �ζ� ��ȣ�� �Է��ϼ���. (���� 1~45) > ");
		
		for (int i = 0; i < 6; i++) {
			// �����Է� + �����˻�
			do {
				System.out.printf("[%d] : ", i + 1);
				lotto[i] = scan.nextInt();
				if (!(0 < lotto[i] && lotto[i] < 46))
					System.out.println("������ ������ϴ�.");
			} while (!(0 < lotto[i] && lotto[i] < 46));

			// �ߺ��˻�
			for (int j = 0; j < i; j++)
				if (lotto[i] == lotto[j]) {
					System.out.println("�ߺ��Ǿ����ϴ�.");
					i--;
				}
		}

	}

	public static void genAuto(int[] lotto) {

		Random rand = new Random();
		System.out.println("1. �ڵ� ����");

		// �ڵ��Է� + �ߺ�����
		for (int i = 0; i < 6; i++) {
			lotto[i] = rand.nextInt(45) + 1;
			for (int j = 0; j < i; j++)
				while (lotto[i] == lotto[j])
					lotto[i] = rand.nextInt(45) + 1;
		}

	}

	public static int inputMenu() {

		System.out.println();
		System.out.println("**�ζ� �����**");
		System.out.println("1. �ڵ� ����");
		System.out.println("2. ���� ����");
		System.out.println("3. ����");
		Scanner scan = new Scanner(System.in);

		System.out.print("�Է�(���� 1~3)> ");
		int menu = scan.nextInt();

		return menu;
	}

}
