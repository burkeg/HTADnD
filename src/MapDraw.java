import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapDraw {
	int width;
	int height;
	BufferedImage bi;
	MapGenerator genMap;
	
	public BufferedImage getImage() {
		return bi;
	}
	
	public void saveImage() {
		try {
		    File outputfile = new File("saved.png");
		    ImageIO.write(cropImage(bi), "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MapDraw(int width, int height, MapGenerator map) {
		this.width = width;
		this.height = height;
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		genMap = map;
	}
	
	public BufferedImage cropImage(BufferedImage src) {
	      BufferedImage dest = src.getSubimage(60, 60, width - 60, height - 60);
	      return dest; 
	   }

	public void setMap(int[][] mapValue) {
		mapValue = genMap.getMap();
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				setTheRGB(i, j, mapValue[i][j]);
			}
		}
	}

	public void setTheRGB(int x, int y, int mapNum) {
		int r = (int) (((double) mapNum / 35.0) * 255); // red component 0...255
		if (r == 122)
			r = 123;
		
		int g = r;// green component 0...255
		int b = r;// blue component 0...255
		int col = (r << 16) | (g << 8) | b;
		bi.setRGB(x, y, col);

	}
}