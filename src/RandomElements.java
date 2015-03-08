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
	public List<String> listMonsters = new ArrayList<String>(); //List of monsters
	public List<String> listObjects = new ArrayList<String>(); //List of objects
	public String[] chapterSubjects = {"Assassination Mission", "Steal Item", "Defend Place",
			"Defend People", "Convince NPC", "Slay Monster",
			"Slay Monster (Boss)", "Slay Humans", "Escape",
			"Find an Item", "Explore a Place"};
		
	//Load the list elements for the selected list. 
	//Separate from FileHandling.readFile for extensibility.
	public void loadListElements(List<String> listElements, String fileName)
	{
		try
		{
			listElements.clear(); //Clear listElements' contents
			List<String> ls = FileHandling.readFile(fileName);
			listElements.addAll(ls); //Add the contents of the file
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
		int index = Main.randNum(0,(getList.size() - 1));
		return getList.get(index);
	}
	
	//Replace %(NAME) with a random string.
	//example:
	//Flavor.Add(Main.element.replaceWithRandom("That %RACE over there - isn't his poetry %ADJOBJECT?"))
	public String replaceWithRandom(String input)
	{
		String output = input;
		while (checkReplace(output) == true) //while there's a %macro present in the input string...  
		{
			output = output.replaceFirst("%ADJPERSON", getRandom(getListAdjectivesPerson()));
			output = output.replaceFirst("%ADJOBJECT", getRandom(getListAdjectivesObject()));
			output = output.replaceFirst("%RACE", getRandom(getListRaces()));
			output = output.replaceFirst("%CLASS", getRandom(getListClasses()));
			output = output.replaceFirst("%ENEMYCLASS", getRandom(getListEnemyClasses()));
			output = output.replaceFirst("%DEITY", getRandom(getListDeities()));
			output = output.replaceFirst("%GOAL", getRandom(getListGoals()));
			output = output.replaceFirst("%ENCHANTMENT", getRandom(getListEnchantments()));
			output = output.replaceFirst("%MONSTER", getRandom(getListMonsters()));
			output = output.replaceFirst("%OBJECT", getRandom(getListObjects()));
		}
		return output;
	}
	
	private boolean checkReplace (String input)
	{
		if(input.indexOf("%ADJPERSON") > -1
			|| input.indexOf("%ADJOBJECT") > -1
			|| input.indexOf("%RACE") > -1
			|| input.indexOf("%CLASS") > -1
			|| input.indexOf("%ENEMYCLASS") > -1
			|| input.indexOf("%DEITY") > -1
			|| input.indexOf("%GOAL") > -1
			|| input.indexOf("%ENCHANTMENT") > -1
			|| input.indexOf("%MONSTER") > -1)
		{
			return true; //If any of them are > -1, something needs to be replaced.
		}
		
		return false; //Does not need to have anything replaced
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
	
	public List<String> getListObjects()
	{
		return listObjects;
	}
	
	public List<String> getListMonsters()
	{
		return listMonsters;
	}
}
