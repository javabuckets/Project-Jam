package com.thom.jam;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import com.thom.gameengine.Game;
import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.gameengine.spritesystem.SpriteSheet;
import com.thom.jam.gui.GuiMainMenu;
import com.thom.jam.instrument.Guitar;
import com.thom.jam.instrument.Instrument;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 23-04-2017
 */
public class JAM extends Game
{
	public static final int WIDTH = 1080, HEIGHT = 720;
	public static int init = 0;
	
	public static final String resFolder = ".\\Resources\\";
	
	SpriteSheet ss = new SpriteSheet(ImageHandler.getImage(resFolder + "spritesheet.png"));
	SpriteSheet pss = new SpriteSheet(ImageHandler.getImage(resFolder + "player_spritesheet.png"), new Dimension(48, 48));
	SpriteSheet iss = new SpriteSheet(ImageHandler.getImage(resFolder + "icons_spritesheet.png"));
	
	AnimatedSprite playerSprite = new AnimatedSprite(pss, 1, 0);
	Player player = new Player(playerSprite);
	EntityCollider playerCollider = new EntityCollider(player, new Dimension(0, 0), new Point(0, 0));
	
	ArrayList<Instrument> instrumentsInPlay = new ArrayList<Instrument>();
	HashMap<Instrument, Label> instrumentMap = new HashMap<Instrument, Label>();
//	ArrayList<Label> instrumentsInPlayT = new ArrayList<Label>();
	
	ArrayList<Player> playersInPlay = new ArrayList<Player>();
	
	// GUI Components
	Label scene, tilebar, pianoTexture, guitarTexture;
	
	public JAM()
	{
		super(new Dimension(WIDTH, HEIGHT), true);
		setTitle("Jam");
		setAssetsPath(resFolder);
		
		// The Scene
		scene = new Label();
		ComponentHandler.addScaledImageLabel(scene, new Point(0, 0), ImageHandler.getIcon(assetsPath + "studio.png"), WIDTH - 16, HEIGHT - 39);
		addComponent(scene, 0);
		
		ComponentHandler.addPlayer(player, new Point(WIDTH / 2, HEIGHT / 2), playerCollider);
		addComponent(player, 2);
		
		tilebar = new Label();
		ComponentHandler.addImageLabel(tilebar, new Point(WIDTH / 2 - (299 / 2), 250), ImageHandler.getIcon(assetsPath + "tilebar.png"));
		addComponent(tilebar, 3);
		
		/*pianoTexture = new Label();
		ComponentHandler.addImageLabel(pianoTexture, new Point(50, 350), ImageHandler.getIcon(assetsPath + "piano.png"));
		addComponent(pianoTexture, 3);*/
		
		guitarTexture = new Label();
		ComponentHandler.addScaledImageLabel(guitarTexture, new Point(50, 350), ImageHandler.getIcon(assetsPath + "guitar.png"), 425, 319);
		addComponent(guitarTexture, 3);
		
		initialize();
	}
	
	@Override
	public void initialize() 
	{		
		/*Piano piano = new Piano(this);
		initializeInstrument(piano, pianoTexture);*/
		
		Guitar guitar = new Guitar(this);
		initializeInstrument(guitar, guitarTexture);
		
		super.initialize();
	}
	
	private void initializeInstrument(Instrument instrument, Label textureComponent)
	{
		instrumentsInPlay.add(instrument);
		instrumentMap.put(instrument, textureComponent);
		instrument.initializeKeyBinds(instrumentMap.get(instrument));
	}

	@Override
	public GameType getGameType() 
	{
		return GameType.SIDEVIEW;
	}

	@Override
	public void handleKeyBinds() 
	{
//		KeyBinding.addKeyBind(player, KeyBind.P, new PlaySoundAction(assetsPath + "sounds\\", "btn_click.wav"));
	}
	
	public static void main(String[] args) 
	{
		GuiMainMenu jam = new GuiMainMenu("Jam - Main Menu", new Dimension(WIDTH, HEIGHT));
		jam.setVisible(true);
	}
}