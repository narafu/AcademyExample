package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0306_01 {

	public static void main(String[] args) throws IOException {

		// 문자열, 숫자 출력

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0306.txt");
		PrintStream ps = new PrintStream(fos);
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0306.txt");
		Scanner scan = new Scanner(fis);

		fos.write(50);
		fos.write(55);

		int a = fis.read();
		int b = fis.read();
		int c = a + b;

		ps.println(50);
		ps.println(55);

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		System.out.printf("숫자열 출력 a(%d)와 b(%d)의 합은 c(%d)입니다.\n", a, b, c);
		System.out.printf("문자열 출력 x(%d)와 y(%d)의 합은 z(%d)입니다.", x, y, z);

		scan.close();
		ps.close();

	}

}
