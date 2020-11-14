package ex00_Basic02;
import java.util.Random;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram07 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		// ���θ޴�
		System.out.println("Q. �ٵ����� ũ�⸦ �����ϼ���");
		System.out.println("1. (10 x 10)");
		System.out.println("2. (20 x 20)");
		System.out.println("3. (30 x 30)");
		System.out.println("4. ����� ����");

		do {
			System.out.print("\n> �Է� : ");
			menu = Integer.parseInt(scan.nextLine());
			if (!(1 <= menu && menu <= 4))
				System.out.println("! ���� ��(1~4)�� ������ϴ�. �ٽ� �Է��ϼ���.");

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
			System.out.println("\nQ. ���ϴ� ũ�⸦ �Է��ϼ���.");
			System.out.print("> ���� ����: ");
			width = Integer.parseInt(scan.next());
			System.out.print("> ���� ����: ");
			height = Integer.parseInt(scan.next());
			System.out.println();
		}

		// �ٵ���
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("��");
				else if (x == 1 && y == height)
					System.out.print("��");
				else if (x == width && y == 1)
					System.out.print("��");
				else if (x == width && y == height)
					System.out.print("��");

				else if (x == 1)
					System.out.print("��");
				else if (x == width)
					System.out.print("��");
				else if (y == 1)
					System.out.print("��");
				else if (y == height)
					System.out.print("��");

				else
					System.out.print("��");

			System.out.println();
		}

		// �ٵϵ� + �ٵ���
		while (true) {

			Random random = new Random();

			int ox = 0;
			int oy = 0;

			System.out.print("\n�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��\n");
			System.out.printf("\n<x����: %d, y����: %d>", width, height);
			System.out.print("\nQ. �ٵϵ��� ���� ��ġ�� �Է��ϼ���. (x, y) or Random(0) or Exit(-1): ");
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
					System.out.print("\n! x���� �ٵ����� ������ ���Ƴ����ϴ�. �ٽ� �Է��ϼ���.");
					if (!(1 <= oy && oy <= height))
						System.out.print("\n! y���� �ٵ����� ������ ���Ƴ����ϴ�. �ٽ� �Է��ϼ���.");
					System.out.println();
					continue;
				} else if (!(1 <= oy && oy <= height)) {
					System.out.print("\n! y���� �ٵ����� ������ ���Ƴ����ϴ�. �ٽ� �Է��ϼ���.");
					System.out.println();
					continue;
				}
			}

			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					if (x == ox && y == oy)
						System.out.print("��");

					else if (x == 1 && y == 1)
						System.out.print("��");
					else if (x == 1 && y == height)
						System.out.print("��");
					else if (x == width && y == 1)
						System.out.print("��");
					else if (x == width && y == height)
						System.out.print("��");

					else if (x == 1)
						System.out.print("��");
					else if (x == width)
						System.out.print("��");
					else if (y == 1)
						System.out.print("��");
					else if (y == height)
						System.out.print("��");

					else
						System.out.print("��");
				System.out.println();
			}
		}
		System.out.println("\n! ����Ǿ����ϴ�.");
		scan.close();
	}

}
