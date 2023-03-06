package review;

import java.util.Scanner;

public class Review_0310_07 {

	public static void main(String[] args) {

		// 파일명 대문자 길이

		Scanner scan = new Scanner(System.in);

		System.out.print("파일명 입력 > ");
		String fileName = scan.nextLine();

		System.out.printf("파일명 출력: %s\n", fileName);
		System.out.printf("파일명 변환: %s\n", fileName.toUpperCase());
		System.out.printf("파일명 출력: %d", fileName.length());

		scan.close();
	}

}
