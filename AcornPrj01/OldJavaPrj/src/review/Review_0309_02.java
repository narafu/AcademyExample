package review;

import java.util.Scanner;

public class Review_0309_02 {

	public static void main(String[] args) {

		// 배열로 바둑판 만들기
		// 배열로 바둑알 두기

		Scanner scan = new Scanner(System.in);

		int width = 10;
		int height = 10;

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

		// 바둑알 그리기
		int[] xs = new int[height * width];
		int[] ys = new int[height * width];
		int index = 0;

		while (true) {
			System.out.print("바둑알 위치 입력 (x, y) > ");
			xs[index] = Integer.parseInt(scan.next()) - 1;
			ys[index] = Integer.parseInt(scan.next()) - 1;
			index++;

			for (int i = 0; i < index; i++) {
				int x = xs[i];
				int y = ys[i];
				if (i % 2 == 0)
					board[y][x] = '○';
				else
					board[y][x] = '●';
			}

			// 출력
			System.out.println();
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					System.out.print(board[y - 1][x - 1]);
				}
				System.out.println();
			}
		}
	}
}
