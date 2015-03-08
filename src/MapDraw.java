import java.awt.image.BufferedImage;

public class MapDraw {
	int width;
	int height;
	BufferedImage bi;
	
	public MapDraw(int width, int height) {
		this.width = width;
		this.height = height;
		bi =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	
}