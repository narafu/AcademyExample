package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0305_01 {

	public static void main(String[] args) throws IOException {

		// ���ڿ�, ���� ���

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0305n.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0305n.txt");

		fos.write(50);
		fos.write(100);

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

		fis.close();
		fos.close();

	}

}
