package com.thom.jam;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import com.thom.gameengine.Game;
import com.thom.gameengine.action.PlaySoundAction;
import com.thom.gameengine.action.SpawnRandomParticleAction;
import com.thom.gameengine.entities.EntityCollider;
import com.thom.gameengine.gameobjects.Particle;
import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.keybinding.KeyBind;
import com.thom.gameengine.keybinding.KeyBinding;
import com.thom.gameengine.player.Player;
import com.thom.gameengine.spritesystem.AnimatedSprite;
import com.thom.gameengine.spritesystem.ImageHandler;
import com.thom.gameengine.spritesystem.SpriteSheet;

/**
 * @author Thomas Boel Micheelsen & Benjamin Amram
 * @since 23-04-2017
 */
public class JAM extends Game
{
	public static final int WIDTH = 1080, HEIGHT = 720;
	
	public static final String resFolder = "C:\\Users\\Thomas\\Desktop\\Projects\\Jam\\Resources\\";
	
	SpriteSheet ss = new SpriteSheet(ImageHandler.getImage(resFolder + "spritesheet.png"));
	SpriteSheet pss = new SpriteSheet(ImageHandler.getImage(resFolder + "player_spritesheet.png"), new Dimension(48, 48));
	SpriteSheet iss = new SpriteSheet(ImageHandler.getImage(resFolder + "icons_spritesheet.png"));
	
	AnimatedSprite playerSprite = new AnimatedSprite(pss, 1, 0);
	Player player = new Player(playerSprite);
	EntityCollider playerCollider = new EntityCollider(player, new Dimension(0, 0), new Point(0, 0));
	
	/**
	 * Icons
	 */
	AnimatedSprite note1Sprite = new AnimatedSprite(iss, 0, 0);
	Particle note1 = new Particle(note1Sprite);
	
	AnimatedSprite note2Sprite = new AnimatedSprite(iss, 1, 0);
	Particle note2 = new Particle(note2Sprite);
	
	AnimatedSprite note3Sprite = new AnimatedSprite(iss, 2, 0);
	Particle note3 = new Particle(note3Sprite);
	
	AnimatedSprite note4Sprite = new AnimatedSprite(iss, 0, 1);
	Particle note4 = new Particle(note4Sprite);
	
	AnimatedSprite note5Sprite = new AnimatedSprite(iss, 1, 1);
	Particle note5 = new Particle(note5Sprite);
	
	AnimatedSprite note6Sprite = new AnimatedSprite(iss, 2, 1);
	Particle note6 = new Particle(note6Sprite);
	
	ArrayList<Particle> noteParticles = new ArrayList<Particle>();
	
	public JAM() 
	{
		super(new Dimension(WIDTH, HEIGHT), true);
		setAssetsPath(resFolder);
		
		// The Scene
		Label scene = new Label();
		ComponentHandler.addScaledImageLabel(scene, new Point(0, 0), ImageHandler.getIcon(assetsPath + "SceneTest.png"), WIDTH - 16, HEIGHT - 39);
		addComponent(scene, 0);
		
		ComponentHandler.addPlayer(player, new Point(WIDTH / 2, HEIGHT / 2), playerCollider);
		addComponent(player, 2);
		
		initialize();
	}
	
	@Override
	public void initialize() 
	{	
		noteParticles.add(note1);
		noteParticles.add(note2);
		noteParticles.add(note3);
		noteParticles.add(note4);
		noteParticles.add(note5);
		noteParticles.add(note6);
		
		super.initialize();
	}

	@Override
	public GameType getGameType() 
	{
		return GameType.SIDEVIEW;
	}

	@Override
	public void handleKeyBinds() 
	{
		KeyBinding.addKeyBind(player, KeyBind.P, new PlaySoundAction(assetsPath + "sounds\\", "btn_click.wav"));
		KeyBinding.addKeyBind(player, KeyBind.O, new SpawnRandomParticleAction(this, noteParticles, new Point(WIDTH / 2 - 30, HEIGHT / 2 - 20)));
	}
	
	public static void main(String[] args) 
	{
//		JAM jam = new JAM();
		GuiMainMenu jam = new GuiMainMenu("Jam - Main Menu", new Dimension(WIDTH, HEIGHT));
		jam.setVisible(true);
	}
}