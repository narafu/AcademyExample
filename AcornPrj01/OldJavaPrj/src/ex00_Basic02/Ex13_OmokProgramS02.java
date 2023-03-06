package ex00_Basic02;
import java.util.Scanner;

public class Ex13_OmokProgramS02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		char[][] board;
		int menu;
		int width = 0;
		int height = 0;

		while (true) {
			System.out.println("Q. �ٵ��� ũ�⸦ �����ϼ��� > ");
			System.out.println("1. (10 x 10)");
			System.out.println("2. (20 x 20)");
			System.out.println("3. (30 x 30)");
			System.out.print("> ");
			menu = Integer.parseInt(scan.nextLine());

			if ((0 < menu && menu < 4))
				break;

			System.out.println("������(1~3)�� �Է��ϼ���.");
			System.out.println();

		}
		switch (menu) {
		case 1:
			width = 10;
			height = 10;
			break;
		case 2:
			width = 20;
			height = 20;
			break;
		case 3:
			width = 30;
			height = 30;
			break;
		}

		board = new char[height][width];

		// �ٵ��� �׸���(�迭)
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				board[y - 1][x - 1] = '��';
			}
		}

		// ���� �� �׸��� & ���� �� �׸���
		for (int x = 1; x <= width; x++) {
			board[0][x - 1] = '��';
			board[height - 1][x - 1] = '��';
		}

		// ���� �� �׸��� & ������ �� �׸���
		for (int y = 1; y <= height; y++) {
			board[y - 1][0] = '��';
			board[y - 1][width - 1] = '��';
		}

		// ������ �� ���� �� �׸���
		board[0][0] = '��';
		board[0][width - 1] = '��';
		board[height - 1][0] = '��';
		board[height - 1][width - 1] = '��';

		int[] xs = new int[height * width];
		int[] ys = new int[height * width];
		int index = 0;

		while (true) {

			System.out.print("���� �Է��ϼ��� (x, y) > ");
			xs[index] = Integer.parseInt(scan.next()) - 1;
			ys[index] = Integer.parseInt(scan.next()) - 1;
			index++;

			for (int i = 0; i < index; i++) {
				int x = xs[i];
				int y = ys[i];
				board[y][x] = '��';
			}

			// �ٵ��� ���
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= width; j++) {
					System.out.printf("%c", board[i - 1][j - 1]);
				}
				System.out.println();
			}

		}

	}
}
