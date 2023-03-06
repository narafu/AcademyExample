package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_CopyProgram {

	public static void main(String[] args) throws IOException {

//		1. 이미지 파일을 읽기 위한 버퍼 객체 fis와 쓰기 위한 버퍼 객체  fos를 생성하고
		FileInputStream fis = new FileInputStream("C:\\workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\img-copy.jpg");
				
//		2. 읽기 버퍼 객체 fis에서 1Byte를 읽어서 fos에 1Byte를 쓰기한다. 이것을 끝까지 반복한다.

		int b;
		while((b = fis.read()) != -1)
			fos.write(b);
		
//		3. 반복이 끝나면 fos와 fis의 자원을 반환한다.
		fos.close();
		fis.close();
		
		System.out.println("작업완료");
		
	}

}