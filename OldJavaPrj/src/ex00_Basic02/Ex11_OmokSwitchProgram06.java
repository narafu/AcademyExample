package ex00_Basic02;
import java.util.Random;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram06 {

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
			System.out.print("> 세로 길이: \n");
			height = Integer.parseInt(scan.next());
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

		scan.close();

		// 바둑돌 + 바둑판
		while (true) {

			Random random = new Random();

			int ox = random.nextInt(width) + 1;
			int oy = random.nextInt(height) + 1;

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
	}

}
