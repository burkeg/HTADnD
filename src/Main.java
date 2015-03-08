import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static RandomElements elements = new RandomElements(); 
	// Global variable holding the Random Elements

	public static void main(String[] args) {


		
		int width = 459;
		int height = 475;
		
		MapArrayGenerator map = new MapArrayGenerator(width, height);
		map.makeBiome(0, 0, width, height, 4200); //x, y, boxWidth, boxHeight, blotches
		map.printMap();
				
		MapDraw drawnMap = new MapDraw(width, height, map);
		drawnMap.setColorMap(map.getMap());
		drawnMap.makeSquare(100, 100, 15);
		drawnMap.saveImage();
		
		int highest = 0;
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (map.getMap()[i][j] > highest)
					highest = map.getMap()[i][j];
			}
		}
		System.out.println("\n\n" + highest);
}

	static int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
}
