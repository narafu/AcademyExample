package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0305_01b {

	public static void main(String[] args) throws IOException {

		// ���ڿ�, ���� ���

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

		System.out.printf("���� ��� x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.\n", x, y, z);
		System.out.printf("���ڿ� ��� a(%d)�� b(%d)�� ���� c(%d)�Դϴ�.", a, b, c);

	}

}
