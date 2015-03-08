import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class Chapter
{
	private int chaptAdvID; //this is the Chapter Adventure ID. it is used to determine whether it is an assassination, monster battle, etc
	private int chaptStoryID; //this is the story ID. its used for generating flavor text around the adventureID

	private int playerCount; //this is the count of players
	private int enemyCount; // this is the count of enemies that should be made for the adventure. THEY ARE NOT MADE YET, must be made once the program compiles
	private int bossCount; // this is the count of boss enemies that should be made for the adventure. THEY ARE NOT MADE YET, must be made once compiled.
	
	private List<String> Flavor = new ArrayList();
	public List<DnDCharacter> npcBosses = new ArrayList();
	public List<DnDCharacter> npcEnemies = new ArrayList();

	public Chapter(int players, List<DnDCharacter> bosses, List<DnDCharacter> enemies)
	{
		chaptAdvID = randNum(0, 9); // a random decision of the adventure type
		chaptStoryID = randNum(0, 2); //a random decision of the story flavor text
		npcBosses = bosses;
		npcEnemies = enemies;
		
		
		switch (chaptAdvID)
		{
		case 0:  //This is the case for an ASSASSINATION Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
				break;
				
		case 1: //This is the case for a STEAL ITEM Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
				break;
		case 2: //This is the case for the DEFEND PLACE Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
				break;
		case 3: //This is the case for the DEFEND PEOPLE Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 4: //This is the case for the CONVINCE NPC Mission
				switch(chaptStoryID) 
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 5: //This is the case for the SLAY MONSTERS (MASSACRE) Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 6: //This is the case for the SLAY MONSTERS (BOSS) Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 7: //This is the case for the MASSACRE INNOCENTS Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 8: // This is the case for the ESCAPE Mission 
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
					case 2:
					break;
				}
		case 9: //This is the case for the EXPLORE Mission
				switch(chaptStoryID)
				{
					case 0: 
						Flavor.add( "you're strolling, taking your time, when the ground suddenly gives out below you. You've fallen to a subterranian wonderland."
							+ "the walls flash in the surfaces light, slightly damp and oddly beautiful. there are "
							+ playerCount + " tunnels leading out of the room you are in.");
						Flavor.add( "Tunnel 1: you encounted a madman, dressed in the garb of a " main.elements.)
					break;
					case 1:
					break;
					case 2:
					break;
				}
		}
	}
	
	
	public int randNum(int min, int max)
	{
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) +1) + min;
		return randomInt;
	}
	
}
