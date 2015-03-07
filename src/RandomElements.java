import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

//Class holding the list of elements used in randomization
public class RandomElements {
	public List<String> listRaces = new ArrayList<String>();
	public List<String> listClasses = new ArrayList<String>();
	public List<String> listDeities = new ArrayList<String>();
	
	public void loadListRaces(String fileName)
	{
		FileHandling handler = new FileHandling();
		try
		{
			listRaces = handler.readFile(fileName);
		}
		
		catch (IOException ex)
		{
			
		}
	}
	
	public void loadListClasses(String fileName)
	{
		FileHandling handler = new FileHandling();
		try
		{
			listClasses = handler.readFile(fileName);
		}
		
		catch (IOException ex)
		{
			
		}
	}
	
	public void loadListDeities(String fileName)
	{
		FileHandling handler = new FileHandling();
		try
		{
			listDeities = handler.readFile(fileName);
		}
		
		catch (IOException ex)
		{
			
		}
	}
}
