package com.thom.jam.instrument;

import javax.swing.JComponent;

import com.thom.jam.JAM;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 07-05-2017
 */
public class Guitar extends Instrument
{
	private JAM jam;

	public Guitar(JAM jam) 
	{
		super("Guitar");
		this.jam = jam;
	}

	public void initializeKeyBinds(JComponent jcomp)
	{
		
	}
}