package review._0320;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 파일복사 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0320.jpg");

		int x;

		while ((x = fis.read()) != -1) {
			fos.write(x);
		}

		System.out.println("작업완료");
		
	}

}
