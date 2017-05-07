package com.thom.jam.instrument;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.jam.JAM;
import com.thom.jam.action.PlayPianoKeyAction;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 05-05-2017
 */
public class Piano extends Instrument
{
	private JAM jam;

	public Piano(JAM jam) 
	{
		super("Piano");
		this.jam = jam;
	}

	public void initializeKeyBinds(JComponent jcomp)
	{
		KeyBinding.addKeyBind(jcomp, KeyBind.A, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "c", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.S, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "d", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.D, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "e", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.F, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "f", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.G, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "g", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.H, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "a", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.J, new PlayPianoKeyAction(this, jam.getAssetsPath() + "sounds\\", "b", 4));
	}

	public void keyPressAnimation(String key)
	{
		Point pos = new Point();
		ImageIcon texture = null;
		
		switch (key) 
		{
		case "c":
			pos.setLocation(50 + 5, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_1.png");
			break;
		case "d":
			pos.setLocation(50 + 46, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_2.png");
			break;
		case "e":
			pos.setLocation(50 + 87, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_3.png");
			break;
		case "f":
			pos.setLocation(50 + 128, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_1.png");
			break;
		case "g":
			pos.setLocation(50 + 169, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_2.png");
			break;
		case "a":
			pos.setLocation(50 + 210, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_2.png");
			break;
		case "b":
			pos.setLocation(50 + 251, 355);
			texture = ImageHandler.getIcon(jam.getAssetsPath() + "piano_press_3.png");
			break;
		}
		
		Label keyPress = new Label();
		ComponentHandler.addImageLabel(keyPress, pos, texture);
		jam.addComponent(keyPress, 4);
		jam.updateGUI();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() 
		{
			public void run() 
			{
				jam.removeComponent(keyPress);
				jam.updateGUI();
			}
		}, 150);
		
		// Tile Bar
		
		
	}
}