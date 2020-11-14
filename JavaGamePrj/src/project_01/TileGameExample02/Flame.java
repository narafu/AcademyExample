package project_01.TileGameExample02;

import java.awt.Graphics;
import java.awt.Color;

public class Flame {
	private enum State {
		WAIT, FLAME, DONE,
	}

	private State state = State.WAIT;
	private final int tileX;
	private final int tileY;
	private int waitingTime;
	private double colorRate;

	public Flame(int tileX, int tileY, int waitingTime) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.waitingTime = waitingTime;
	}

	public boolean isDone() {
		return state == State.DONE;
	}

	public void draw(Graphics graphics) {
		switch (state) {
		case WAIT:
			if (waitingTime == 0)
				state = State.FLAME;
			waitingTime -= 1;
			break;
		case FLAME:
			drawFlame(graphics);
			break;
		case DONE:
			break;
		}
	}

	private void drawFlame(Graphics graphics) {
		int red = Math.max(0, (int) (Math.sin(colorRate) * 200));
		Color color = new Color(red, 0, 0);
		colorRate += 0.05;
		if (colorRate > Math.PI)
			state = State.DONE;
		int drawX = tileX * Unit.tileSize;
		int drawY = tileY * Unit.tileSize;
		graphics.setColor(color);
		graphics.fillRect(drawX, drawY, Unit.tileSize, Unit.tileSize);
		graphics.setColor(Color.orange.darker());
		graphics.drawRect(drawX, drawY, Unit.tileSize, Unit.tileSize);
	}
}