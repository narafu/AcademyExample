package ex00_Basic02;

public class Ex10_StarProgram04 {

	public static void main(String[] args) {

//		for (int y = 1; y <= 3; y++)
//			for (int x = 1; x <= 5; x++) {
//				if (x == 3)
//					System.out.print("★");
//				else if (x == 5)
//					System.out.println("☆");
//				else
//					System.out.print("☆");
//			}

		for (int y = 1; y <= 3; y++) {
			for (int x = 1; x <= 5; x++)
				if (x == 3)
					System.out.print("★");
				else
					System.out.print("☆");

			System.out.println();
		}

	}

}

// 두 가지 방법이다.