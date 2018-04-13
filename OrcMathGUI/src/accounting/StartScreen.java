package accounting;

import guiTeacher.GUIApplication;

public class StartScreen extends GUIApplication {
	
	public static StartScreen a;
	public static MainScreen screen1;
	public static SubScreen screen2;
	
	
	public StartScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		 screen1 = new MainScreen(getWidth(),getHeight());
		 screen2 = new SubScreen(getWidth(),getHeight());
		setScreen(screen2);
		
	}
	public static void main(String[] args) {
		
		 a = new StartScreen(800,550);
		Thread b = new Thread(a);
		b.start();
		//
	}

}
