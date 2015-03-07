
public class DnDMonster 
{
	private String monsterName;
	private String monsterSpecies;
	private int monsterLevel;
	
	public DnDMonster(String monName, String monSpecies, int monLevel)
	{
		monsterName = monName;
		monsterSpecies = monSpecies;
		monsterLevel = monLevel;
	}
	
	public String getMonsterName()
	{
		return monsterName;
	}
	public void setMonsterName(String name)
	{
		monsterName = name;
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
