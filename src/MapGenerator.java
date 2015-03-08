import java.util.Random;

public class MapGenerator {
	int[][] map;
	int width;
	int height;

	public MapGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		map = new int[width][height];
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
					if (map[i][j] == 10)
						map[i][j] = 'a';
					if (map[i][j] >= 'a') {
						System.out.print((char) map[i][j] + " ");
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
			makeCircle(originX, originY, randNum(3, 10), 0.75);
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

}
