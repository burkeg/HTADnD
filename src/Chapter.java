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
	public List<DnDMonster> npcMonsters = new ArrayList();

	public Chapter(int players, List<DnDCharacter> bosses, List<DnDCharacter> enemies, List<DnDMonster> monsters)
	{
		chaptAdvID = randNum(0, 9); // a random decision of the adventure type
		chaptStoryID = randNum(0, 1); //a random decision of the story flavor text
		npcBosses = bosses;
		npcEnemies = enemies;
		npcMonsters = monsters;
		int bossId = Main.randNum(0, (npcBosses.size() - 1));
		int enemyId = Main.randNum(0, (npcEnemies.size() -1));
		
		switch (chaptAdvID)
		{
		
		case 0:  //This is the case for an ASSASSINATION Mission
				switch(chaptStoryID)
				{
					case 0: Flavor.add("You stole away inside, and found your assassination target waiting in slumber. your kill is"
						+ npcBosses.get(bossId).getCName()
						+ " the %ADJPERSON. Tiredly they wait, snoring amid moonbeams that dance upon their face.");
					Flavor.add("Stab: you stab them, "
							+ "and they scream bloody murder. the wound is surely fatal, but you hear the rumble of footsteps, and "
							+ (playerCount*2)
							+ "are quickly on you!");
					Flavor.add(Main.elements.replaceWithRandom("Poison: you slip a couple of the %ADJOBJECT Poison Between their lips. The target does not wake, "
							+ "and you slip out just as you came in."));
						
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
							+ " children, and through the window, you watch them make love. why would you follow her? thats creepy stalker, bro."));

					break;
				}
				break;
				
		case 1: //This is the case for a STEAL ITEM Mission
				switch(chaptStoryID)
				{
					case 0: Flavor.add(Main.elements.replaceWithRandom("a large convoy marches along the street, and between the armored "
							+ npcEnemies.get(enemyId).getCName()
							+ " you see a large chariot being pulled by "
							+ npcEnemies.get(enemyId).getCRace()
							+ " servants. The woman inside the chariot waves to the masses dantily with one hand, and her %ADJOBJECT crown catches the sun's light,"
							+ " as well as your eye."));
					Flavor.add(Main.elements.replaceWithRandom("Steal the crown: You slip through the crowd and jump past the "
							+ npcEnemies.get(enemyId).getCName()
							+ "s and "
							+ npcEnemies.get(enemyId).getCRace()
							+ ", grabbing the crown and winking at the woman as you dart away."));
					Flavor.add(Main.elements.replaceWithRandom("steal the crown and fail: you jump through the crowd, but the "
							+ npcEnemies.get(enemyId).getCName()
							+ "catch you and encircle you. there are three of them but only one of you!"));
					break;
					case 1: 
					break;

				}
				break;
		case 2: //This is the case for the DEFEND PLACE Mission
				switch(chaptStoryID)
				{
					case 0: Flavor.add("You are informed by the Captain of the Guard that the city is in need of soldiers, and mercenaries will be well compensated.");
					Flavor.add("defend the city: You shoot down a horde of barbarians from the safety of the city walls, and are payed respectfully.");
					Flavor.add("get hurt: you were not skilled enough to be a mercenary, and you accidentally shoot an arrow into your foot. you hurt yourself"
							+ "and your dignity.");
						
					break;

				}
				break;
		case 3: //This is the case for the DEFEND PEOPLE Mission
				switch(chaptStoryID)
				{
					case 0:
						String oldManName = NameGenerator.makeName();
						Flavor.add(Main.elements.replaceWithRandom("An old man approaches you from the nearby encampment. he introduces himself as "
							+ oldManName
							+ " and pleads with you, 'We've heard of you, your kind. We know what you're capable of. We need you. "
							+ "A ravenous army of "
							+ npcEnemies.get(enemyId).getCClass()
							+ " are on their way. At the helm of the horde is a %OBJECT laced with "
							+ "%ENCHANTMENT-magic. If you save our village, protect us, then it's yours. "
							+ "We'll aid you as we can, but if you falter, come the end of the week, there will be nothing that remains."));
					
					Flavor.add(Main.elements.replaceWithRandom("Lead the Vanguard: You charge fearlessly into battle. you find yourselves in close combat with + "
							+ (playerCount +2) 
							+ " "
							+ npcEnemies.get(enemyId).getCRace()
							+ " "
							+ npcEnemies.get(enemyId).getCClass()
							+ "s. fight for your honor!"));
					Flavor.add(Main.elements.replaceWithRandom("Arm the encampment's defenses: relying more on a defensive approach, you unleash arrow after"
							+ " arrow on the invading "
							+ npcEnemies.get(enemyId).getCRace()
							+ ", but the waves do not yield. the encampment is held, but most of the men who stayed , including "
							+ oldManName
							+ ". you take the magic items and leave."));
							
					break;
					case 1:
					break;

				}
		case 4: //This is the case for the CONVINCE NPC Mission
				switch(chaptStoryID) 
				{
					case 0: Flavor.add(Main.elements.replaceWithRandom("You approach an old cobblestone church, and a %ADJPERSON priest meets you at the door."
							+ "He insists he wants no trouble and insists you go on your way."));
					Flavor.add(Main.elements.replaceWithRandom("Persuade for help: He takes pity on you, and offers you some %ADJOBJECT bread and %ADJOBJECT ale."));
					Flavor.add("Raid the Church: Before you can attempt to get in the door, the priest slams the door and barrs it.");
					break;
					case 1: Flavor.add("among the bazaar, you catch "
							+ NameGenerator.makeName()
							+ " "
							+ NameGenerator.makeName()
							+", a very wealthy merchant. you consult him, telling him of your goals, but he is not interested in beggers.");
					Flavor.add("Ask him for his blessing: he laughs, being a godless man, and gives you a few pieces of silver instead.");
					Flavor.add("ask him for his gold: the Merchant spits at your shoes and tells you to leave him alone.");
					Flavor.add("Threaten him: Suddenly, two "
							+ npcEnemies.get(enemyId).getCName()
							+ "are upon you. they take you to an alley and toss you in a dumpster as the Merchant walks away unharmed.");
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
					case 0: Flavor.add(Main.elements.replaceWithRandom("Stolen away beyond the spires of oblivion, at the edge of mercurial, worldly sanity, "
							+ "you find the forbidden grips of an undead tomb. Within them, kept by surly, cold airs, is the %MONSTER. "
							+ "His soul kept secure by %DEITY, he remains ever-%ADJPERSON, and continually "
							+ "%ADJPERSON. His dark, ominous staff is "
							+ "%ADJOBJECT, iconoclastic and illicit. When you hear his voice, you brace for the %ADJOBJECT happenings that follow its wake. you raise your sheilds against his %ADJOBJECT breath,"
							+ "and prepare for a fight."));
					break;
					case 1: 
					break;
				}
		case 7: //This is the case for the MASSACRE Mission
			Flavor.add("ADVENTURE: MASSACRE");
				switch(chaptStoryID)
				{
					case 0: Flavor.add("The small remote village of "
							+ NameGenerator.makeName()
							+" has denounced the old gods in exchange for the God of Light. the punishment is death. slay them all.");
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
								+ npcEnemies.get(randNum(0, (npcEnemies.size() -1))).getCName()
								+ ", Lead by the %ADJPERSON Commander "
								+ npcBosses.get(randNum(0, (npcBosses.size() - 1))).getCName()
								+ ". Prepare to fight!"
								));
						Flavor.add(Main.elements.replaceWithRandom("Flee: you attempt to run when one of your players takes an arrow to the knee."
								+ "They fall, shouting for help. A %ADJPERSON"
								+ npcEnemies.get(randNum(0, (npcEnemies.size() -1))).getCName()
								+ "storms in, flailing a %ADJOBJECT."
								+ " the gas continues to hurt your lungs and sear your eyes."));
						Flavor.add(Main.elements.replaceWithRandom("Duck and cover: you sheild yourselves from the arrows by diving onto the ground,"
								+ " and the gas wafts above you. Soon, the air clears and the arrows stop. you find yourself up against "
								+ (npcEnemies.size() / 2)
								+ " %RACE "
								+ npcEnemies.get(randNum(0, (npcEnemies.size() -1))).getCName()
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
							+ npcEnemies.get(randNum(0, (npcEnemies.size() -1))).getCName()
							+ " from years past. he has clearly lost his mind, but not his weapon. he jumps in to attack!");
						Flavor.add( "Tunnel 2: the long and winding tunnel opens to a wide cavern, with an underground river flowing hard over your path."
							+ "You turn to see a group of cave-dwelling "
							+ npcEnemies.get(randNum(0, (npcEnemies.size() -1))).getCName()
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
