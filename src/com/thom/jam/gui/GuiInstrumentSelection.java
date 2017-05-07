package com.thom.jam.gui;

import java.awt.Dimension;
import java.awt.Point;

import com.thom.gameengine.action.OpenGuiAction;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.jam.action.ChangeInstrumentAction;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 07-05-2017
 */
public class GuiInstrumentSelection extends GuiScreen
{
	private int playerCount;
	
	public GuiInstrumentSelection(int players) 
	{
		super("Jam - Instrument Selection", new Dimension(1080, 720));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.playerCount = players;
	}
	
	Label background;
	InstrumentSelector p1Choice, p2Choice;
	
	@Override
	public void drawScreen(int width, int height) 
	{
		setAssetsPath(GuiMainMenu.resFolder);
		
		background = new Label();
		background = ComponentHandler.addImageLabel(background, new Point(0, 0), ImageHandler.getIcon(assetsPath + "gui\\" + "gui_instrument_selection.png"));
		panel.add(background, 0, 0);
		
		p1Choice = new InstrumentSelector(new Point(99, 74), ImageHandler.getIcon(assetsPath + "instrument_selection_p1.png"));
		p1Choice.setInstrumentSelected(0);
		panel.add(p1Choice, 1, 0);
		
		p2Choice = null;
		
		// Test
		playerCount = 2;
		
		if (playerCount == 2)
		{
			p2Choice = new InstrumentSelector(new Point(728, 74), ImageHandler.getIcon(assetsPath + "instrument_selection_p2.png"));
			p2Choice.setInstrumentSelected(2);
			panel.add(p2Choice, 1, 0);
		}
	}
	
	@Override
	public void initialize() 
	{
		
	}
	
	@Override
	public void handleKeyBinds() 
	{
		// Changing Instruments
		//	Player 1
		KeyBinding.addKeyBind(p1Choice, KeyBind.A, new ChangeInstrumentAction(p1Choice, p2Choice, "L"));
		KeyBinding.addKeyBind(p1Choice, KeyBind.D, new ChangeInstrumentAction(p1Choice, p2Choice, "R"));
		//	Player 2
		KeyBinding.addKeyBind(p1Choice, KeyBind.J, new ChangeInstrumentAction(p2Choice, p1Choice, "L"));
		KeyBinding.addKeyBind(p1Choice, KeyBind.L, new ChangeInstrumentAction(p2Choice, p1Choice, "R"));
		
		KeyBinding.addKeyBind(background, KeyBind.B, new OpenGuiAction(GuiPlay.class, this));
		KeyBinding.addKeyBind(background, KeyBind.C, new OpenGuiAction(GuiSceneSelection.class, this));
	}
}