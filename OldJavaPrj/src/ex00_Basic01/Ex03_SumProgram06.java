package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram06 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int result = x + y;
		scan.close(); // ������ �������� �ݾƾ� �Ѵ�.
		fis.close(); // ������ �������� �ݾƾ� �Ѵ�.

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data2.txt");
//		1. ���� ����� ���� FileOutputStream ��ü fos�� �����Ѵ�.
		PrintStream out = new PrintStream(fos);
//		2. ���ڿ� ����� ���� �ϱ� ���ؼ� PrintStream ��ü out�� �����Ѵ�.
		out.println(result);
//		3. out ��ü�� println() �Լ��� �̿��ؼ� result ���� ����Ѵ�.
		out.close();
		fos.close();
						
		System.out.println("�۾��Ϸ�");
		
	}

}
