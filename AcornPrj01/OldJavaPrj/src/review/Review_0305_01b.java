package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0305_01b {

	public static void main(String[] args) throws IOException {

		// 문자열, 숫자 출력

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0304.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0304.txt");

		PrintStream ps = new PrintStream(fos);
		Scanner scan = new Scanner(fis);

		fos.write(100);
		fos.write(150);

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		ps.println(100);
		ps.println(150);

		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = a + b;

		System.out.printf("숫자 출력 x(%d)와 y(%d)의 합은 z(%d)입니다.\n", x, y, z);
		System.out.printf("문자열 출력 a(%d)와 b(%d)의 합은 c(%d)입니다.", a, b, c);

	}

}
