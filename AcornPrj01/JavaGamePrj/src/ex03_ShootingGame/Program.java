package ex03_ShootingGame;

import ex03_ShootingGame.ui.ShootingFrame;

public class Program {

	public static void main(String[] args) {

		ShootingFrame frame = new ShootingFrame();

		frame.setVisible(true);
		// -> frame.repaint
		// -> frame.update
		// -> frame.paint
		frame.setSize(600, 1000);

		// 비트연산자: 비트 단위로 연샅을 하는 연산자 - 정수단위가 너무 커서 비트단위로 연산해야할 때 사용한다.
//		int x = 0b0000_0000_0000_0000_0000_0000_0000_1111;
//		int y = 0x0000005;
//		int z = x | y;
//		System.out.printf("(x: %d), (y: %d), (z: %d)\n", x, y, z);

//		N(0001), NE(0011)
//		E(0010), ES(0110)
//		S(0100), SW(1100)
//		W(1000), NW(1001)

//		방패 = 0000_0001 / 방패 + 창: 0000_0011
//		창 = 0000_0010
//		신발 = 0000_0100

//		|(합) &(교) ^(차) ~(부정)

//		int 보유아이템 = 0b0000_0000_0000_0000_0000_0000_0000_0000;
//		final int 방패 = 0b0000_0000_0000_0000_0000_0000_0000_0001;
//		final int 날개 = 0b0000_0000_0000_0000_0000_0000_0000_0010;
//		final int 신발 = 0b0000_0000_0000_0000_0000_0000_0000_0100;

//		System.out.printf("보유아이템 현황\n%s\n", Integer.toBinaryString(보유아이템));
//		int temp = Integer.parseInt(Integer.toBinaryString(보유아이템));
//		System.out.printf("보유아이템 현황\n%032d\n", temp);
//
//		보유아이템 |= 신발;
//		보유아이템 |= 날개;
//		temp = Integer.parseInt(Integer.toBinaryString(보유아이템));
//		System.out.printf("보유아이템 현황\n%032d\n", temp);
//
//		보유아이템 ^= 날개; /* =(보유아이템 &= ~날개); */
//		temp = Integer.parseInt(Integer.toBinaryString(보유아이템));
//		System.out.printf("보유아이템 현황\n%032d\n", temp);
//
//		// 쉬프트 연산자
//		보유아이템 <<= 2;
//		temp = Integer.parseInt(Integer.toBinaryString(보유아이템));
//		System.out.printf("보유아이템 현황\n%032d\n", temp);
//
//		int pos = 0;
//		// (7, 5) -> pos
//		pos = (7 << 8) | 5;
//		temp = Integer.parseInt(Integer.toString(pos, 2));
//		System.out.printf("pos:\n%032d\n", temp);

	}

}
