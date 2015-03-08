import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static RandomElements elements = new RandomElements(); 
	// Global variable holding the Random Elements

	public static void main(String[] args) {

		elements.loadListElements(elements.getListClasses(), "src/resource/classes.txt");
		elements.loadListElements(elements.getListDeities(), "src/resource/deities.txt");
		elements.loadListElements(elements.getListRaces(), "src/resource/races.txt");
		elements.loadListElements(elements.getListGoals(), "src/resource/goals.txt");
		elements.loadListElements(elements.getListEnchantments(), "src/resource/enchantments.txt");
		elements.loadListElements(elements.getListAdjectivesPerson(), "src/resource/adjectives-people.txt");
		elements.loadListElements(elements.getListAdjectivesObject(), "src/resource/adjectives-objects.txt");
		elements.loadListElements(elements.getListEnemyClasses(), "src/resource/enemyclasses.txt");
		
		MapGenerator map = new MapGenerator(300, 400);
		map.makeBiome(0, 0, 300, 400, 400); //x, y, boxWidth, boxHeight
		map.printMap();
		
		MapDraw drawnMap = new MapDraw(300, 400, map);
		drawnMap.setMap(map.getMap());
}

	static int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
}
