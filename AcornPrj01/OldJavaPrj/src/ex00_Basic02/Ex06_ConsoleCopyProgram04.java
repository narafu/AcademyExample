package ex00_Basic02;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("���ϸ� �Է� > ");
		String fileName = scan.nextLine();
		
		String capital = fileName.toUpperCase();
		int length = fileName.length();
		
		scan.close();
			
		System.out.println();
		System.out.printf("���� ����: %s\n", fileName);
		System.out.printf("�빮�� ��ȯ: %s\n", capital);
		System.out.printf("���ϸ� ����: %d\n", length);
	}

}
