package com.thom.jam;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.action.OpenGuiAction;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.spritesystem.ImageHandler;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 23-04-2017
 */
public class GuiSettings extends GuiScreen
{
	public GuiSettings() 
	{
		super("Jam - Settings", new Dimension(1080, 720));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	Label background, sidePanel, logo, keybinds, audio, goBack;
	
	@Override
	public void drawScreen(int width, int height) 
	{
		setAssetsPath(GuiMainMenu.resFolder);
		
		background = new Label();
		background = ComponentHandler.addImageLabel(background, new Point(0, 0), ImageHandler.getIcon(assetsPath + "jazzclub.png"));
		panel.add(background, 0, 0);
		
		sidePanel = new Label();
		sidePanel = ComponentHandler.addImageLabel(sidePanel, new Point(0, 0), ImageHandler.getIcon(assetsPath + "sidePanel.png"));
		panel.add(sidePanel, 1, 0);
		
		logo = new Label();
		logo = ComponentHandler.addScaledImageLabel(logo, new Point(70, 50), ImageHandler.getIcon(assetsPath + "jam.png"), 200, 100);
		panel.add(logo, 2, 0);
		
		keybinds = new Label();
		keybinds = ComponentHandler.addScaledImageLabel(keybinds, new Point(95, 190), ImageHandler.getIcon(assetsPath + "keybinds.png"), 150, 75);
		panel.add(keybinds, 2, 0);
		
		audio = new Label();
		audio = ComponentHandler.addScaledImageLabel(audio, new Point(95, 235), ImageHandler.getIcon(assetsPath + "audio.png"), 150, 75);
		panel.add(audio, 2, 0);
		
		goBack = new Label();
		goBack = ComponentHandler.addScaledImageLabel(goBack, new Point(90, 320), ImageHandler.getIcon(assetsPath + "goBack.png"), 150, 75);
		panel.add(goBack, 2, 0);
	}

	@Override
	public void handleKeyBinds() 
	{
		
		KeyBinding.addKeyBind(sidePanel, KeyBind.B, new OpenMainMenuGuiAction(this));
	}
}