package New;

import guiTeacher.GUIApplication;

public class catalogMakerGui extends GUIApplication {

	public catalogMakerGui(int width, int height) {
		super(width, height);
		setVisible(true);
		catalogMakerGui sample = new catalogMakerGui(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

	@Override
	public void initScreen() {
		catalogScreen s = new catalogScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
