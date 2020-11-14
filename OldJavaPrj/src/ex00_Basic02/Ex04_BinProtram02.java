package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_BinProtram02 {

	public static void main(String[] args) throws IOException {

// 숫자로 저장하여 숫자로 불러오기

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\bindata.txt");
		fos.write(31);
		fos.write(65);
		fos.flush();
		fos.close();

		FileInputStream fis = new FileInputStream("C:\\Workspace\\bindata.txt");
		int x = fis.read();
		int y = fis.read();
		fis.close();

		int result = x + y;
		
		System.out.println(result);

	}

}
