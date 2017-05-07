package com.thom.jam.instrument;

import javax.swing.JComponent;

import com.thom.gameengine.soundsystem.SoundHandler;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 05-05-2017
 */
public abstract class Instrument 
{
	private String instrumentName;
	
	public Instrument(String name) 
	{
		this.instrumentName = name;
	}
	
	public abstract void initializeKeyBinds(JComponent jComponent);
	
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