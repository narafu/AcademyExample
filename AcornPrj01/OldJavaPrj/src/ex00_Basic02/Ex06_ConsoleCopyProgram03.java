package ex00_Basic02;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName;
		String capital;
		int length;

		System.out.print("ΖΔΐΟ Έν: ");

		fileName = scan.nextLine();
		System.out.println(fileName);

		scan.close();
		
		capital = fileName.toUpperCase();
		System.out.println(capital);

		length = fileName.length();
		System.out.println(length);

	}

}
