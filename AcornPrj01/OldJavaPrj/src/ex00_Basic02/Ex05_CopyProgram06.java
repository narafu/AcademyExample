package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_CopyProgram06 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img-copy(4).jpg");

		int x;

		while ((x = fis.read()) != -1)
			fos.write(x);

		fos.close();
		fis.close();

		System.out.println("�۾��Ϸ�");

	}

}
