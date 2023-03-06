package ex00_Basic01;
import java.io.IOException;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram {

	public static void main(String[] args) throws IOException {

		System.out.print("┌──────────────────────────────┐\n");
		System.out.print("│         Copy program         │\n");
		System.out.print("└──────────────────────────────┘\n");

		System.out.print("\n 복사할 파일명 > ");

		Scanner scan = new Scanner(System.in);

		String name;

		name = scan.next();
		System.out.println(name);

		name = scan.next();
		System.out.println(name);

//		name = scan.nextLine();
//		System.out.println(name);

	}

}