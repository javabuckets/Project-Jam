package com.thom.jam.gui;

import java.awt.Point;

import javax.swing.ImageIcon;

import com.thom.gameengine.gui.Label;

public class InstrumentSelector extends Label
{
	public int instrumentSelected;
	
	public InstrumentSelector(Point position, ImageIcon image) 
	{
		super();
		setIcon(image);
		setBounds(position.x, position.y, image.getIconWidth(), image.getIconHeight());
		setVisible(true);
	}
	
	public void setInstrumentSelected(int instrumentSelected) {
		this.instrumentSelected = instrumentSelected;
	}
	
	public int getInstrumentSelected() {
		return instrumentSelected;
	}
}