import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileHandling {
	//Basic read file
	public List<String> readFile (String fileName) throws IOException
	{
		return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		
	}
	//Basic write file
	public void writeFile (List<String> lines, String fileName) throws IOException
	{
		Files.write(Paths.get(fileName), lines, StandardCharsets.UTF_8);
	}
}
