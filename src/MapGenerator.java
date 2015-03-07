public class MapGenerator {
	int[][] map;
	int width;
	int height;

	public MapGenerator() {
		width = 20;
		height = 30;
	}
	
	public void makeCircle(int x, int y, int radius) {

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {

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
