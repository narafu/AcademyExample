package ex00_Basic01;
import java.io.IOException;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram2 {

	public static void main(String[] args) throws IOException {

		System.out.print("┌──────────────────────────────┐\n");
		System.out.print("│         Copy program         │\n");
		System.out.print("└──────────────────────────────┘\n");
		System.out.print("\n 복사할 파일명 > ");

		Scanner scan = new Scanner(System.in);

		String fileName = scan.nextLine();
		System.out.println(fileName);

		int length = fileName.length();
		System.out.println(length);

		String upfileName = fileName.toUpperCase();
		System.out.println(upfileName);
		
	}

}