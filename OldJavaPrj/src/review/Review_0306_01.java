package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0306_01 {

	public static void main(String[] args) throws IOException {

		// ���ڿ�, ���� ���

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

		System.out.printf("���ڿ� ��� a(%d)�� b(%d)�� ���� c(%d)�Դϴ�.\n", a, b, c);
		System.out.printf("���ڿ� ��� x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

		scan.close();
		ps.close();

	}

}
