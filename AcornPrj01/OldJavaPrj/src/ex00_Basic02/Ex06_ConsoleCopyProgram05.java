package ex00_Basic02;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���ϸ� �Է� > ");
		String fileName = scan.nextLine();
		
		String capital = fileName.toUpperCase();
		int length = fileName.length();
		
		System.out.println();
		System.out.printf("���ϸ� ���: %s\n", fileName);
		System.out.printf("���ϸ� �빮��: %s\n", capital);
		System.out.printf("���ϸ� ����: %d\n", length);

		scan.close();
		
		
	}
}
