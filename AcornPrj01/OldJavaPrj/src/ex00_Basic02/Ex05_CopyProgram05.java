package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_CopyProgram05 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img-copy(3).jpg");

		int x;

		while ((x = fis.read()) != -1)
			fos.write(x);

		fis.close();
		fos.close();

		System.out.println("작업완료");

	}
}