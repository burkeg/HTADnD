import java.util.Random;

public class MapArrayGenerator {
	int[][] map;
	int width;
	int height;

	public MapArrayGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		map = new int[width][height];
	}
	
	public int[][] getMap() {
		return map;
	}

	public void makeCircle(int x, int y, int radius) {

		for (int j = y - radius; j < y + radius && j >= 0 && j < height; j++) {
			for (int i = x - radius; i < x + radius && i >= 0 && i < width; i++) {
				if (Math.abs(j - y) * Math.abs(j - y) + Math.abs(i - x)
						* Math.abs(i - x) < radius * radius) {
					map[i][j]++;

				}
			}
		}
	}
	
	public void generateMap() {
		makeBiome(0, 0, width, height, 4200); //x, y, boxWidth, boxHeight, blotches
		printMap();
		MapDraw drawnMap = new MapDraw(width, height, this);
		drawnMap.setColorMap(this.getMap());
		drawnMap.saveImage();
	}
	
	public void generateLargeMap() {
		makeBiome(0, 0, width, height, 4200); //x, y, boxWidth, boxHeight, blotches
		printMap();
		MapDraw drawnMap = new MapDraw(width, height, this);
		drawnMap.setColorMap(scaleUp(this.getMap()));
		drawnMap.saveImage();
	}
	public void makeCircle(int x, int y, int radius, double noise) {

		for (int j = y - radius; j < y + radius && j >= 0 && j < height; j++) {
			for (int i = x - radius; i < x + radius && i >= 0 && i < width; i++) {
				if (Math.abs(j - y) * Math.abs(j - y) + Math.abs(i - x)
						* Math.abs(i - x) < radius * radius) {
					if (Math.random() < noise)
						map[i][j]++;

				}
			}
		}
	}

	public void printMap() {
		makeCircle(0, 0, 5);
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (map[i][j] != 0) {
					if (map[i][j] >= 10)
						map[i][j] += 87;
					if (map[i][j] >= 'a') {
						System.out.print((char) map[i][j] + " ");
						map[i][j] -= 87;
						continue;
					}
					System.out.print(map[i][j] + " ");
				} else {
					System.out.print("  ");
				}

			}
			System.out.println();
		}
	}

	public void boxRandom(int x, int y, int boxWidth, int boxHeight) {
		int count = 9;
		while (count > 0) {
			int originX = randNum(x, x + boxWidth);
			int originY = randNum(y, y + boxHeight);
			makeCircle(originX, originY, randNum(3, 10), 0.80);
			count--;
		}

	}

	public void makeBiome(int x, int y, int boxWidth, int boxHeight, int blobs) {
		while (blobs > 0) {
			int originX = randNum(x, x + width);
			int originY = randNum(y, y + boxHeight);
			boxRandom(originX, originY, (int) (boxWidth / 6.0),
					(int) (boxHeight / 6.0));
			blobs--;
		}
	}

	int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
	
	public int[][] scaleUp(int[][] aray)
	{
		int[][] bray = new int[(aray.length*3)][aray[0].length*3];
		for (int j = 0; j < aray[0].length; j++)
		{
			for(int i = 0; i < aray.length; i++)
			{
				setPix(i, j, aray[i][j], bray);
			}
		}
		return bray;
	}
	
	public void setPix(int i, int j, int pix, int[][] bray)
	{
		int l = i * 3;
		int k = j * 3;
		int[] row = {pix, pix, pix};
		System.arraycopy(row, 0, bray[k], l, 3);
		System.arraycopy(row, 0, bray[k+1], l, 3);
		System.arraycopy(row, 0, bray[k+2], l, 3);
	}
}
