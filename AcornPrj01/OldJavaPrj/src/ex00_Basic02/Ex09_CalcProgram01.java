package ex00_Basic02;
import java.util.Scanner;

public class Ex09_CalcProgram01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("x���� �Է��ϼ��� > ");
		int x = Integer.parseInt(scan.nextLine());

		System.out.print("y���� �Է��ϼ��� > ");
		int y = Integer.parseInt(scan.nextLine());

		scan.close();
		System.out.printf("x + y�� ���� ����� %d�Դϴ�.", x + y);

	}
}

/*
 * x ���� �Է��ϼ��� >
 * y ���� �Է��ϼ��� >
 * 
 * x+y ���� ����� 23�Դϴ�.
 */
