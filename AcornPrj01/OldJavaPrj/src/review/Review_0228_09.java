package review;

import java.util.Scanner;

public class Review_0228_09 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("�ݺ��� Ƚ���� �Է��ϼ��� > ");
		int x = scan.nextInt();
		System.out.println();

		for (int i = 0; i < x; i++)
			System.out.println("�ȳ��ϼ���");
		
		scan.close();
	}

}
