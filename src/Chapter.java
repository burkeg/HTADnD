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
		chaptStoryID = randNum(0, 1); //a random decision of the story flavor text
		npcBosses = bosses;
		npcEnemies = enemies;
		
		
		switch (chaptAdvID)
		{
		case 0:  //This is the case for an ASSASSINATION Mission
				switch(chaptStoryID)
				{
					case 0: Flavor.add("You stole away inside, and found your assassination target waiting in slumber. your kill is"
						+ npcBosses.get(randNum(0, npcBosses.size())).getCName()
						+ " the %ADJPERSON. Tiredly they wait, snoring amid moonbeams that dance upon their face.");
					Flavor.add("Stab: you stab th");
						
					break;
					case 1: Flavor.add(Main.elements.replaceWithRandom("Surely you've heard of the mad assassin? Kept in the chambers of the castle? "
							+ "Set high above the kingdom, held aloft in the recesses of the mightiest towers, "
							+ "where the royalty uses them? They sate the assassin's needs, feed him, clothe him, and prepare him?"
							+ "+ Tonight, you have been ordered to kill the mad assassin. you wait in the shadows, keeping a watchful"
							+ " eye on the Assassin's tower walls. suddenly, the bricks split apart. out creeps a man in black, wearing a %ADJOBJECT"
							+ " horse mask. Decide what to do before he eludes you."));
					Flavor.add(Main.elements.replaceWithRandom("Charge: you swing your mighty weapons in fury as you charge the Mad assassin. However, he is quicker. "
							+ " You crash into the wall, finding a %ADJOBJECT, %ADJOBJECT dagger stuck into your upper arm."));
					Flavor.add(Main.elements.replaceWithRandom("Sneak: you sneak behind the mad assassin, and it appears he senses nothing."
							+ " Your blade is quick, digging into his back. suddenly, he disappears. his clothing falls to the ground. upon searching it,"
							+ " you find a hidden pocket, and in it rests a %ENCHANTMENT totem."));
					Flavor.add(Main.elements.replaceWithRandom("Follow: You follow the mad assassin through the alleys and the bazaar. he stops in an outhouse, "
							+ "and when he comes out, he is no longer wearing his uniform, and  you learn that the mad assassin is actually a she!! "
							+ "you follow her, where she returns home to her husband and"
<<<<<<< HEAD
							+ " children, and through the window, you watch them make love. why would you follow her? thats creepy stalker, bro."));
=======
							+ " children, and through the window, you watch them make love. all of them. why would you follow her? thats creepy stalker, bro."));
