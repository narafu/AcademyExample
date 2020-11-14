package ex08_OOP캡슐화_Omok;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		char[][] board;
		// int[] lotto = new int[6];
		// int[][] lottos = new int[5][6];
		int[] xs;
		int[] ys;
		int index = 0;

		final int width;
		final int height;

		int ox = -1;
		int oy = -1;

		Scanner scan = new Scanner(System.in);
		int menu;

		while (true) {
			System.out.println("어떤 바둑판 크기를 원하십니까?");
			System.out.println("1. (20x20)");
			System.out.println("2. (40x20)");
			System.out.println("3. (60x30)");
			System.out.print("> ");

			String menu_ = scan.nextLine();
			// 입력 값이 숫자범위에 있는지 유효성 검사
			menu = Integer.parseInt(menu_);

			// 유효성 검사
			if (1 <= menu && menu <= 3)
				break;
			else
				System.out.println("사용방법 : 1~3까지만");
		}

		switch (menu) {
		case 2:
			width = 40;
			height = 20;
			break;
		case 3:
			width = 60;
			height = 30;
			break;
		case 1:
			System.out.println("1번 장소");
		default:
			width = 20;
			height = 20;
		}

		board = new char[height][width];
		xs = new int[height * width];
		ys = new int[height * width];

		// board = new char[?][?];

		// 오목판(Board)을 출력하는데 직접 바로 출력하는 방식

		// 오목판을 출력할 모양을 메모리에 잠깐 기억시켜놓고

		// 나중에 필요하면 몰아서 출력하기

		/*
		 * if(menu == 2) { width = 40; height = 20; } else if(menu == 3) { width = 60;
		 * height = 30; } else { // 여기서의 기본 값이란 메뉴 범위(1,2,3) 밖의 값이 입력 되었을 때의 기본 값 width
		 * = 20; height = 20; }
		 */

		// 코드 해석과 수정의 용이성
		// 1. 변수를 이용하라

		// System.out.print("○");

		// 바둑판 그리기 : 비절차식 그리기
		for (int y = 1; y <= height; y++)
			for (int x = 1; x <= width; x++)
				board[y - 1][x - 1] = '┼';// []['┼']['┼']['┼']['┼']'┼'

		// 상판을 ┬ 문자로 변경하시오.
		for (int x = 1; x <= width; x++)
			board[0][x - 1] = '┬';

		// 우측벽을 ┤ 문자로 변경하시오.
		for (int y = 1; y <= height; y++)
			board[y - 1][width - 1] = '┤'; // y 는 좌표고 y-1 좌표의 배열 인덱스

		// 밑판
		for (int x = 1; x <= width; x++)
			board[height - 1][x - 1] = '┴';

		// , 왼쪽 벽을 변경하시오.
		for (int y = 1; y <= height; y++)
			board[y - 1][0] = '├';

		// 4개의 꼭지점 변경하시오.
		board[0][0] = '┌';
		board[0][width - 1] = '┐';
		board[height - 1][0] = '└';
		board[height - 1][width - 1] = '┘';

		// 바둑판 출력하기
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				System.out.printf("%c", board[y - 1][x - 1]);

			System.out.println();
		}

		while (true) {
			// 사용자한테 오목을 입력 받아서 그것을 오목판에 둔다.
			System.out.print("(x sp y)>");
			String ox_ = scan.next();
			ox = Integer.parseInt(ox_);

			String oy_ = scan.next();
			oy = Integer.parseInt(oy_);
			// 오목판에 위의 오목을 두시오
			// board[oy-1][ox-1] = '○';

			// 새로 입력된 오목 위치를 xs, ys 배열에 추가하기
			xs[index] = ox;
			ys[index] = oy;
			index++;

			// 오목판에 오목배열의 위치에 오목을 두기
			// for 문을 이용해서 오목의 개수만큼 돌면서 모든 오목을 board에 두기로 한다.
			for (int i = 0; i < index; i++) {
				int x = xs[i];
				int y = ys[i];
				board[y][x] = '○';
			}

			// 바둑판 출력하기
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					System.out.printf("%c", board[y - 1][x - 1]);

				System.out.println();
			}
		}

		// 바둑판 그리기 : 절차식 그리기

		/*
		 * for(int y=1;y<=height;y++) { for(int x=1;x<=width;x++) if(x==ox&&y==oy)
		 * System.out.print("○"); else if(x==1&&y==1) System.out.print("┌"); else
		 * if(x==width&&y==1) System.out.print("┐"); else if(x==1&&y==height)
		 * System.out.print("└"); else if(x==width&&y==height) System.out.print("┘");
		 * else if(x==1) System.out.print("├"); else if(x==width) System.out.print("┤");
		 * else if(y==1) System.out.print("┬"); else if(y==height)
		 * System.out.print("┴"); else System.out.print("┼");
		 * 
		 * System.out.println(); } /*
		 * 
		 * // (x sp y)>_ // (x sp y) or exit(-1)>5 6 // (x sp y) or exit(-1)>-1 // ox =
		 * 5 // oy = 6
		 * 
		 * // Random 형식의 rand 객체를 생성하시오. Random rand = new Random();
		 * 
		 * while(true) {
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * ox = rand.nextInt(width)+1; oy = rand.nextInt(height)+1;
		 * 
		 * 
		 * /* System.out.print("(x sp y)>"); String ox_ = scan.next(); ox =
		 * Integer.parseInt(ox_);
		 * 
		 * if(ox == -1) { System.out.println("Bye~~"); break; }
		 * 
		 * String oy_ = scan.next(); oy = Integer.parseInt(oy_);
		 */

		/*
		 * 만약 1<=ox<=너비 범위으 ㅣ값이 아니라면?{ 다시 입력햇!! continue; }
		 */

		/*
		 * for(int y=1;y<=height;y++) { for(int x=1;x<=width;x++) if(x==ox&&y==oy)
		 * System.out.print("○"); else if(x==1&&y==1) System.out.print("┌"); else
		 * if(x==width&&y==1) System.out.print("┐"); else if(x==1&&y==height)
		 * System.out.print("└"); else if(x==width&&y==height) System.out.print("┘");
		 * else if(x==1) System.out.print("├"); else if(x==width) System.out.print("┤");
		 * else if(y==1) System.out.print("┬"); else if(y==height)
		 * System.out.print("┴"); else System.out.print("┼");
		 * 
		 * System.out.println(); }
		 * 
		 * }
		 */

		/*
		 * 20x20
		 * 
		 * ┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
		 * ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼ ┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴
		 * 
		 */

	}

}