package review._0324.ex02;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

public class StartButton {

	public static final int STATE_ON = 0;
	public static final int STATE_OFF = 1;
	public static final int STATE_CLICK = 2;
	public static final Color COLOR_ON = new Color(200, 0, 0);
	public static final Color COLOR_OFF = new Color(0, 200, 0);
	private Cursor cursorOn = new Cursor(Cursor.HAND_CURSOR);
	private Cursor cursorOff = new Cursor(Cursor.DEFAULT_CURSOR);

	private int x, y, width, height, stateIndex;

	public StartButton() {

		x = 200;
		y = 400;
		width = 100;
		height = 50;
		stateIndex = STATE_OFF;

	}

	public boolean contains(int x, int y) {

		if ((this.x <= x && x <= this.x + width) && (this.y <= y && y <= this.y + height))
			return true;

		return false;
	}

	public void state(int stateIndex) {

		this.stateIndex = stateIndex;

	}

	public void dateUp() {

	}

	public void draw(Graphics g) {

		Color buttonColor;

		if (stateIndex == STATE_ON) {
			buttonColor = COLOR_ON;
			IntroCanvas.getInstance().setCursor(cursorOn);
		} else if (stateIndex == STATE_CLICK) {
			buttonColor = COLOR_ON;
		} else {
			buttonColor = COLOR_OFF;
			IntroCanvas.getInstance().setCursor(cursorOff);
		}
		g.setColor(buttonColor);
		g.drawRect(x, y, width, height);
		g.drawString("½ÃÀÛ", 235, 430);

	}
}
