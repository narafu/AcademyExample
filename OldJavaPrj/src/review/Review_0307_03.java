package review;

import java.util.Scanner;

public class Review_0307_03 {

	public static void main(String[] args) {

		// ���ϸ� �빮�� ����

		Scanner scan = new Scanner(System.in);

		System.out.print("���ϸ� �Է� > ");
		String fileName = scan.nextLine();
		System.out.println();

		System.out.printf("���ϸ� ���: %s\n", fileName);
		System.out.printf("���ϸ� ��ȯ: %s\n", fileName.toUpperCase());
		System.out.printf("���ϸ� ����: %d\n", fileName.length());

		scan.close();

	}

}
