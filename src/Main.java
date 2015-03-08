import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static RandomElements elements = new RandomElements(); 
	// Global variable holding the Random Elements

	public static void main(String[] args) {
		int playerCount = 0; // this is the count of players
		int enemyCount = 0; // this is the count of enemies that should be made
							// for the adventure. these are guards and other
							// nameless characters.
		int bossCount = 0; // this is the count of enemies that are actually
							// named. the count of these are NOT considered in
							// the enemycount.
		int chapterCount = 1; //this is the count of chapters that is desired from the generator.

		elements.loadListElements(elements.getListClasses(), "src/resource/classes.txt");
		elements.loadListElements(elements.getListDeities(), "src/resource/deities.txt");
		elements.loadListElements(elements.getListRaces(), "src/resource/races.txt");
		elements.loadListElements(elements.getListGoals(), "src/resource/goals.txt");
		elements.loadListElements(elements.getListEnchantments(), "src/resource/enchantments.txt");
		elements.loadListElements(elements.getListAdjectivesPerson(), "src/resource/adjectives.txt");
		elements.loadListElements(elements.getListAdjectivesObject(), "src/resource/adjectives.txt");
		elements.loadListElements(elements.getListEnemyClasses(), "src/resource/enemyclasses.txt");
		
		enemyCount = playerCount + 1 + (randNum(((playerCount / 2) * -1), (playerCount / 2))); 
		// determines the amount of enemies for each encounter.
		// these are "guards" and other name-less
		bossCount = playerCount / 2 + (randNum(((playerCount / 3) * -1), (playerCount / 3))); 
		// determines the amount of boss enemies for each encounter
	    RandomElements elements = new RandomElements();

	    List<DnDCharacter> mEnemies = new ArrayList<DnDCharacter>();
		List<DnDCharacter> mBosses = new ArrayList<DnDCharacter>();
		List<Chapter> mChapters = new ArrayList<Chapter>();
		
		for(int i = 0; i < bossCount; i++)
		{
			DnDCharacter temp = new DnDCharacter(NameGenerator.makeName());
			temp.randomizeCharacter();
			mBosses.add(temp);
		}
		
		for(int i = 0; i < enemyCount; i++)
		{
			DnDCharacter temp = new DnDCharacter();
			mEnemies.add(temp);
		}
		
		for(int i = 0; i < chapterCount; i++)
		{
			Chapter temp = new Chapter(playerCount, mEnemies, mBosses);
			mChapters.add(temp);
		}
		
		
		MapGenerator map = new MapGenerator(20, 15);
		map.printMap();
		map.makeCircle(10, 6, 5);
		System.out.printf("\n\n\n");
		map.printMap();
}

	static int randNum(int min, int max) {
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
}
