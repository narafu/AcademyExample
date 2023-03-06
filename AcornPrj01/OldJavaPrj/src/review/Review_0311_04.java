package review;

import java.util.Scanner;

public class Review_0311_04 {

	public static void main(String[] args) {

		// 배열로 바둑판 만들기
		// 배열로 바둑알 두기

		Scanner scan = new Scanner(System.in);

		int height = 5;
		int width = 5;
		char[][] board = new char[height][width];

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				board[y - 1][x - 1] = '┼';
			}
		}

		for (int y = 1; y <= height; y++) {
			board[y - 1][0] = '├';
			board[y - 1][width - 1] = '┤';
		}

		for (int x = 1; x <= width; x++) {
			board[0][x - 1] = '┬';
			board[height - 1][x - 1] = '┴';
		}

		board[0][0] = '┌';
		board[0][width - 1] = '┐';
		board[height - 1][0] = '└';
		board[height - 1][width - 1] = '┘';

		Omok[] omoks = new Omok[height * width];

		int count = 0;


		while (true) {
			omoks[count] = new Omok();
			System.out.print("입력하세요 (x, y) > ");
			omoks[count].xs = Integer.parseInt(scan.next()) - 1;
			omoks[count].ys = Integer.parseInt(scan.next()) - 1;

			count++;

			for (int i = 0; i < count; i++) {
				board[omoks[i].ys][omoks[i].xs] = '○';
				if (i % 2 == 1)
					board[omoks[i].ys][omoks[i].xs] = '●';

			}

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
	}
}