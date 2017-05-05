package com.thom.jam.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.soundsystem.SoundHandler;
import com.thom.jam.instrument.Piano;

public class PlayPianoKeyAction extends GameAction
{
	private Piano piano;
	private String note;
	private String soundPath;
	
	public PlayPianoKeyAction(Piano piano, String soundFolder, String note, int scala) 
	{
		this.piano = piano;
		this.note = note;
		this.soundPath = soundFolder + "piano\\note_" + note + String.valueOf(scala) + ".wav";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		piano.keyPressAnimation(note);
		SoundHandler.playSound(soundPath);
	}
}