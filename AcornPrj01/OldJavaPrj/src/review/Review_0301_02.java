package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0301_02 {

	public static void main(String[] args) throws IOException {

		// x, y���� ���ڿ� �������� data.txt �Է��ϰ�, �ֿܼ� ���(z) ����ϱ�

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0301.txt");
		PrintStream ps = new PrintStream(fos);
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0301.txt");
		Scanner scan = new Scanner(fis);

		ps.println(214);
		ps.println(432);

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

		scan.close();
		ps.close();
		
	}

}
