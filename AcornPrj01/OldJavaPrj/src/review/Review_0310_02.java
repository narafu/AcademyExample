package review;

import java.util.Scanner;

public class Review_0310_02 {

	public static void main(String[] args) {

		// switch, default, continue

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;

		Exit: while (true) {

			// ¸Þ´º
			System.out.println("<ÇÁ·Î±×·¥>");
			System.out.println("1. (10 x 10)");
			System.out.println("2. (20 x 20)");
			System.out.println("?. Á¾·á");
			System.out.print("> ÀÔ·Â : ");
			int menu = Integer.parseInt(scan.next());

			// ¼±ÅÃ
			switch (menu) {
			case 1:
				width = 10;
				height = 10;
				break;
			case 2:
				width = 20;
				height = 20;
				break;
			default:
				break Exit;
			}

			char[][] board = new char[height][width];

			// ¹ÙµÏÆÇ ±×¸®±â
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					board[y - 1][x - 1] = '¦«';
				}
			}

			for (int y = 1; y <= height; y++) {
				board[y - 1][0] = '¦§';
				board[y - 1][width - 1] = '¦©';

				for (int x = 1; x <= width; x++) {
					board[0][x - 1] = '¦¨';
					board[height - 1][x - 1] = '¦ª';
				}

				board[0][0] = '¦£';
				board[0][width - 1] = '¦¤';
				board[height - 1][0] = '¦¦';
				board[height - 1][width - 1] = '¦¥';

			}

			// ­‹·Â
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					System.out.print(board[y][x]);
				}
				System.out.println();
			}

		}

		System.out.println("Á¾·áµÇ¾ú½À´Ï´Ù.");
	}

}
