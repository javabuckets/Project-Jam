package com.thom.jam.action;

import java.awt.event.ActionEvent;

import com.thom.gameengine.action.GameAction;
import com.thom.jam.gui.InstrumentSelector;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 07-05-2017
 */
public class ChangeInstrumentAction extends GameAction 
{
	private String dir;
	private InstrumentSelector thisSelector, otherSelector;

	public ChangeInstrumentAction(InstrumentSelector thisSelector, InstrumentSelector otherSelector, String direction) 
	{
		this.thisSelector = thisSelector;
		this.otherSelector = otherSelector;
		this.dir = direction;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(thisSelector.getInstrumentSelected());
		System.out.println(otherSelector.getInstrumentSelected());
		
		if (thisSelector != null)
		{
			if (dir == "L")
			{
				// Jump 2 left
				if (thisSelector.getInstrumentSelected() > otherSelector.getInstrumentSelected() && otherSelector.getInstrumentSelected() == 1)
				{
					thisSelector.setLocation(thisSelector.getLocation().x - (314 * 2), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(0);
				}
				else if (thisSelector.getInstrumentSelected() == 2 && otherSelector.getInstrumentSelected() == 0)
				{
					thisSelector.setLocation(thisSelector.getLocation().x - (314 * 1), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(1);
				}
				else if (thisSelector.getInstrumentSelected() == 1 && otherSelector.getInstrumentSelected() == 2)
				{
					thisSelector.setLocation(thisSelector.getLocation().x - (314 * 1), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(0);
				}
			}
			else if (dir == "R")
			{
				// Jump 2 right
				if (thisSelector.getInstrumentSelected() < otherSelector.getInstrumentSelected() && otherSelector.getInstrumentSelected() == 1)
				{
					thisSelector.setLocation(thisSelector.getLocation().x + (314 * 2), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(2);
				}
				else if (thisSelector.getInstrumentSelected() == 0 && otherSelector.getInstrumentSelected() == 2)
				{
					thisSelector.setLocation(thisSelector.getLocation().x + (314 * 1), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(1);
				}
				else if (thisSelector.getInstrumentSelected() == 1 && otherSelector.getInstrumentSelected() == 0)
				{
					thisSelector.setLocation(thisSelector.getLocation().x + (314 * 1), thisSelector.getLocation().y);
					thisSelector.setInstrumentSelected(2);
				}
			}
		}
	}
}