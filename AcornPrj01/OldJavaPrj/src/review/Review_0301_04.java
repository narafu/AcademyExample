package review;

import java.util.Scanner;

public class Review_0301_04 {

	public static void main(String[] args) {

		// 콘솔에 파일명 입력 받고, 콘솔에 파일명, 파일명 변환, 파일명 길이 출력하기

		Scanner scan = new Scanner(System.in);

		System.out.print("파일 명 입력 > ");
		String fileName = scan.next();

		System.out.println("<처리결과>");
		System.out.printf("파일명 출력: %s\n", fileName);
		System.out.printf("파일명 변환: %s\n", fileName.toUpperCase());
		System.out.printf("파일명 길이: %d", fileName.length());

		scan.close();

	}

}
