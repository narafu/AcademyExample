package ex08_OOPĸ��ȭ_Omok;

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
			System.out.println("� �ٵ��� ũ�⸦ ���Ͻʴϱ�?");
			System.out.println("1. (20x20)");
			System.out.println("2. (40x20)");
			System.out.println("3. (60x30)");
			System.out.print("> ");

			String menu_ = scan.nextLine();
			// �Է� ���� ���ڹ����� �ִ��� ��ȿ�� �˻�
			menu = Integer.parseInt(menu_);

			// ��ȿ�� �˻�
			if (1 <= menu && menu <= 3)
				break;
			else
				System.out.println("����� : 1~3������");
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
			System.out.println("1�� ���");
		default:
			width = 20;
			height = 20;
		}

		board = new char[height][width];
		xs = new int[height * width];
		ys = new int[height * width];

		// board = new char[?][?];

		// ������(Board)�� ����ϴµ� ���� �ٷ� ����ϴ� ���

		// �������� ����� ����� �޸𸮿� ��� �����ѳ���

		// ���߿� �ʿ��ϸ� ���Ƽ� ����ϱ�

		/*
		 * if(menu == 2) { width = 40; height = 20; } else if(menu == 3) { width = 60;
		 * height = 30; } else { // ���⼭�� �⺻ ���̶� �޴� ����(1,2,3) ���� ���� �Է� �Ǿ��� ���� �⺻ �� width
		 * = 20; height = 20; }
		 */

		// �ڵ� �ؼ��� ������ ���̼�
		// 1. ������ �̿��϶�

		// System.out.print("��");

		// �ٵ��� �׸��� : �������� �׸���
		for (int y = 1; y <= height; y++)
			for (int x = 1; x <= width; x++)
				board[y - 1][x - 1] = '��';// []['��']['��']['��']['��']'��'

		// ������ �� ���ڷ� �����Ͻÿ�.
		for (int x = 1; x <= width; x++)
			board[0][x - 1] = '��';

		// �������� �� ���ڷ� �����Ͻÿ�.
		for (int y = 1; y <= height; y++)
			board[y - 1][width - 1] = '��'; // y �� ��ǥ�� y-1 ��ǥ�� �迭 �ε���

		// ����
		for (int x = 1; x <= width; x++)
			board[height - 1][x - 1] = '��';

		// , ���� ���� �����Ͻÿ�.
		for (int y = 1; y <= height; y++)
			board[y - 1][0] = '��';

		// 4���� ������ �����Ͻÿ�.
		board[0][0] = '��';
		board[0][width - 1] = '��';
		board[height - 1][0] = '��';
		board[height - 1][width - 1] = '��';

		// �ٵ��� ����ϱ�
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				System.out.printf("%c", board[y - 1][x - 1]);

			System.out.println();
		}

		while (true) {
			// ��������� ������ �Է� �޾Ƽ� �װ��� �����ǿ� �д�.
			System.out.print("(x sp y)>");
			String ox_ = scan.next();
			ox = Integer.parseInt(ox_);

			String oy_ = scan.next();
			oy = Integer.parseInt(oy_);
			// �����ǿ� ���� ������ �νÿ�
			// board[oy-1][ox-1] = '��';

			// ���� �Էµ� ���� ��ġ�� xs, ys �迭�� �߰��ϱ�
			xs[index] = ox;
			ys[index] = oy;
			index++;

			// �����ǿ� ����迭�� ��ġ�� ������ �α�
			// for ���� �̿��ؼ� ������ ������ŭ ���鼭 ��� ������ board�� �α�� �Ѵ�.
			for (int i = 0; i < index; i++) {
				int x = xs[i];
				int y = ys[i];
				board[y][x] = '��';
			}

			// �ٵ��� ����ϱ�
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					System.out.printf("%c", board[y - 1][x - 1]);

				System.out.println();
			}
		}

		// �ٵ��� �׸��� : ������ �׸���

		/*
		 * for(int y=1;y<=height;y++) { for(int x=1;x<=width;x++) if(x==ox&&y==oy)
		 * System.out.print("��"); else if(x==1&&y==1) System.out.print("��"); else
		 * if(x==width&&y==1) System.out.print("��"); else if(x==1&&y==height)
		 * System.out.print("��"); else if(x==width&&y==height) System.out.print("��");
		 * else if(x==1) System.out.print("��"); else if(x==width) System.out.print("��");
		 * else if(y==1) System.out.print("��"); else if(y==height)
		 * System.out.print("��"); else System.out.print("��");
		 * 
		 * System.out.println(); } /*
		 * 
		 * // (x sp y)>_ // (x sp y) or exit(-1)>5 6 // (x sp y) or exit(-1)>-1 // ox =
		 * 5 // oy = 6
		 * 
		 * // Random ������ rand ��ü�� �����Ͻÿ�. Random rand = new Random();
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
		 * ���� 1<=ox<=�ʺ� ������ �Ӱ��� �ƴ϶��?{ �ٽ� �Է���!! continue; }
		 */

		/*
		 * for(int y=1;y<=height;y++) { for(int x=1;x<=width;x++) if(x==ox&&y==oy)
		 * System.out.print("��"); else if(x==1&&y==1) System.out.print("��"); else
		 * if(x==width&&y==1) System.out.print("��"); else if(x==1&&y==height)
		 * System.out.print("��"); else if(x==width&&y==height) System.out.print("��");
		 * else if(x==1) System.out.print("��"); else if(x==width) System.out.print("��");
		 * else if(y==1) System.out.print("��"); else if(y==height)
		 * System.out.print("��"); else System.out.print("��");
		 * 
		 * System.out.println(); }
		 * 
		 * }
		 */

		/*
		 * 20x20
		 * 
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ���������������������������������������� ����������������������������������������
		 * ���������������������������������������� ����������������������������������������
		 * 
		 */

	}

}