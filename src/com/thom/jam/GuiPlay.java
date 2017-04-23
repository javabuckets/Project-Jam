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
public class GuiPlay extends GuiScreen
{
	public GuiPlay() 
	{
		super("Jam - Play", new Dimension(1080, 720));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	Label background, sidePanel, logo, player1, player2, goBack;

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
		
		player1 = new Label();
		player1 = ComponentHandler.addScaledImageLabel(player1, new Point(95, 190), ImageHandler.getIcon(assetsPath + "1player.png"), 150, 75);
		panel.add(player1, 2, 0);
		
		player2 = new Label();
		player2 = ComponentHandler.addScaledImageLabel(player2, new Point(95, 235), ImageHandler.getIcon(assetsPath + "2player.png"), 150, 75);
		panel.add(player2, 2, 0);
		
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