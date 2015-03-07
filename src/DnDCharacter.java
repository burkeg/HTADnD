public class DnDCharacter {
	private String chaName = new String();
	private String chaRace = new String();
	private String chaClass = new String();
	private String chaDiety = new String();
	private String chaAlignment = new String();
	private int chaLevel = 0;
	
	// TODO Auto-generated method stub
	
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
	
	public DnDCharacter(String cName, String cRace, String cClass, String cDiety,
			String cAlign, int cLevel)
	{
		chaName = cName;
		chaRace = cRace;
		chaClass = cClass;
		chaDiety = cDiety;
		chaAlignment = cAlign;
		chaLevel = cLevel;
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
	public void setClass(String cClass)
	{
		chaClass = cClass; 
	}
	
	// the get and set for character DIETY
	public String getCDiety()
	{
		return chaDiety;
	}
	public void setCDiety(String cDiety)
	{
		chaDiety = cDiety; 
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
		chaLevel + addlevel;
	}
	
	
}
