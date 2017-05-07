package com.thom.jam.instrument;

import javax.swing.JComponent;

import com.thom.jam.JAM;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 07-05-2017
 */
public class Saxophone extends Instrument
{
	private JAM jam;

	public Saxophone(JAM jam) 
	{
		super("Saxophone");
		this.jam = jam;
	}

	public void initializeKeyBinds(JComponent jcomp)
	{
		
	}
}