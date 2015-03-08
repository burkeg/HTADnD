
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
		monsterSpecies = "Monster";
		monsterLevel = 1;
	}
	

	public void RandomizeMonster()
	{
		if(monsterSpecies.length() <= 0)
		{
			monsterSpecies = Main.elements.getRandom(Main.elements.getListMonsters()); 
		}
		
		if(monsterLevel <= 0)
		{
			monsterLevel = Main.randNum(1, 30);
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
