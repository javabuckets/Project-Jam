package src.kabema.jam.graphic;

import java.io.File;
import java.io.IOException;

public class FileHandler 
{
	public static File readFile(String path) throws IOException
	{
		File file = new File(path);
		
		if (file.exists())
			return file;
		else
			return null;
	}
}