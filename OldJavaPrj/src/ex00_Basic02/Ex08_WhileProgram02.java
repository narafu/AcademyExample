package ex00_Basic02;
import java.util.Scanner;

public class Ex08_WhileProgram02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("�ݺ� Ƚ���� �Է��ϼ��� > ");
		String x_ = scan.nextLine(); // ������Ʈ ������ (�Է�â)
		int x = Integer.parseInt(x_);

		scan.close();

		System.out.printf("x is %d\n", x);

		int i = 0;
		while (i++ < x)
			System.out.println("����մϴ�");
	}

}

