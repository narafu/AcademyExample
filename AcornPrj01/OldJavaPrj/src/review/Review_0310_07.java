package review;

import java.util.Scanner;

public class Review_0310_07 {

	public static void main(String[] args) {

		// ���ϸ� �빮�� ����

		Scanner scan = new Scanner(System.in);

		System.out.print("���ϸ� �Է� > ");
		String fileName = scan.nextLine();

		System.out.printf("���ϸ� ���: %s\n", fileName);
		System.out.printf("���ϸ� ��ȯ: %s\n", fileName.toUpperCase());
		System.out.printf("���ϸ� ���: %d", fileName.length());

		scan.close();
	}

}
