package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_CopyProgram02 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\bindata2.txt");

		fos.write(84);
		fos.write(123);

		fos.close();

		FileInputStream fis = new FileInputStream("C:\\Workspace\\bindata2.txt");

		int x = fis.read();
		int y = fis.read();
		int result = x + y;

		fis.close();

		System.out.println(result);
		System.out.println("작업완료");

	}
}