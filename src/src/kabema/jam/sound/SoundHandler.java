package src.kabema.jam.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundHandler 
{
	public static AudioInputStream readSound(File file) throws IOException, UnsupportedAudioFileException
	{
		return AudioSystem.getAudioInputStream(file);
	}
}