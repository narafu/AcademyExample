package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0310_05 {

	public static void main(String[] args) throws IOException {

		// 숫자, 문자열 출력

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0310.txt");

		fos.write(32);
		fos.write(23);

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0310.txt");

		int a = fis.read();
		int b = fis.read();
		int c = a + b;

		System.out.printf("숫자출력 a(%d)와 b(%d)의 합은 c(%d)입니다.\n", a, b, c);

		PrintStream ps = new PrintStream(fos);
		ps.println(33);
		ps.println(44);

		Scanner scan = new Scanner(fis);

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		System.out.printf("문자열출력 x(%d)와 y(%d)의 합은 z(%d)입니다.", x, y, z);

	}

}
