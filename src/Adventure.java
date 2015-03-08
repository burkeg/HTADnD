import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Adventure {
	//TODO: Add MapGenerator holder
	int playerCount; // this is the count of players
	int enemyCount; // this is the count of enemies that should be made
						// for the adventure. these are guards and other
						// nameless characters.
	int bossCount; // this is the count of enemies that are actually
						// named. the count of these are NOT considered in
						// the enemy count.
	int avgLevel;
	int chapterCount; //this is the count of chapters that is desired from the generator.
    List<DnDCharacter> enemies = new ArrayList<DnDCharacter>();
	List<DnDCharacter> bosses = new ArrayList<DnDCharacter>();
	List<Chapter> chapters = new ArrayList<Chapter>();
	
	public void Adventure()
	{
		playerCount = 2;
		avgLevel = 1;
		chapterCount = 1;
		initializeEnemies();
	}
	
	public void Adventure (int players, int level, int chapters)
	{
		playerCount = players;
		avgLevel = level;
		chapterCount = chapters;
		initializeEnemies();
	}
	
	private void initializeEnemies()
	{
		enemyCount = playerCount + 1 + (Main.randNum(((playerCount / 2) * -1), (playerCount / 2))); 
		// determines the amount of enemies for each encounter.
		// these are "guards" and other name-less
		bossCount = playerCount / 2 + (Main.randNum(((playerCount / 3) * -1), (playerCount / 3))); 
		// determines the amount of boss enemies for each encounter
		
		for(int i = 0; i < bossCount; i++)
		{
			DnDCharacter temp = new DnDCharacter(NameGenerator.makeName());
			temp.randomizeCharacter();
			bosses.add(temp);
		}
		
		for(int i = 0; i < enemyCount; i++)
		{
			DnDCharacter temp = new DnDCharacter();
			temp.randomizeEnemyClass();
			enemies.add(temp);
		}
	}
	
	public String AdventureInfo()
	{
		String output = "Players: " + playerCount + " | " + 
			"Average Level: " + avgLevel + " | " +
			"Chapters: " + chapters;
		return output;
	}
}
