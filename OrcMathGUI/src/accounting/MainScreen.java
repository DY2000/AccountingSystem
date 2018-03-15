package accounting;

import java.awt.Color;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Checkbox;
import guiTeacher.components.FileOpenButton;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen implements FileRequester {

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
				
				
				//if(visible) {
						int i = a;
						a = i;
						TextBox box = new TextBox(20 + 100 * i, 160, 200, 100, "why u no work.");
						
						//box.setVisible(visible);
						viewObjects.add(box);
						
						//visible = false;
						a++;
						
					
				//}
				//if(!visible) {
				//	a++;
				//	visible = true;
					
				//}
				
				
			}
		}); 
		viewObjects.add(check);
		FileOpenButton fileButton = new FileOpenButton(100, 70, 120, 30, null, MainScreen.this);
		viewObjects.add(fileButton);
		TextBox box1 = new TextBox(20, 210, 200, 100, "wow");
		viewObjects.add(box1);
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
