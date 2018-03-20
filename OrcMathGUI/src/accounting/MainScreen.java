package accounting;

import java.awt.Color;

import java.io.File;
import java.util.ArrayList;
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

	private ArrayList<TextBox> boxes; //ap exam
	private int a = 1;

	
	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		boxes = new ArrayList<TextBox>(); 
		Button check = new Button(250, 95, 200, 100, "Open", new Action() {
			
			boolean visible = true;
			
			
			public void act() {
				
					

						int i = a;
						a = i;
						TextBox box = new TextBox(20 + 100 * i, 160, 200, 100, "blank.");
						addObject(box);
						boxes.add(box);
						a++;
						
					
					
				
			}
		}); 
		Button delete = new Button(450, 95, 200, 100, "delete", new Action() {
			

			public void act() {
				
				if(boxes.size() > 0) {
				TextBox lastBox = boxes.get(boxes.size()-1); // handles have to be lowercase
				remove(lastBox);//removes from screen
				boxes.remove(lastBox);//remove from reference
				a--;
				}
				else {
					
				}
					
				
			}
		}); 
		Button save = new Button(500,95,200,100, "save", new Action() {
			
			public void act() {
				
			}
			
		});
		viewObjects.add(check);
		viewObjects.add(delete);
		FileOpenButton fileButton = new FileOpenButton(100, 70, 120, 30, null, MainScreen.this);
		viewObjects.add(fileButton);
		

		//TextBox box1 = new TextBox(20, 210, 200, 100, "wow");
		//viewObjects.add(box1);
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
