package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0229_01 {

	public static void main(String[] args) throws IOException {

		// x, y값을 숫자 형식으로 data.txt 입력하고, 콘솔에 결과(z) 출력하기

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0229.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0229.txt");

		fos.write(100);
		fos.write(1000);

		fos.close();

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		fis.close();
		System.out.printf("x(%d)와 y(%d)의 합은  z(%d)입니다.", x, y, z);

	}
}
