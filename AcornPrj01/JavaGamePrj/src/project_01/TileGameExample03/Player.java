package project_01.TileGameExample03;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Player {
  private final int radius = 10;
  private final int speed = 3;
  private int x = 0;
  private int y = 0;
  private static Image man;
 	static {
 		try {
 			man = ImageIO.read(new File("res/image/man.png")); // 동기형으로 불러옴
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 
  public Player(int tileX, int tileY) {
    this.x = tileX * Unit.tileSize + Unit.tileHalfSize;
    this.y = tileY * Unit.tileSize + Unit.tileHalfSize;
  }

  public int x() {
    return x;
  }

  public void x(int x) {
    this.x = x;
  }

  public int y() {
    return y;
  }

  public void y(int y) {
    this.y = y;
  }

  public int size() {
    return radius;
  }

  public int speed() {
    return speed;
  }

  public void move(int offsetX, int offsetY) {
    x += offsetX * speed;
    y += offsetY * speed;
    Map.isHit(this);
  }

  public void draw(Graphics g) {
    int drawX = x - radius;
    int drawY = y - radius;
    int drawSize = radius * 2;
    int intdexX =20;
    int intdexY =30;
    g.drawImage(man, drawX, drawY, drawX+drawSize, drawY+drawSize,
    		0, 0, 20, 30, null);
//    g.setColor(Color.green);
//    g.fillOval(drawX, drawY, drawSize, drawSize);
//    g.setColor(Color.black);
//    g.drawOval(drawX, drawY, drawSize, drawSize);
  }
}