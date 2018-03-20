package accounting;

import guiTeacher.GUIApplication;

public class StartScreen extends GUIApplication {
	
	public static StartScreen  a;
	public static MainScreen bc;
	
	
	public StartScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		MainScreen screen = new MainScreen(getWidth(),getHeight());
		SubScreen screen2 = new SubScreen(getWidth(),getHeight());
		setScreen(screen2);
		
	}
	public static void main(String[] args) {
		
		StartScreen a = new StartScreen(800,550);
		Thread b = new Thread(a);
		b.start();
		
	}

}
