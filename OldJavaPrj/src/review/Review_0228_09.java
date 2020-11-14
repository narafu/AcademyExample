package review;

import java.util.Scanner;

public class Review_0228_09 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("반복할 횟수를 입력하세요 > ");
		int x = scan.nextInt();
		System.out.println();

		for (int i = 0; i < x; i++)
			System.out.println("안녕하세요");
		
		scan.close();
	}

}
