package project;

import guiTeacher.GUIApplication;


public class Taskstart extends GUIApplication {

	public Taskstart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		TaskAStart screen = new TaskAStart(getWidth(), getHeight());
		setScreen(screen);

	}
	
	public static void main(String [] args) {
		Taskstart a = new Taskstart(800, 550);
		Thread b = new Thread(a);
		b.start();
	}
 

}
