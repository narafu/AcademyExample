package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
//     (��Ű��)    (Ŭ����) 
// ��Ű�� > Ŭ����(��ü entity) > �ν��Ͻ�(��ü object)

public class Ex03_SumProgram04 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos;
		PrintStream out;

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
		Scanner scan = new Scanner(fis);
		int ch = scan.nextInt();
		System.out.println(ch);
		scan.close();
		fis.close();

		fos = new FileOutputStream("C:\\workspace\\data.out");
//		������(��ü) �ٷ���(��ü) = new ������(��ü)
		out = new PrintStream(fos);

		out.print("Hello");
		out.close();

		System.out.println("�۾��Ϸ�");
	}

}
