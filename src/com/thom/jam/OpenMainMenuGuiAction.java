package com.thom.jam;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.soundsystem.SoundHandler;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 23-04-2017
 */
public class OpenMainMenuGuiAction extends GameAction 
{
	private GuiScreen currentGui;
	
	public <T extends GuiScreen> OpenMainMenuGuiAction(GuiScreen currentGui) 
	{
		this.currentGui = currentGui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		GuiMainMenu menu = new GuiMainMenu("Jam - Main Menu", new Dimension(1080, 720));
		menu.setVisible(true);
		menu.setLocation(currentGui.getLocation().x, currentGui.getLocation().y);
		currentGui.dispose();
	}
}