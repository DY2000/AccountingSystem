package accounting;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Checkbox;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen {

	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		Checkbox check = new Checkbox("Open",250, 95, 200, false, new Action() {
			
			boolean visible = false;
			
			
			public void act() {

				if(!visible) {
				TextBox box = new TextBox(20, 160, 200, 100, "Try typing here.");
				viewObjects.add(box);
					visible = true;
				}
				
				
			}
		}); 
		viewObjects.add(check);
		
	}
	
}
