package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokProgram05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print(" *오목판의 가로 길이를 입력하세요 > ");
		int width = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *오목판의 세로 길이를 입력하세요 > ");
		int height = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *바둑돌의 가로 위치 > ");
		int ox = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *바둑돌의 세로 위치 > ");
		int oy = Integer.parseInt(scan.nextLine()) + 1;

		scan.close();

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				// 바둑돌
				if (y == oy && x == ox) {
					if (ox == width)
						System.out.print("○");
					else
						System.out.print("○─");
				}

				// 꼭지점
				else if (y == 1 && x == 1)
					System.out.print("┌─");
				else if (y == 1 && x == width)
					System.out.print("┐");
				else if (y == height && x == 1)
					System.out.print("└─");
				else if (y == height && x == width)
					System.out.print("┘");

				// 오목판 외부
				else if (y == 1)
					System.out.print("┬─");
				else if (x == 1)
					System.out.print("├─");
				else if (x == width)
					System.out.print("┤");
				else if (y == height)
					System.out.print("┴─");

				// 오목판 내부
				else
					System.out.print("┼─");
			System.out.println();
		}

		System.out.println(" *작업완료");
	}
}
