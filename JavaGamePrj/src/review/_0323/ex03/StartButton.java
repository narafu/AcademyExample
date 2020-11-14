package review._0323.ex03;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

public class StartButton {

	public static final Color COLOR_ON = new Color(255, 0, 0);
	public static final Color COLOR_OFF = new Color(0, 0, 255);
	public static final Color COLOR_CLICK = new Color(0, 255, 0);;
	public static final int STATE_ON = 0;
	public static final int STATE_OFF = 1;
	public static final int STATE_CLICK = 2;
	private double x, y;
	private int width, height, stateIndex;

	public StartButton() {

		x = 200;
		y = 200;
		width = 50;
		height = 50;
		stateIndex = STATE_OFF;

	}

	public void draw(Graphics g) {
		int x = (int) this.x;
		int y = (int) this.y;
		Color buttonColor;
		Cursor cursorHand = new Cursor(Cursor.HAND_CURSOR);
		Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);

		if (stateIndex == STATE_ON) {
			buttonColor = COLOR_ON;
			IntroCanvas.getInstance().setCursor(cursorHand);
		} else if (stateIndex == STATE_CLICK)
			buttonColor = COLOR_CLICK;
		else {
			buttonColor = COLOR_OFF;
			IntroCanvas.getInstance().setCursor(cursorDefault);
		}

		g.setColor(buttonColor);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawString("[START]", x, y);

	}

	public void dateUp() {

	}

	public boolean contains(int x, int y) {

		if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height))
			return true;

		return false;
	}

	public void state(int stateIndex) {
		this.stateIndex = stateIndex;
	}

}
