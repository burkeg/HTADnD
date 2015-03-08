import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

//Class holding the list of elements used in randomization
public class RandomElements {
	public List<String> listRaces = new ArrayList<String>(); //List of races
	public List<String> listClasses = new ArrayList<String>(); //List of classes
	public List<String> listEnemyClasses = new ArrayList<String>(); //List of classes for enemies
	public List<String> listDeities = new ArrayList<String>(); //List of deities
	public List<String> listAdjectivesPerson = new ArrayList<String>(); //List of adjectives that describe a person
	public List<String> listAdjectivesObject = new ArrayList<String>(); //List of adjectives that describe a thing
	public List<String> listGoals = new ArrayList<String>(); //List of goals that a person might have.
	public List<String> listEnchantments = new ArrayList<String>(); //List of enchantments for weapons/armor/items
	public List<String> listObjects = new ArrayList<String>(); //List of objects
	public String[] chapterSubjects = {"Assassination Mission", "Steal Item", "Defend Place",
			"Defend People", "Convince NPC", "Slay Monsters (Massacre)",
			"Slay Monsters (Boss)", "Massacre Innocents", "Escape",
			"Find an Item", "Explore a Place"};
		
	//Load the list elements for the selected list. 
	//Separate from FileHandling.readFile for extensibility.
	public void loadListElements(List<String> listElements, String fileName)
	{
		try
		{
			listElements.clear(); //Clear listElements' contents
			listElements.addAll(FileHandling.readFile(fileName)); //Add the contents of the file
		}
		
		catch (IOException ex)
		{
			
		}
	}
	
	//Select a random element from the list specified when called
	//example:
	//String str = Main.element.getRandom(Main.element.getListRaces());
	public String getRandom(List<String> getList)
	{
		int index = Main.randNum(0,getList.size());
		return getList.get(index);
	}
	
	//Replace %(NAME) with a random string.
	//example:
	//Flavor.Add(Main.element.replaceWithRandom("That %RACE over there - isn't his poetry %ADJOBJECT?"))
	public String replaceWithRandom(String input)
	{
		String output = input;
		while (output.indexOf("%ADJPERSON") != -1
				&& output.indexOf("%ADJOBJECT") != -1
				&& output.indexOf("%RACE") != -1
				&& output.indexOf("%CLASS") != -1
				&& output.indexOf("%ENEMYCLASS") != -1
				&& output.indexOf("%DEITY") != -1
				&& output.indexOf("%GOAL") != -1
				&& output.indexOf("%ENCHANTMENT") != -1
				) //while there's a %macro present in the input string...  
		{
			output = output.replaceFirst("%ADJPERSON", getRandom(getListAdjectivesPerson()));
			output = output.replaceFirst("%ADJOBJECT", getRandom(getListAdjectivesObject()));
			output = output.replaceFirst("%RACE", getRandom(getListRaces()));
			output = output.replaceFirst("%CLASS", getRandom(getListClasses()));
			output = output.replaceFirst("%ENEMYCLASS", getRandom(getListEnemyClasses()));
			output = output.replaceFirst("%DEITY", getRandom(getListDeities()));
			output = output.replaceFirst("%GOAL", getRandom(getListGoals()));
			output = output.replaceFirst("%ENCHANTMENT", getRandom(getListEnchantments()));
		}
		return output;
	}
	
	public List<String> getListRaces()
	{
		return listRaces;
	}
	
	public List<String> getListClasses()
	{
		return listClasses;
	}
	
	public List<String> getListEnemyClasses()
	{
		return listEnemyClasses;
	}
	
	public List<String> getListDeities()
	{
		return listDeities;
	}
	
	public List<String> getListAdjectivesPerson()
	{
		return listAdjectivesPerson;
	}
	
	public List<String> getListAdjectivesObject()
	{
		return listAdjectivesObject;
	}
	
	public List<String> getListGoals()
	{
		return listGoals;
	}
	
	public List<String> getListEnchantments()
	{
		return listEnchantments;
	}
}
