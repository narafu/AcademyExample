package review;

import java.util.Scanner;

public class Review_0228_10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("x�� �Է��ϼ��� > ");
		int x = scan.nextInt();
		System.out.print("y�� �Է��ϼ��� > ");
		int y = scan.nextInt();

		int z = x + y;
		System.out.printf("x(%d)�� y(%d)�� ���� %d", x, y, z);

		scan.close();
	}

}
