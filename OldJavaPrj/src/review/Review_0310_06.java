package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0310_06 {

	public static void main(String[] args) throws IOException {

		// img.jpg copy

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0310.jpg");

		int x;
		while ((x = fis.read()) != -1)
			fos.write(x);

		System.out.println("작업완료");

		fos.close();
		fis.close();
	}

}
