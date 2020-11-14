package teamPrj.ex00;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import project_01.TileGameExample04.TeamCanvas;

public class Map implements Movable {

	private static final int GRASS = 1;
	public static final int STONE = 2;
	private static final int FOREST = 3;
	private static final int ITEM = 4;
	private static int widthGrass, widthStone, widthForest, widthItem;
	private static int heightGrass, heightStone, heightForest, heightItem;
	private static Image imgGrass, imgStone, imgForest, imgItem;
	public static int tileSize;
	private int tileNumX, tileNumY;
	private int[] stoneX, stoneY;
	private int[] forestX, forestY;
	private int[] itemX, itemY;
	public static int[][] map;

	static {
		try {
			imgGrass = ImageIO.read(new File("res/image/grass.png"));
			imgStone = ImageIO.read(new File("res/image/stone.png"));
			imgForest = ImageIO.read(new File("res/image/forest.png"));
			imgItem = ImageIO.read(new File("res/image/itembox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 잔디
		widthGrass = imgGrass.getWidth(TeamCanvas.getInstance());
		heightGrass = imgGrass.getHeight(TeamCanvas.getInstance());
		// 돌
		widthStone = imgStone.getWidth(TeamCanvas.getInstance());
		heightStone = imgStone.getHeight(TeamCanvas.getInstance());
		// 숲
		widthForest = imgForest.getWidth(TeamCanvas.getInstance());
		heightForest = imgForest.getHeight(TeamCanvas.getInstance());
		// 아이템
		widthItem = imgItem.getWidth(TeamCanvas.getInstance());
		heightItem = imgItem.getHeight(TeamCanvas.getInstance());
	}

	public Map() {
		tileNumX = 20;
		tileNumY = 15;
		tileSize = 60;
		stoneX = new int[tileNumX / 2];
		stoneY = new int[tileNumY / 3];
		forestX = itemX = new int[tileNumX / 2];
		forestY = itemY = new int[tileNumY / 3];
		map = new int[tileNumX * tileSize][tileNumY * tileSize];
		Random rand = new Random();

		// 돌 배치
		for (int x = 0; x < stoneX.length; x++) {
			for (int y = 0; y < stoneY.length; y++) {
				stoneX[x] = rand.nextInt(tileNumX);
				stoneY[y] = rand.nextInt(tileNumY);
				map[stoneX[x]][stoneY[y]] = STONE;
			}
		}

		// 숲 배치
		for (int x = 0; x < forestX.length; x++) {
			for (int y = 0; y < forestY.length; y++) {
				if (map[x][y] != GRASS) {
					forestX[x] = rand.nextInt(tileNumX);
					forestY[y] = rand.nextInt(tileNumY);
					map[forestX[x]][forestY[y]] = FOREST;
				}
			}
		}

		// 아이템 배치
		for (int x = 0; x < itemX.length; x++) {
			for (int y = 0; y < itemY.length; y++) {
				if (map[x][y] == 0) {
					itemX[x] = rand.nextInt(tileNumX);
					itemY[y] = rand.nextInt(tileNumY);
					map[itemX[x]][itemY[y]] = ITEM;
				}
			}
		}

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		for (int x = 0; x < tileNumX; x++) {
			for (int y = 0; y < tileNumY; y++) {
				g.drawImage(imgGrass, x * tileSize, y * tileSize, (x + 1) * tileSize, (y + 1) * tileSize, 0, 0,
						widthGrass, heightGrass, TeamCanvas.getInstance());
				switch (map[x][y]) {
				case STONE:
					g.drawImage(imgStone, x * tileSize, y * tileSize, (x + 1) * tileSize, (y + 1) * tileSize, 0, 0,
							widthStone, heightStone, TeamCanvas.getInstance());
					break;
				case FOREST:
					g.drawImage(imgForest, x * tileSize, y * tileSize, (x + 1) * tileSize, (y + 1) * tileSize, 0, 0,
							widthForest, heightForest, TeamCanvas.getInstance());
					break;
				case ITEM:
					g.drawImage(imgItem, x * tileSize, y * tileSize, (x + 1) * tileSize, (y + 1) * tileSize, 0, 0,
							widthItem, heightItem, TeamCanvas.getInstance());
					break;
				}

				// 시작위치
				if (x < 2 && y < 2)
					map[x][y] = GRASS;
				if (tileNumX - 2 <= x && tileNumY - 2 <= y)
					map[x][y] = GRASS;
			}
		}

		for (int x = 0; x < tileNumX; x++) {
			for (int y = 0; y < tileNumY; y++) {
				g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
			}
		}

	}

}
