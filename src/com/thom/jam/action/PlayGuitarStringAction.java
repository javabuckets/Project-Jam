package com.thom.jam.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.soundsystem.SoundHandler;
import com.thom.jam.instrument.Guitar;
import com.thom.jam.instrument.Piano;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 05-05-2017
 */
public class PlayGuitarStringAction extends GameAction
{
	private Guitar guitar;
	private String note;
	private String soundPath;
	
	public PlayGuitarStringAction(Guitar guitar, String soundFolder, String note, int scala) 
	{
		this.guitar = guitar;
		this.note = note;
		this.soundPath = soundFolder + "guitar\\note_" + note + String.valueOf(scala) + ".wav";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//guitar.keyPressAnimation(note);
		SoundHandler.playSound(soundPath);
	}
}