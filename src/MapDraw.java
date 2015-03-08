import java.awt.image.BufferedImage;

public class MapDraw {
	int width;
	int height;
	BufferedImage bi;
	MapGenerator genMap;
	
	public MapDraw(int width, int height, MapGenerator map) {
		this.width = width;
		this.height = height;
		bi =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		genMap = new MapGenerator(width, height);
	}
	
	public void setMap(int[][] map) {
		map = genMap.getMap();
	}
	
	
}