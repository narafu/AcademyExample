package ex00_Basic02;
import java.util.Scanner;

public class Ex08_WhileProgram01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("�ݺ��� Ƚ���� �Է��ϼ��� > ");
		int x = scan.nextInt();

		int i = 0;

		scan.close();
		
		System.out.println();
		while (i < x) {
			i++;
			System.out.println("�ȳ��ϼ���");
		}

	}

}
