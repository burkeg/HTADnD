import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static RandomElements elements = new RandomElements(); 
	// Global variable holding the Random Elements

	public static void main(String[] args) {

		int playerCount = 0; //this is the count of players
	    int enemyCount = 0; // this is the count of enemies that should be made for the adventure. these are guards and other nameless characters. 
	    int bossCount = 0; // this is the count of enemies that are actually named. the count of these are NOT considered in the enemycount.
	    RandomElements elements = new RandomElements();
		
		enemyCount = playerCount *3 + (randNum((playerCount*-1), playerCount)); //determines the amount of enemies for each encounter. 
		//these are "guards" and other name-less enemies
		bossCount = playerCount/2 + (randNum(((playerCount/3)*-1), (playerCount/3))); // determines the amount of boss enemies for each encounter
		
		List<DnDCharacter> enemies = new ArrayList<DnDCharacter>();
		List<DnDCharacter> bosses = new ArrayList<DnDCharacter>();
		
		for(int i = 0; i < bossCount; i++)
		{
			
			//bosses.add(NameGenerator.makeName());
		}
		
		for(int i = 0; i < enemyCount; i++)
		{
			
			//enemies.add(elements.listEnemyClasses.get(randNum(0, elements.listEnemyClasses.size())));
		}
		
		for(int )
		
	}

	static int randNum(int min, int max) 
	{
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) + 1) + min;
		return randomInt;
	}
}
