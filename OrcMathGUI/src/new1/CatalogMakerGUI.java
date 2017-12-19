package new1;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		CatalogMakerGUI sample = new CatalogMakerGUI(800, 550);
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