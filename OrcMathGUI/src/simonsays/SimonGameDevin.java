package simonsays;

import guiTeacher.GUIApplication;

public class SimonGameDevin extends GUIApplication {

	public SimonGameDevin(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenDevin screen = new SimonScreenDevin(getWidth(), getHeight());
		setScreen(screen);

	}
	
	public static void main(String [] args) {
		SimonGameDevin dev = new SimonGameDevin(800, 550);
		Thread on = new Thread(dev);
		on.start();
	}

}
