package review;

import java.util.Scanner;

public class Review_0229_04 {

	public static void main(String[] args) {

		// �ֿܼ� ���ϸ� �Է� �ް�, �ֿܼ� ���ϸ�, ���ϸ� ��ȯ, ���ϸ� ���� ����ϱ�

		Scanner scan = new Scanner(System.in);

		System.out.print("���� ���� �Է��ϼ��� > ");
		String fileName = scan.next();

		System.out.println();
		System.out.println("<ó�����>");
		System.out.printf("���ϸ� ���: %s\n", fileName);
		System.out.printf("���ϸ� ��ȯ: %s\n", fileName.toUpperCase());
		System.out.printf("���ϸ� ����: %d", fileName.length());

		scan.close();

	}
}