>>>>>>> origin/master

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

				}
				break;
		case 2: //This is the case for the DEFEND PLACE Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;

				}
				break;
		case 3: //This is the case for the DEFEND PEOPLE Mission
				switch(chaptStoryID)
				{
					case 0: Flavor.add(Main.elements.replaceWithRandom("An old man approaches you from the nearby encampment. he introduces himself as "
							+ NameGenerator.makeName()
							+ " and pleads with you, 'We've heard of you, your kind. We know what you're capable of. We need you. "
							+ "A ravenous army of "
							+ npcEnemies.get(1).getCClass()
							+ " are on their way. At the helm of the horde is a %OBJECT laced with "
							+ "%ENCHANTMENT-magic. If you save our village, protect us, then it's yours. "
							+ "We'll aid you as we can, but if you falter, come the end of the week, there will be nothing that remains."));
					
					Flavor.add(Main.elements.replaceWithRandom("Lead the Vanguard: You charge fearlessly into battle. you find yourselves in close combat with + "
							+ (playerCount +2) 
							+ " "
							+ npcEnemies.get(1).getCRace()
							+ " "
							+ npcEnemies.get(1).getCClass()
							+ "s. fight for your honor!"));
					Flavor.add(Main.elements.replaceWithRandom("Arm the encampment's defenses: relying more on a defensive approach, you unleash arrow after"
							+ " arrow on the invading "
							+ npcEnemies.get(1).getCRace()
							+ ", but the waves do not yield. the encampment is held, but most of the men, including "
							
					break;
					case 1:
					break;

				}
		case 4: //This is the case for the CONVINCE NPC Mission
				switch(chaptStoryID) 
				{
					case 0: 
					break;
					case 1:
					break;

				}
		case 5: //This is the case for the SLAY MONSTERS (MASSACRE) Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;

				}
		case 6: //This is the case for the SLAY MONSTERS (BOSS) Mission
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
				}
		case 7: //This is the case for the MASSACRE Mission
			Flavor.add("ADVENTURE: MASSACRE");
				switch(chaptStoryID)
				{
					case 0: 
					break;
					case 1:
					break;
				}
		case 8: // This is the case for the ESCAPE Mission 
			Flavor.add("ADVENTURE: EXCAPE!");
			switch(chaptStoryID)
				{
					case 0: 
						Flavor.add(Main.elements.replaceWithRandom("one of the adventurers stumble as their ankle entwines with a wire just a few inches off the floor. "
								+ "suddenly, the air is filled with a thick %ADJOBJECT smoke. You can't help but cough and your eyes burn uncontrollably. then, you hear a hiss. Arrows fly through"
								+ "the air around you. you have to get out of here!"));
						Flavor.add(Main.elements.replaceWithRandom("Fight: You jump out of the smoke and find yourselves surrounded by " + npcEnemies.size()
								+ " %ADJPERSON "
								+ npcEnemies.get(randNum(0, npcEnemies.size())).getCName()
								+ ", Lead by the %ADJPERSON Commander "
								+ npcBosses.get(randNum(0, npcBosses.size())).getCName()
								+ ". Prepare to fight!"
								));
						Flavor.add(Main.elements.replaceWithRandom("Flee: you attempt to run when one of your players takes an arrow to the knee."
								+ "S/He falls, shouting for help. a %ADJPERSON"
								+ npcEnemies.get(randNum(0, npcEnemies.size())).getCName()
								+ "storms in, flailing a %ADJOBJECT."
								+ " the gas continues to hurt your lungs and sear your eyes."));
						Flavor.add(Main.elements.replaceWithRandom("Duck and cover: you sheild yourselves from the arrows by diving onto the ground,"
								+ " and the gas wafts above you. Soon, the air clears and the arrows stop. you find yourself up against "
								+ (npcEnemies.size() / 2)
								+ " %RACE "
								+ npcEnemies.get(randNum(0, npcEnemies.size())).getCName()
								+ ", all of which are shamefully out of arrows. they begin to flee!"));
					break;
					case 1:
						/*
						 * 
						 */
					break;
				}
		case 9: //This is the case for the EXPLORE Mission
			Flavor.add("ADVENTURE: EXPLORE!");
				switch(chaptStoryID)
				{
					case 0: 
						
						Flavor.add( "you're strolling, taking your time, when the ground suddenly gives out below you. You've fallen to a subterranian wonderland."
							+ "the walls flash in the surfaces light, slightly damp and oddly beautiful. there are "
							+ "3 tunnels leading out of the room you are in.");
						Flavor.add( "Tunnel 1: you encounted a madman, dressed in the garb of a " 
							+ Main.elements.getRandom(Main.elements.getListAdjectivesPerson()) 
							+ " "
							+ npcEnemies.get(randNum(0, npcEnemies.size())).getCName()
							+ " from years past. he has clearly lost his mind, but not his weapon. he jumps in to attack!");
						Flavor.add( "Tunnel 2: the long and winding tunnel opens to a wide cavern, with an underground river flowing hard over your path."
							+ "You turn to see a group of cave-dwelling "
							+ npcEnemies.get(randNum(0, npcEnemies.size())).getCName()
							+ ", who have abandoned their wits long ago. they have not yet spotted you.");
						Flavor.add("Tunnel 3: The long tunnel is straight as an arrow, but it's ceiling dips and rises and you continue along. you soon find yourself"
								+ "crouching, then crawling, and then wriggling as you continue along. you see the light ahead, but you cannot go any further. "
								+ "You turn back, bruised from the hard ground and ceiling pressing against you.");
					break;
					case 1:
						
				}
		}
	}
	
	public List<String> getFlavor()
	{
		return Flavor;
	}
	
	public int randNum(int min, int max)
	{
		Random rand = new Random();
		int randomInt = rand.nextInt((max - min) +1) + min;
		return randomInt;
	}
	
}
