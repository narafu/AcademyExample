package ex00_Basic02;
import java.util.Scanner;

public class Ex06_ConsoleCopyProgram02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("ΖΔΐΟ Έν : ");
		String name = scan.nextLine();
		System.out.println(name);

		scan.close();

		int length = name.length();
		System.out.println(length);

		String capital = name.toUpperCase();
		System.out.println(capital);

	}

}
