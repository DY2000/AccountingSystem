package guiPlayer;

//import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
//import guiTeacher.components.Component;

public class Megaman extends AnimatedComponent {

	private String buster;
	private String name;
	private String type;

	public Megaman(String buster, String name, String type) {
		super(40, 40, 100, 100);
		//super.update();
		//super.addSequence("resources/megaman.png", 150, 0, 0, 34, 42, 0);
		this.buster = buster;
		this.name = name;
		this.type = type;
		//Thread animation = new Thread(this);
		//animation.start();
		update();
	}
	public String toString() {
		return buster + "," + name + "," + type;
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.green);
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		super.update(g);
		
		
		
	}
	/**
	 * M,Magnet Beam, Creation
	 * C, Rolling Cutter, Physical
	 * G, Super Arm, Physical
	 * I, Ice Slasher, Ice
	 * B, Hyper Bomb, Explosive
	 * F, Fire Storm, Fire
	 * E, Thunder Beam, Thunder
	 */
}