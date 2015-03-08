
public class DnDMonster 
{
	private String monsterSpecies;
	private int monsterLevel;
	
	public DnDMonster(String monSpecies, int monLevel)
	{
		monsterSpecies = monSpecies;
		monsterLevel = monLevel;
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
