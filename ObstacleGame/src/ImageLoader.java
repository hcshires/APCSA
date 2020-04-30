import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;
import java.util.*;

public class ImageLoader {

    private static TreeMap<String, BufferedImage> cache = new TreeMap<String, BufferedImage>();

	//loads an image that is ready for rendering
	public static BufferedImage loadCompatibleImage(String path) 
	{
		return getCompatibleImage(loadImage(path));
	} 
	
	//loads raw image data for manipulation before rendering
	public static BufferedImage loadImage(String path) 
	{
        if(cache.containsKey(path))
            return cache.get(path);
    
		try { 
			java.io.InputStream stream = ImageLoader.class.getResourceAsStream(path);
			BufferedImage img = javax.imageio.ImageIO.read(stream);
            cache.put(path, img);
			return img;
		} 	
		catch(Exception e) { 
			e.printStackTrace(); 
		} 
	 
		return null; 
	} 
	
	//creates a version of the image that is ready for rendering
	private static BufferedImage getCompatibleImage(Image img)
	{
		BufferedImage buff = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(img.getWidth(null), img.getHeight(null), Transparency.BITMASK);
		Graphics g = buff.getGraphics();
		
		g.drawImage(img, 0, 0, null);
		g.dispose();
        
		return buff;
	}
}
