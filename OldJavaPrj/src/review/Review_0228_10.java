package review;

import java.util.Scanner;

public class Review_0228_10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("x를 입력하세요 > ");
		int x = scan.nextInt();
		System.out.print("y를 입력하세요 > ");
		int y = scan.nextInt();

		int z = x + y;
		System.out.printf("x(%d)와 y(%d)의 합은 %d", x, y, z);

		scan.close();
	}

}
