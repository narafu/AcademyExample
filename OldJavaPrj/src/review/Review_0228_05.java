package review;

import java.util.Scanner;

public class Review_0228_05 {

	public static void main(String[] args) {

	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���ϸ� �Է� > ");
		String fileName = scan.next();
		
		System.out.println();
		System.out.printf("���ϸ� ���: %s\n", fileName);
		System.out.printf("���ϸ� ��ȯ: %s\n", fileName.toUpperCase());
		System.out.printf("���ϸ� ����: %d\n", fileName.length());
		
		scan.close();
	}

}
