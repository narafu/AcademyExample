package review;

import java.util.Random;
import java.util.Scanner;

public class Review_0308_switch01 {

	public static void main(String[] args) {

		// switch

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int index = 6;
		int omok = 10;
		int[] lotto = new int[index];

		Exit: while (true) {

			System.out.println("< ���α׷�  >");
			System.out.println("1. ����");
			System.out.println("2. �ζ�");
			System.out.println("3. ����");
			System.out.print("���ϴ� ������ �Է��ϼ��� > ");
			int menu = Integer.parseInt(scan.next());

			switch (menu) {

			case 1:
				System.out.println();
				for (int y = 1; y <= omok; y++) {
					for (int x = 1; x <= omok; x++)
						if (x == 1 && y == 1)
							System.out.print("��");
						else if (x == omok && y == 1)
							System.out.print("��");
						else if (x == 1 && y == omok)
							System.out.print("��");
						else if (x == omok && y == omok)
							System.out.print("��");
						else if (x == 1)
							System.out.print("��");
						else if (x == omok)
							System.out.print("��");
						else if (y == 1)
							System.out.print("��");
						else if (y == omok)
							System.out.print("��");
						else
							System.out.print("��");
					System.out.println();
				}
				System.out.println();
				break;

			case 2:
				System.out.println();
				for (int i = 0; i < index; i++)
					lotto[i] = random.nextInt(45) + 1;
				for (int i = 0; i < index - 1; i++) {
					for (int j = 0; j < index - 1 - i; j++) {
						if (lotto[j] > lotto[j + 1]) {
							int temp = lotto[j];
							lotto[j] = lotto[j + 1];
							lotto[j + 1] = temp;
						}
					}
				}
				for (int i = 0; i < index; i++)
					System.out.printf("%d ", lotto[i]);
				System.out.println();
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println("����Ǿ����ϴ�.");
				break Exit;
			}
		}

	}
}
