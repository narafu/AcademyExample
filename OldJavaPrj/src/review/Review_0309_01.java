package review;

import java.util.Scanner;

public class Review_0309_01 {

	public static void main(String[] args) {

		// switch, default, continue

		Scanner scan = new Scanner(System.in);

		int width = 0;
		int height = 0;
		boolean loop = true;

		Exit: while (loop) {
			System.out.println("< 바둑판 >");
			System.out.println("1. (10 x 10) ");
			System.out.println("2. (20 x 20) ");
			System.out.println("?. 종료 ");
			System.out.print("입력하세요 > ");
			int menu = scan.nextInt();

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
				loop = false;
				break Exit;
			}

			// 바둑판 그리기
			char[][] board = new char[height][width];

			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					board[y - 1][x - 1] = '┼';
				}
			}

			for (int x = 1; x <= width; x++) {
				board[0][x - 1] = '┬';
				board[height - 1][x - 1] = '┴';
			}

			for (int y = 1; y <= height; y++) {
				board[y - 1][0] = '├';
				board[y - 1][width - 1] = '┤';
			}

			board[0][0] = '┌';
			board[0][width - 1] = '┐';
			board[height - 1][0] = '└';
			board[height - 1][width - 1] = '┘';

			// 출력
			System.out.println();
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					System.out.print(board[y - 1][x - 1]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("종료되었습니다.");
	}
}
