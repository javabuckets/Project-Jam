package com.thom.jam.instrument;

import javax.swing.JComponent;

import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.jam.JAM;
import com.thom.jam.action.PlayGuitarStringAction;

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
		KeyBinding.addKeyBind(jcomp, KeyBind.A, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "c", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.S, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "d", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.D, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "e", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.F, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "f", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.G, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "g", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.H, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "a", 4));
		KeyBinding.addKeyBind(jcomp, KeyBind.J, new PlayGuitarStringAction(this, jam.getAssetsPath() + "sounds\\", "b", 4));
	}
}