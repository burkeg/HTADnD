public class MapGenerator {
	int[][] map;
	int width;
	int height;

	public MapGenerator() {
		width = 20;
		height = 30;
	}

	public void makeCircle(int x, int y, int radius) {

		for (int j = y - radius; j < y + radius && j >= 0 && j < height; j++) {
			for (int i = x - radius; i < x + radius && i >= 0 && i < height; i++) {
				if (Math.abs(j - y) * Math.abs(j - y) + Math.abs(i - x)
						* Math.abs(i - x) <= radius) {
					map[i][j]++;

				}
			}
		}
	}

	public void printMap() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
