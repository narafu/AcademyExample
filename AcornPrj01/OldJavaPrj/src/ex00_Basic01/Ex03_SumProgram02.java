package ex00_Basic01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Ex03_SumProgram02 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out");
//		������(��ü) �ٷ���(��ü) = new ������(��ü)

		PrintStream out = new PrintStream(fos);
		out.print("Hello");
		out.close();
		System.out.println("�۾��Ϸ�");
	}

}
