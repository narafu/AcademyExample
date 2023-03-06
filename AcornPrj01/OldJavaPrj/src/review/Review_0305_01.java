package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0305_01 {

	public static void main(String[] args) throws IOException {

		// 문자열, 숫자 출력

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0305n.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0305n.txt");

		fos.write(50);
		fos.write(100);

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		System.out.printf("x(%d)와 y(%d)의 합은 z(%d)입니다.", x, y, z);

		fis.close();
		fos.close();

	}

}
