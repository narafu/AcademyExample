package ex00_Basic01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_BinProgram {

	public static void main(String[] args) throws IOException {

//		1. ���� 23�� 34�� ���ڰ� �ƴ� ���� �״�� ���Ͽ� ���⸦ �ϰ�,
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data-b.txt");
		fos.write(23);	// -> 8bit:1Byte max (0~255), 256 �̻��� �������� ���Ѵ�. 
		fos.write(34);	// ���ۿ� ������ ���(����)
		fos.flush();	// ���ۿ� ������ ������� ������ �Լ�
		fos.close();
		
//		2. ���Ͽ��� ���ڸ� �״�� �о
		FileInputStream fis = new FileInputStream("C:\\workspace\\data-b.txt");
		int x = fis.read();
		int y = fis.read();
		fis.close();
		int result = x + y;

//		3. �� ����� �ֿܼ� ����Ѵ�.
		System.out.println(result);

	}

}