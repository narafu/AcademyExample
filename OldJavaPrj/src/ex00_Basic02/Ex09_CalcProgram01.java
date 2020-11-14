package ex00_Basic02;
import java.util.Scanner;

public class Ex09_CalcProgram01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("x값을 입력하세요 > ");
		int x = Integer.parseInt(scan.nextLine());

		System.out.print("y값을 입력하세요 > ");
		int y = Integer.parseInt(scan.nextLine());

		scan.close();
		System.out.printf("x + y의 덧셈 결과는 %d입니다.", x + y);

	}
}

/*
 * x 값을 입력하세요 >
 * y 값을 입력하세요 >
 * 
 * x+y 값의 결과는 23입니다.
 */
