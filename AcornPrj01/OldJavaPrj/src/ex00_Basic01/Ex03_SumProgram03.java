package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//     (��Ű��)    (Ŭ����) 
// ��Ű�� > Ŭ����(��ü entity) > �ν��Ͻ�(��ü object)

public class Ex03_SumProgram03 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
		
		int ch;

		ch = fis.read();
		System.out.println(ch);

		ch = fis.read();
		System.out.println(ch);
		
		fis.close();

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out");
//		������(��ü) �ٷ���(��ü) = new ������(��ü)

		PrintStream out = new PrintStream(fos);
		out.print("Hello");
		out.close();

		System.out.println("�۾��Ϸ�");
	}

}
