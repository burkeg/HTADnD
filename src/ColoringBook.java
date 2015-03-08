import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColoringBook 
{
	public int horiz;
	public int vert;
	BufferedImage im;
	MapArrayGenerator genColorMap;
	public ColoringBook(int width, int height, MapArrayGenerator map)
	{
		horiz=width;
		vert=height;
		im = new BufferedImage(horiz, vert, BufferedImage.TYPE_INT_RGB);
		genColorMap = map;
	}
	
	public void colorIt(int x, int y, int mapNum) {
		int modifier = (int) (((double) mapNum / 30.0) * 255); // red component 0...255
		int g = modifier;// green component 0...255
		int b = (modifier-130);// blue component 0...255
		int r = (modifier-170);
		int col = (r << 16) | (g << 8) | b;
		im.setRGB(x, y, col);

	}
	
	public MapArrayGenerator getColorIm()
	{
		return genColorMap;
	}
}
