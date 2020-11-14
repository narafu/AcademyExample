package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0311_02 {

	public static void main(String[] args) throws IOException {

		// 숫자, 문자열 출력

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0311.txt");

		fos.write(25);
		fos.write(45);

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0311.txt");

		int numA = fis.read();
		int numB = fis.read();
		int sumN = numA + numB;

		System.out.printf("숫자 출력 A(%d)와 B(%d)의 합은 C(%d)입니다.\n", numA, numB, sumN);

		PrintStream ps = new PrintStream(fos);

		ps.println(44);
		ps.println(88);

		Scanner scan = new Scanner(fis);

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		System.out.printf("문자열출력 X(%d)와 Y(%d)의 합은 Z(%d)입니다.", x, y, z);

	}

}
