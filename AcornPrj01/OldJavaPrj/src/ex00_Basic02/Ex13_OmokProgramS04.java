package ex00_Basic02;
import java.util.Scanner;

public class Ex13_OmokProgramS04 {

	public static void main(String[] args) {

		// 배열로 바둑판 만들기
		// 배열로 바둑알 두기

		Scanner scan = new Scanner(System.in);

		int width = 10;
		int height = 10;
		char[][] board = new char[height][width];

		// 바둑판(배열)
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				board[y][x] = '┼';

		for (int x = 0; x < width; x++) {
			board[0][x] = '┯';
			board[width - 1][x] = '┴';
		}

		for (int y = 0; y < height; y++) {
			board[y][0] = '├';
			board[y][height - 1] = '┤';
		}

		board[0][0] = '┌';
		board[0][width - 1] = '┐';
		board[height - 1][0] = '└';
		board[height - 1][width - 1] = '┘';

		// 바둑돌(배열)

		int index = 0;
		int[] xs = new int[height * width];
		int[] ys = new int[height * width];
		
		while (true) {

			System.out.print("입력하세요. (x, y) > ");
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
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					System.out.print(board[y][x]);
				System.out.println();
			}
		}

	}
}
