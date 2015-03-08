import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;

public class DnDCharacter {
	private String chaName = new String();
	private String chaRace = new String();
	private String chaClass = new String();
	private String chaDeity = new String();
	private String chaAlignment = new String();
	private int chaLevel = 0;
		
	public DnDCharacter()
	{
		randomizeCharacter();
	}
	
	public DnDCharacter(String cName)
	{
		chaName = cName;
	}
	
	public DnDCharacter(String cName, int clevel)
	{
		chaName = cName;
		chaLevel = clevel;
	}
	
	public DnDCharacter(String cName, String cRace, String cClass, int clevel)
	{
		chaName = cName;
		chaRace = cRace;
		chaClass = cClass;
		chaLevel = clevel;
	}
	
	public DnDCharacter(String cName, String cRace, String cClass, String cDeity,
			String cAlign, int cLevel)
	{
		chaName = cName;
		chaRace = cRace;
		chaClass = cClass;
		chaDeity = cDeity;
		chaAlignment = cAlign;
		chaLevel = cLevel;
	}
	
	//Randomize character
	public void randomizeCharacter()
	{
		//Randomize all of the character's elements that haven't been set yet.
		if(chaName.length() <= 0)
		{
			NameGenerator gen = new NameGenerator();
			chaName = gen.makeName();
			chaName = chaName.substring(0,1).toUpperCase() + chaName.substring(1); //Capitalize the first letter of the name
		}
		
		if(chaRace.length() <= 0)
		{
			chaRace = Main.elements.getRandom(Main.elements.getListRaces()); 
		}
		
		if(chaClass.length() <= 0)
		{
			chaClass = Main.elements.getRandom(Main.elements.getListClasses());
		}
		
		if(chaDeity.length() <= 0)
		{
			chaDeity = Main.elements.getRandom(Main.elements.getListDeities());
		}
		
		if(chaAlignment.length() <= 0)
		{
			randomizeAlignment();
		}
	}
	
	public void randomizeAlignment()
	{
		int ethic = Main.randNum(0,2);
		int moral = Main.randNum(0,2);
		String tempAlign;
		
		if(ethic == 0) {tempAlign = "Chaotic";}
		else if(ethic == 1) {tempAlign = "Lawful";}
		else {tempAlign = "Neutral";}
		
		tempAlign += "/";
		
		if(moral == 0) {tempAlign += "Evil";}
		else if(moral == 1) {tempAlign += "Good";}
		else {tempAlign += "Neutral";}
		
		chaAlignment = tempAlign;
	}
	public void randomizeEnemyClass()
	{
		chaClass = Main.elements.getRandom(Main.elements.getListEnemyClasses());
	}
	
	// the get and set for Character NAME
	public String getCName()
	{
		return chaName;
	}
	
	public void setCName(String cName)
	{
		chaName = cName;
	}

	// the get and set for Character RACE
	public String getCRace()
	{
		return chaRace;
	}
	public void setCRace(String cRace)
	{
		chaName = cRace; 
	}
	
	// the get and set for Character CLASS
	public String getCClass()
	{
		return chaClass;
	}
	public void setCClass(String cClass)
	{
		chaClass = cClass; 
	}
	
	// the get and set for character DEITY
	public String getCDeity()
	{
		return chaDeity;
	}
	public void setCDiety(String cDeity)
	{
		chaDeity = cDeity; 
	}
	
	// the get and set for character ALIGNMENT
	public String getCAlignment()
	{
		return chaAlignment;
	}
	public void setCAlignment(String cAlign)
	{
		chaAlignment = cAlign;
	}
	
	// the get and set for character LEVEL
	public int getCLevel()
	{
		return chaLevel;
	}
	public void setCLevel(int cLevel)
	{
		chaLevel = cLevel;
	}
	
	//the levelup methods. if no input is supplied, it is assumed you level up by one level.
	public void levelUp()
	{
		chaLevel++;
	}
	public void levelUp(int addlevel)
	{
		chaLevel += addlevel;
	}
	
	public String serialize()
	{
		String output = new String();;
		
		return output;
	}
}
