package com.thom.jam;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.gui.GuiScreen;
import com.thom.gameengine.gui.Label;
import com.thom.gameengine.soundsystem.SoundHandler;
import com.thom.gameengine.spritesystem.ImageHandler;

/**
 * @author Thomas Boel Micheelsen & Ben Amram
 * @since 23-04-2017
 */
public class GuiMainMenu extends GuiScreen
{
	public static final String resFolder = "C:\\Users\\Thomas\\Desktop\\Projects\\Jam\\Resources\\";
	
	public GuiMainMenu(String title, Dimension size) 
	{
		super(title, size);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	Label background, sidePanel, logo, play, settings, exit;
	
	@Override
	public void drawScreen(int width, int height) 
	{
		setAssetsPath(resFolder);
		
		background = new Label();
		background = ComponentHandler.addImageLabel(background, new Point(0, 0), ImageHandler.getIcon(assetsPath + "jazzclub.png"));
		panel.add(background, 0, 0);
		
		sidePanel = new Label();
		sidePanel = ComponentHandler.addImageLabel(sidePanel, new Point(0, 0), ImageHandler.getIcon(assetsPath + "sidePanel.png"));
		panel.add(sidePanel, 1, 0);
		
		logo = new Label();
		logo = ComponentHandler.addScaledImageLabel(logo, new Point(70, 50), ImageHandler.getIcon(assetsPath + "jam.png"), 200, 100);
		panel.add(logo, 2, 0);
		
		play = new Label();
		play = ComponentHandler.addScaledImageLabel(play, new Point(95, 190), ImageHandler.getIcon(assetsPath + "play.png"), 150, 75);
		panel.add(play, 2, 0);
		
		settings = new Label();
		settings = ComponentHandler.addScaledImageLabel(settings, new Point(95, 235), ImageHandler.getIcon(assetsPath + "settings.png"), 150, 75);
		panel.add(settings, 2, 0);
		
		exit = new Label();
		exit = ComponentHandler.addScaledImageLabel(exit, new Point(90, 320), ImageHandler.getIcon(assetsPath + "exit.png"), 150, 75);
		panel.add(exit, 2, 0);
		
		sidePanel.addMouseListener(new MouseListener() 
		{	
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) 
			{
				if (sidePanel.getLocation().x < 0)
				{
					sidePanel.setLocation(0, sidePanel.getLocation().y);
					logo.setLocation(70, logo.getLocation().y);
					play.setLocation(95, play.getLocation().y);
					settings.setLocation(95, settings.getLocation().y);
					exit.setLocation(90, exit.getLocation().y);
				}
			}
			
			public void mouseExited(MouseEvent e) 
			{	
				while(sidePanel.getLocation().x > -275)
				{
					sidePanel.setLocation(sidePanel.getLocation().x - 1, sidePanel.getLocation().y);
					logo.setLocation(logo.getLocation().x - 1, logo.getLocation().y);
					play.setLocation(play.getLocation().x - 1, play.getLocation().y);
					settings.setLocation(settings.getLocation().x - 1, settings.getLocation().y);
					exit.setLocation(exit.getLocation().x - 1, exit.getLocation().y);
				}
			}
		});
		
		SoundHandler.playSound(assetsPath + "sounds\\music\\" + "Stal.wav");
	}
}