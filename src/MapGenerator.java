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

	public void printMap() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (map[i][j] != 0) {
					System.out.print((char) ('a' + map[i][j] - 1) + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public void boxRandom(int x, int y, int width, int height) {
		int count = randNum(0, 10);
		while (count > 0) {
			for (int j = y; j < y + height - 1 && j >= 0 && j < height; j++) {
				for (int i = x; i < x + width - 1 && i >= 0 && i < width; i++) {
					makeCircle(i, j, randNum(3, 15));
				}
			}
			count--;
		}

	}

	int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
}
