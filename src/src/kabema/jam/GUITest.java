package src.kabema.jam;

import javax.swing.JFrame;
import javax.swing.JLabel;

import src.kabema.jam.graphic.ImageHandler;

public class GUITest extends JFrame
{
	public GUITest() 
	{
		super();
		setSize(800, 600);
		setTitle("Jam GUI Test");
		setVisible(true);
		
		drawScreen();
	}
	
	public void drawScreen()
	{
		JLabel img = new JLabel(ImageHandler.getIcon("C:\\Users\\DonDon\\Pictures\\art.png"));
		img.setBounds(0, 0, 800, 600);
		img.setVisible(true);
	}
}