package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0307_01 {

	public static void main(String[] args) throws IOException {

		// ����, ���ڿ� ���

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0308.txt");

		fos.write(30);
		fos.write(40);

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0308.txt");

		int a = fis.read();
		int b = fis.read();
		int c = a + b;

		System.out.printf("���� a(%d)�� b(%d)�� ���� c(%d)�Դϴ�.\n", a, b, c);

		PrintStream ps = new PrintStream(fos);

		ps.println(44);
		ps.println(55);

		Scanner scan = new Scanner(fis);

		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = x + y;

		System.out.printf("���ڿ� x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

		scan.close();
		ps.close();

	}

}
