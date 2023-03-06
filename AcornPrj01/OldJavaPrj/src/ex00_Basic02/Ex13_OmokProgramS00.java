package ex00_Basic02;
import java.util.Scanner;

public class Ex13_OmokProgramS00 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		char[][] board;
		int menu;
		int width = 0;
		int height = 0;

		while (true) {
			System.out.println("Q. 바둑판 크기를 선택하세요 > ");
			System.out.println("1. (10 x 10)");
			System.out.println("2. (20 x 20)");
			System.out.println("3. (30 x 30)");
			System.out.print("> ");
			menu = Integer.parseInt(scan.nextLine());

			if ((0 < menu && menu < 4))
				break;

			System.out.println("범위값(1~3)을 입력하세요.");
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

		// 바둑판 그리기(배열)
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				board[y - 1][x - 1] = '┼';
			}
		}

		// 상판 ┬ 그리기 & 하판 ┴ 그리기
		for (int x = 1; x <= width; x++) {
			board[0][x - 1] = '┬';
			board[height - 1][x - 1] = '┴';
		}

		// 왼쪽 ├ 그리기 & 오른쪽 ┤ 그리기
		for (int y = 1; y <= height; y++) {
			board[y - 1][0] = '├';
			board[y - 1][width - 1] = '┤';
		}

		// 꼭지점 ┌ ┐└ ┘ 그리기
		board[0][0] = '┌';
		board[0][width - 1] = '┐';
		board[height - 1][0] = '└';
		board[height - 1][width - 1] = '┘';

		while (true) {

			// 흰돌 입력
			System.out.print("\n> 흰돌을 입력하세요 (x, y) : ");
			int ox = Integer.parseInt(scan.next());
			int oy = Integer.parseInt(scan.next());

			board[oy - 1][ox - 1] = '○';

			// 바둑판 출력
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					System.out.printf("%c", board[y - 1][x - 1]);
				}
				System.out.println();
			}

			// 흑돌 입력
			System.out.print("\n> 흑돌을 입력하세요 (x, y) : ");
			ox = Integer.parseInt(scan.next());
			oy = Integer.parseInt(scan.next());

			board[oy - 1][ox - 1] = '●';

			// 바둑판 출력
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++) {
					System.out.printf("%c", board[y - 1][x - 1]);
				}
				System.out.println();
			}

		}

	}
}
