//Class for buildings

public class Building {
	//MEMBERS:
	//Name of building type
	private String buildingType;
	
	//Weight (likelihood of appearing)
	private int randomWeight;
	
	//Size (maybe not)
	
	//Minimum number of this building
	private int buildingMin;
	
	//Maximum number of this building
	private int buildingMax;
	
	void setBuildingType(String type)
	{
		buildingType = type;
	}
	
	String getBuildingType()
	{
		return buildingType;
	}

	void setRandomWeight(int weight)
	{
		if (weight >= 0)
		{
			randomWeight = weight;
		}
	}
	
	int getRandomWeight()
	{
		return randomWeight;
	}

	
	
	void setBuildingMin(int min)
	{
		if(min >= 0)
		{
			buildingMin = min;
		}
	}
	
	int getBuildingMin()
	{
		return buildingMin;
	}
	
	void setBuildingMax(int max)
	{
		if(max > buildingMin && max >= 0)
		{
			buildingMax = max;
		}
	}
	
	int getBuildingMax()
	{
		return buildingMax;
	}

	//METHODS:
	//Determine building type
}
