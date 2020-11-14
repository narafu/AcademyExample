package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		System.out.println("> 바둑판 크기를 선택하세요.");
		System.out.println("1. (20 x 20)");
		System.out.println("2. (30 x 30)");
		System.out.println("3. (40 x 40)");
		System.out.println("4. 사용자 설정");

		do {
			System.out.print("> ");
			menu = Integer.parseInt(scan.nextLine());
			if (!(1 <= menu && menu <= 4))
				System.out.println("> 잘못 입력하셨습니다. 범위 값(1~4)을 입력하세요.\n");
		} while (!(1 <= menu && menu <= 4));

		switch (menu) {
		case 1:
			width = 20;
			height = 20;
			break;
		case 2:
			width = 30;
			height = 30;
			break;
		case 3:
			width = 40;
			height = 40;
			break;
		case 4:
			System.out.print("\n> 바둑판 크기를 입력하세요 (x, y) > ");
			width = Integer.parseInt(scan.next());
			height = Integer.parseInt(scan.next());
			break;
		}

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == 1 && y == height)
					System.out.print("└");
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

		int ox = 0;
		int oy = 0;

		System.out.printf("> x범위: %d, y범위: %d\n", width, height);
		System.out.print("> 범위내 바둑돌 위치를 입력하세요 (x, y) > ");

		do {
			ox = Integer.parseInt(scan.next());
			oy = Integer.parseInt(scan.next());
			if (!(ox <= width && oy <= height)) {
				System.out.println("> 바둑판 범위를 벗아났습니다.");
				System.out.println();
				System.out.print("> 다시 입력하세요. > ");
			}
		} while (!(ox <= width && oy <= height));

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == ox && y == oy)
					System.out.print("○");

				else if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == 1 && y == height)
					System.out.print("└");
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
		
	}

}
