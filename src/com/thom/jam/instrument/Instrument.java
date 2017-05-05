package com.thom.jam.instrument;

import com.thom.gameengine.soundsystem.SoundHandler;

public abstract class Instrument 
{
	private String instrumentName;
	
	public Instrument(String name) 
	{
		this.instrumentName = name;
		//initializeKeyBinds();
	}
	
	//public abstract void initializeKeyBinds();
	
	public void playSound(String soundFolder, String sound)
	{
		SoundHandler.playSound(soundFolder + "\\" + sound);
	}

	public String getInstrumentName() 
	{
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) 
	{
		this.instrumentName = instrumentName;
	}
}