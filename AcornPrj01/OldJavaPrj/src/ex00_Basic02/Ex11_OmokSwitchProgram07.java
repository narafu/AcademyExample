package ex00_Basic02;
import java.util.Random;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram07 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		// 메인메뉴
		System.out.println("Q. 바둑판의 크기를 선택하세요");
		System.out.println("1. (10 x 10)");
		System.out.println("2. (20 x 20)");
		System.out.println("3. (30 x 30)");
		System.out.println("4. 사용자 정의");

		do {
			System.out.print("\n> 입력 : ");
			menu = Integer.parseInt(scan.nextLine());
			if (!(1 <= menu && menu <= 4))
				System.out.println("! 범위 값(1~4)을 벗어났습니다. 다시 입력하세요.");

		} while (!(1 <= menu && menu <= 4));

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
		default:
			System.out.println("\nQ. 원하는 크기를 입력하세요.");
			System.out.print("> 가로 길이: ");
			width = Integer.parseInt(scan.next());
			System.out.print("> 세로 길이: ");
			height = Integer.parseInt(scan.next());
			System.out.println();
		}

		// 바둑판
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == 1 && y == height)
					System.out.print("└");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == width && y == height)
					System.out.print("┘");

				else if (x == 1)
					System.out.print("├");
				else if (x == width)
					System.out.print("┤");
				else if (y == 1)
					System.out.print("┬");
				else if (y == height)
					System.out.print("┴");

				else
					System.out.print("┼");

			System.out.println();
		}

		// 바둑돌 + 바둑판
		while (true) {

			Random random = new Random();

			int ox = 0;
			int oy = 0;

			System.out.print("\n─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─\n");
			System.out.printf("\n<x범위: %d, y범위: %d>", width, height);
			System.out.print("\nQ. 바둑돌을 놓을 위치를 입력하세요. (x, y) or Random(0) or Exit(-1): ");
			ox = Integer.parseInt(scan.next());
			if (ox == -1)
				break;
			else if (ox == 0) {
				ox = random.nextInt(width) + 1;
				oy = random.nextInt(height) + 1;
			}

			else {
				oy = Integer.parseInt(scan.next());

				if (!(1 <= ox && ox <= width)) {
					System.out.print("\n! x값이 바둑판의 범위를 벗아났습니다. 다시 입력하세요.");
					if (!(1 <= oy && oy <= height))
						System.out.print("\n! y값이 바둑판의 범위를 벗아났습니다. 다시 입력하세요.");
					System.out.println();
					continue;
				} else if (!(1 <= oy && oy <= height)) {
					System.out.print("\n! y값이 바둑판의 범위를 벗아났습니다. 다시 입력하세요.");
					System.out.println();
					continue;
				}
			}

			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					if (x == ox && y == oy)
						System.out.print("○");

					else if (x == 1 && y == 1)
						System.out.print("┌");
					else if (x == 1 && y == height)
						System.out.print("└");
					else if (x == width && y == 1)
						System.out.print("┐");
					else if (x == width && y == height)
						System.out.print("┘");

					else if (x == 1)
						System.out.print("├");
					else if (x == width)
						System.out.print("┤");
					else if (y == 1)
						System.out.print("┬");
					else if (y == height)
						System.out.print("┴");

					else
						System.out.print("┼");
				System.out.println();
			}
		}
		System.out.println("\n! 종료되었습니다.");
		scan.close();
	}

}
