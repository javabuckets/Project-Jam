package src.kabema.jam.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageHandler 
{
	public static BufferedImage readImage(File file) throws IOException
	{
		return ImageIO.read(file);
	}
	
	public static ImageIcon getIcon(String localPath)
	{
		return new ImageIcon(localPath);
	}
}