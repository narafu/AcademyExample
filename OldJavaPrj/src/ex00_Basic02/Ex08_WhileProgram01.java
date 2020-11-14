package ex00_Basic02;
import java.util.Scanner;

public class Ex08_WhileProgram01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("반복할 횟수를 입력하세요 > ");
		int x = scan.nextInt();

		int i = 0;

		scan.close();
		
		System.out.println();
		while (i < x) {
			i++;
			System.out.println("안녕하세요");
		}

	}

}
