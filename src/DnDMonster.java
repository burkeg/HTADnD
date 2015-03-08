
public class DnDMonster 
{
	private String monsterSpecies;
	private int monsterLevel;
	
	public DnDMonster(String monSpecies, int monLevel)
	{
		monsterSpecies = monSpecies;
		monsterLevel = monLevel;
	}
	
	public DnDMonster()
	{
		monsterSpecies = monSpecies;
		monsterLevel = monLevel;
	}
	

	public void RandomizeMonster()
	{
		if(monsterSpecies.length() <= 0)
		{
			monsterSpecies = Main.elements.getRandom(Main.elements.getListMonster()); 
		}
		
		if(monsterLevel.length() <= 0)
		{
			monsterLevel = Main.elements.getRandom(Main.elements.getListClasses());
		}
	}
	
	public String getMonsterSpecies()
	{
		return monsterSpecies;
	}
	public void setMonsterSpecies(String species)
	{
		monsterSpecies = species;
	}
	
	public int getMonsterLevel()
	{
		return monsterLevel;
	}
	public void setMonsterLevel(int level)
	{
		monsterLevel = level;
	}
}
