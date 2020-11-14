package ex00_Basic02;
import java.util.Scanner;

public class Ex13_OmokProgramS04 {

	public static void main(String[] args) {

		// �迭�� �ٵ��� �����
		// �迭�� �ٵϾ� �α�

		Scanner scan = new Scanner(System.in);

		int width = 10;
		int height = 10;
		char[][] board = new char[height][width];

		// �ٵ���(�迭)
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				board[y][x] = '��';

		for (int x = 0; x < width; x++) {
			board[0][x] = '��';
			board[width - 1][x] = '��';
		}

		for (int y = 0; y < height; y++) {
			board[y][0] = '��';
			board[y][height - 1] = '��';
		}

		board[0][0] = '��';
		board[0][width - 1] = '��';
		board[height - 1][0] = '��';
		board[height - 1][width - 1] = '��';

		// �ٵϵ�(�迭)

		int index = 0;
		int[] xs = new int[height * width];
		int[] ys = new int[height * width];
		
		while (true) {

			System.out.print("�Է��ϼ���. (x, y) > ");
			xs[index] = Integer.parseInt(scan.next()) - 1;
			ys[index] = Integer.parseInt(scan.next()) - 1;
			index++;

			for (int i = 0; i < index; i++) {
				int x = xs[i];
				int y = ys[i];
				if (i % 2 == 0)
					board[y][x] = '��';
				else
					board[y][x] = '��';
			}

			// ���
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					System.out.print(board[y][x]);
				System.out.println();
			}
		}

	}
}
