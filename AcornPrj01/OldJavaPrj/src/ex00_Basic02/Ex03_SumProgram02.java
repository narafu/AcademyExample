package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data1.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int result = x + y;
		scan.close();
		fis.close();

// 1. ���� ����� ���� FileOutputStream ��ü fos�� �����Ѵ�.
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data2.txt");
// 2. ���ڿ� ����� ���� �ϱ� ���ؼ� PrintStream ��ü out�� �����Ѵ�.
		PrintStream out = new PrintStream(fos);
// 3. out ��ü�� println() �Լ��� �̿��ؼ� result ���� ����Ѵ�.
		out.println(result);
		out.close();
		fos.close();

		System.out.println("�۾��Ϸ�");

	}

}
