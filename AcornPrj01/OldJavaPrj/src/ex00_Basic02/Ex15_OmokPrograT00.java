package ex00_Basic02;
import java.util.Scanner;

public class Ex15_OmokPrograT00 {

	public static void main(String[] args) {

		// ���������
		
		Scanner scan = new Scanner(System.in);

		char[][] board;
		int menu;
		final int WIDTH;
		final int HEIGHT;
		final int SM = 1;
		final int MM = 2;
		final int LM = 3;

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

		board = new char[HEIGHT][WIDTH];

		// �ٵ��� �׸���(�迭)
		for (int y = 1; y <= HEIGHT; y++) {
			for (int x = 1; x <= WIDTH; x++) {
				board[y - 1][x - 1] = '��';
			}
		}

		// ���� �� �׸��� & ���� �� �׸���
		for (int x = 1; x <= WIDTH; x++) {
			board[0][x - 1] = '��';
			board[HEIGHT - 1][x - 1] = '��';
		}

		// ���� �� �׸��� & ������ �� �׸���
		for (int y = 1; y <= HEIGHT; y++) {
			board[y - 1][0] = '��';
			board[y - 1][WIDTH - 1] = '��';
		}

		// ������ �� ���� �� �׸���
		board[0][0] = '��';
		board[0][WIDTH - 1] = '��';
		board[HEIGHT - 1][0] = '��';
		board[HEIGHT - 1][WIDTH - 1] = '��';

		int[] xs = new int[HEIGHT * WIDTH];
		int[] ys = new int[HEIGHT * WIDTH];
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
			for (int i = 1; i <= HEIGHT; i++) {
				for (int j = 1; j <= WIDTH; j++) {
					System.out.printf("%c", board[i - 1][j - 1]);
				}
				System.out.println();
			}
		}

	}
}
