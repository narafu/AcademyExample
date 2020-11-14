package ex01_Structure;

import java.util.Scanner;

public class Ex16_OmokPrograF00 {

	public static void main(String[] args) {

		// ������ ����ȭ - ��ü(Entity), Ŭ����(Class)

		Scanner scan = new Scanner(System.in);

		String[][] board;
		int menu;
		final int WIDTH;
		final int HEIGHT;
		final int SM = 1;
		final int MM = 2;
		final int LM = 3;

		while (true) {
			System.out.println("Q. �ٵ��� ũ�⸦ �����ϼ���.");
			System.out.println("1. (10 x 10)");
			System.out.println("2. (20 x 20)");
			System.out.println("3. (30 x 30)");
			System.out.println("4. �⺻�� (5 x 5)");
			System.out.print("�Է� > ");
			menu = Integer.parseInt(scan.nextLine());

			if ((0 < menu && menu < 5))
				break;

			System.out.println("������(1~4)�� �Է��ϼ���.");
			System.out.println();
		}

		switch (menu) {
		case SM:
			WIDTH = 10;
			HEIGHT = 10;
			break;
		case MM:
			WIDTH = 20;
			HEIGHT = 20;
			break;
		case LM:
			WIDTH = 30;
			HEIGHT = 30;
			break;
		default:
			WIDTH = 5;
			HEIGHT = 5;
		}

		board = new String[HEIGHT][WIDTH];

		// �ٵ��� �׸���(�迭)
		for (int y = 1; y <= HEIGHT; y++) {
			for (int x = 1; x <= WIDTH; x++) {
				board[y - 1][x - 1] = "����";
			}
		}
		for (int x = 1; x <= WIDTH; x++) {
			board[0][x - 1] = "����";
			board[HEIGHT - 1][x - 1] = "����";
		}
		for (int y = 1; y <= HEIGHT; y++) {
			board[y - 1][0] = "����";
			board[y - 1][WIDTH - 1] = "��";
		}
		board[0][0] = "����";
		board[0][WIDTH - 1] = "��";
		board[HEIGHT - 1][0] = "����";
		board[HEIGHT - 1][WIDTH - 1] = "��";

		// �ٵϵ� �׸���
		Omok omok = new Omok();
		Omok[] omoks = new Omok[100];

		int[] xs = new int[HEIGHT * WIDTH];
		int[] ys = new int[HEIGHT * WIDTH];
		int count = 0;
		omok.x = -1;
		omok.y = -1;

		Repeat: while (true) {

			System.out.print("�Է��ϼ��� (x, y) > ");
			omok.x = Integer.parseInt(scan.next()) - 1;
			omok.y = Integer.parseInt(scan.next()) - 1;
			xs[count] = omok.x;
			ys[count] = omok.y;
			count++;

			for (int i = 0; i < count; i++) {
				for (int j = 0; j < i; j++) {
					if (xs[i] == xs[j] && ys[i] == ys[j]) {
						System.out.println("�ڸ��� �����ϴ�.");
						count--;
						continue Repeat;
					}
				}
			}

			for (int i = 0; i < count; i++) {
				int x = xs[i];
				int y = ys[i];
				if (i % 2 == 1)
					board[y][x] = "�� ";
				else
					board[y][x] = "�� ";
			}

			// �ٵ��� ���
			for (int i = 1; i <= HEIGHT; i++) {
				for (int j = 1; j <= WIDTH; j++) {
					System.out.printf("%s", board[i - 1][j - 1]);
				}
				System.out.println();
			}
		}

	}
}
