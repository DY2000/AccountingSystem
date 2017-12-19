package New;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class catalogScreen extends FullFunctionScreen {

	private TextField hi;
	
	public catalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		hi = new TextField(40,40,200,30,"txt goes here","description");
		viewObjects.add(hi);

	}

}
