package ex00_Basic02;
import java.util.Random;
import java.util.Scanner;

public class Ex12_LottoProgram01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int index = 3;
		int[] kors = new int[index];
		int menu;

		Exit: while (true) {

			menu = inputMenu();

			switch (menu) {
			case 1:
				inputKors(index, kors);
				System.out.println();
				break;

			case 2:
				printKors(index, kors);
				System.out.println();
				break;

			case 3:
				break Exit;

			}
		}

		scan.close();
		System.out.println("> ���α׷��� �����մϴ�.");

	}

	public static int inputMenu() {

		Scanner scan = new Scanner(System.in);
		System.out.println("< menu >");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ��     ��");
		System.out.print("�Է� > ");
		int menu = Integer.parseInt(scan.next());
		System.out.println();

		return menu;
	}

	public static void printKors(int index, int[] kors) {

		System.out.println("< ������� >");
		for (int i = 0; i < index; i++) {
			System.out.printf("- %d�г� ��������: %d\n", i + 1, kors[i]);
		}

	}

	public static void inputKors(int index, int[] kors) {

		Scanner scan = new Scanner(System.in);

		System.out.println("< �����Է� >");
		for (int i = 0; i < index; i++) {
			do {
				System.out.printf("- %d�г� ��������: ", i + 1);
				kors[i] = scan.nextInt();
				if (!(0 <= kors[i] && kors[i] <= 100))
					System.out.println("-> �Է¹���(0~100)�� ������ϴ�.");
			} while (!(0 <= kors[i] && kors[i] <= 100));

		}
	}

}
