package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_CopyProgram {

	public static void main(String[] args) throws IOException {

//		1. �̹��� ������ �б� ���� ���� ��ü fis�� ���� ���� ���� ��ü  fos�� �����ϰ�
		FileInputStream fis = new FileInputStream("C:\\workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\img-copy.jpg");
				
//		2. �б� ���� ��ü fis���� 1Byte�� �о fos�� 1Byte�� �����Ѵ�. �̰��� ������ �ݺ��Ѵ�.

		int b;
		while((b = fis.read()) != -1)
			fos.write(b);
		
//		3. �ݺ��� ������ fos�� fis�� �ڿ��� ��ȯ�Ѵ�.
		fos.close();
		fis.close();
		
		System.out.println("�۾��Ϸ�");
		
	}

}