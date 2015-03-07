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
			listElements = FileHandling.readFile(fileName);
		}
		
		catch (IOException ex)
		{
			
		}
	}
	
	//Select a random element from the list specified when called
	public String getRandom(List<String> getList)
	{
		String output = "";
		
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
	
}
