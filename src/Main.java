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
		//map.generateLargeMap();
		map.generateMap();
		
}

	static int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		if(randomInt < 0) { randomInt = 0; } //Make sure we're not returning a negative integer (we use this for indices a lot)
		return randomInt;
	}
}
