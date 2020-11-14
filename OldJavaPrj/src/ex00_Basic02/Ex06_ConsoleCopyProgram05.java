package ex00_Basic02;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일명 입력 > ");
		String fileName = scan.nextLine();
		
		String capital = fileName.toUpperCase();
		int length = fileName.length();
		
		System.out.println();
		System.out.printf("파일명 출력: %s\n", fileName);
		System.out.printf("파일명 대문자: %s\n", capital);
		System.out.printf("파일명 길이: %d\n", length);

		scan.close();
		
		
	}
}
