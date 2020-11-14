package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0229_03 {

	public static void main(String[] args) throws IOException {

		// img.jpg 파일을 1byte씩 복사하기

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0229.jpg");

		int x;
		while ((x = fis.read()) != -1)
			fos.write(x);

		fos.close();
		fis.close();
		System.out.println("작업완료");

	}
}
