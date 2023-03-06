package ex03_ShootingGame.item;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import ex03_ShootingGame.ui.IntroCanvas;

public class StartButton implements Movable {

	public static final int STATE_ON = 0;
	public static final int STATE_OFF = 1;
	public static final int STATE_CLICK = 2;
	public static final Color COLOR_ON = new Color(100, 100, 100);
	public static final Color COLOR_OFF = new Color(0, 0, 0);
	public static final Color COLOR_CLICK = new Color(150, 0, 0);
	private double x, y;
	private int width, height, stateValue;

	public StartButton() {
		x = 100;
		y = 350;
		width = 160;
		height = 50;
		stateValue = STATE_OFF;
	}

	@Override
	public void dateUp() {

	}

	@Override
	public void draw(Graphics g) {

		Cursor cursor1 = new Cursor(Cursor.HAND_CURSOR);
		Cursor cursor2 = new Cursor(Cursor.DEFAULT_CURSOR);
		Color buttonColor;

		int x = (int) this.x;
		int y = (int) this.y;

		if (stateValue == STATE_ON) {
			buttonColor = COLOR_ON;
			IntroCanvas.getInstance().setCursor(cursor1);
		} else if (stateValue == STATE_CLICK) {
//			g.fillRoundRect(x, y, width, height, 50, 50);
			buttonColor = COLOR_CLICK;
		} else {
			buttonColor = COLOR_OFF;
			IntroCanvas.getInstance().setCursor(cursor2);
		}

		g.setColor(buttonColor);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.drawString("Start", 170, 380);

	}

	public boolean contains(int x, int y) {
		if ((this.x < x) && (x < this.x + width) && (this.y < y) && (y < this.y + height))
			return true;

		return false;
	}

	public void state(int stateValue) {
		this.stateValue = stateValue;
	}

}
