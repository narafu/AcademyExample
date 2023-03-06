package ex00_Basic02;
import java.util.Scanner;

public class Ex08_WhileProgram02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("반복 횟수를 입력하세요 > ");
		String x_ = scan.nextLine(); // 프롬프트 유발자 (입력창)
		int x = Integer.parseInt(x_);

		scan.close();

		System.out.printf("x is %d\n", x);

		int i = 0;
		while (i++ < x)
			System.out.println("사랑합니다");
	}

}

