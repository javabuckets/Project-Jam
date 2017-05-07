package com.thom.jam.gui;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.action.OpenGameAction;
import com.thom.gameengine.action.OpenGuiAction;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.jam.JAM;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 07-05-2017
 */
public class GuiSceneSelection extends GuiScreen
{
	public GuiSceneSelection() 
	{
		super("Jam - Scene Selection", new Dimension(1080, 720));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	Label background;
	
	@Override
	public void drawScreen(int width, int height) 
	{
		setAssetsPath(GuiMainMenu.resFolder);
		
		background = new Label();
		background = ComponentHandler.addImageLabel(background, new Point(0,0), ImageHandler.getIcon(assetsPath + "jazzclub.png"));
		panel.add(background, 0, 0);
		
		Label temp = new Label();
		temp = ComponentHandler.addScaledImageLabel(temp, new Point(20, 20), ImageHandler.getIcon(assetsPath + "play.png"), 1080, 720);
		panel.add(temp, 1, 0);
	}

	@Override
	public void handleKeyBinds() 
	{
		KeyBinding.addKeyBind(background, KeyBind.P, new OpenGameAction(JAM.class, this));
		KeyBinding.addKeyBind(background, KeyBind.B, new OpenGuiAction(GuiPlay.class, this));
	}
}