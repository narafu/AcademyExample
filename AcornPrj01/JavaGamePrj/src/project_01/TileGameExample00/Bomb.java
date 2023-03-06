package project_01.TileGameExample00;

import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Color;

public class Bomb {
  private enum State {
    WAIT, BOMB, DONE,
  }
  State state = State.WAIT;
  private LinkedList<Flame> flames = new LinkedList<>();
  private int tileX;
  private int tileY;
  private int flameSize;
  private double sizeRate;
  private int waitingTime = 180;

  public Bomb(int tileX, int tileY, int flameSize) {
    this.tileX = tileX;
    this.tileY = tileY;
    this.flameSize = flameSize;
  }

  public boolean isXY(int tileX, int tileY) {
    return this.tileX == tileX && this.tileY == tileY;
  }

  public boolean isDone() {
    return state == State.DONE;
  }

  public void draw(Graphics graphics) {
    switch (state) {
    case WAIT: drawBomb(graphics); break;
    case BOMB: drawBlame(graphics); break;
    case DONE: break;
    }
  }

  private void drawBomb(Graphics graphics) {
    graphics.setColor(Color.orange);
    int size = (int)(Math.sin(sizeRate) * Unit.tileSize/2) + Unit.tileSize/2;
    int drawX = tileX * Unit.tileSize - size/2 + Unit.tileSize/2;
    int drawY = tileY * Unit.tileSize - size/2 + Unit.tileSize/2;
    graphics.fillOval(drawX, drawY, size, size);
    graphics.setColor(Color.red);
    graphics.drawOval(drawX, drawY, size, size);
    sizeRate += 0.1;
    sizeRate %= Math.PI;
    waitingTime -= 1;
    if (waitingTime > 0)
      return;
    flames.add(new Flame(tileX, tileY, 0));
    makeLinearFlame(flameSize, tileX, tileY, 1, 0);
    makeLinearFlame(flameSize, tileX, tileY, 0, 1);
    makeLinearFlame(flameSize, tileX, tileY, -1, 0);
    makeLinearFlame(flameSize, tileX, tileY, 0, -1);
    state = State.BOMB;
  }

  private void makeLinearFlame(int length, int tileX, int tileY, int directionX, int directionY) {
    for (int i = 0; i < length; i++) {
      tileX += directionX;
      tileY += directionY;
      if (Map.isWalkable(tileX, tileY) == false)
        break;
      flames.add(new Flame(tileX, tileY, i*2));
    }
  }

  private void drawBlame(Graphics graphics) {
    boolean isDone = true;
    for (Flame flame: flames) {
      flame.draw(graphics);
      isDone = isDone && flame.isDone();
    }
    if (isDone)
      state = State.DONE;
  }
}