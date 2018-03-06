package accounting;

import java.awt.Color;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Checkbox;
import guiTeacher.components.FileOpenButton;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen {

	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		Button check = new Button(250, 95, 200, 100, "Open", new Action() {
			
			boolean visible = true;
			int a = 1;
			
			public void act() {
				
				
				if(visible) {
						int i = a;
						a = i;
						TextBox box = new TextBox(20 + 50 * i, 160, 200, 100, "Try typing here.");
						box.setVisible(visible);
						viewObjects.add(box);
						visible = false;
				}
				if(!visible) {
					a++;
					visible = true;
				}
				
				
			}
		}); 
		viewObjects.add(check);
		FileOpenButton fileButton = new FileOpenButton(490, 70, 120, 30, null, MainScreen.this);
		viewObjects.add(fileButton);
	}
	
}
