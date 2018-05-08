package accounting;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Checkbox;
import guiTeacher.components.FileOpenButton;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen implements FileRequester {

	private ArrayList<TextBox> boxes; //ap exam
	private int a = 1;
	private String name;
	private ArrayList<String> textboxinfo;

	
	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		boxes = new ArrayList<TextBox>(); 
		textboxinfo = new ArrayList<String>();
		Button check = new Button(250, 95, 200, 100, "Open", new Action() {
			
			//boolean visible = true;
			
			
			public void act() {
				
					

						int i = a;
						a = i;
						TextBox box = new TextBox(200 * i, 160, 200, 100, "blank");
						addObject(box);
						boxes.add(box);
						a++;
						//name = box.getText();
						textboxinfo.add(box.getText()); 
						System.out.println(textboxinfo); 
						
					
				
			}
		}); 
		Button delete = new Button(450, 95, 200, 100, "delete", new Action() {
			

			public void act() {
				
				if(boxes.size() > 0) {
				TextBox lastBox = boxes.get(boxes.size()-1); // handles have to be lowercase
				remove(lastBox);//removes from screen
				boxes.remove(lastBox);//remove from reference
				textboxinfo.remove(lastBox.getText()); //remove string from arrayList<String>
				a--;
				System.out.println(textboxinfo);
				}
				else {
					
				}
					
				
			}
		}); 
		Button save = new Button(650,95,200,100, "save", new Action() {
			
			public void act() {
				try {
				FileWriter Filewriter = new FileWriter("hello.csv");
				for(int i = 0; i < boxes.size(); i++) {
					Filewriter.write(i+"/n");
					//Filewriter.write(textboxinfo.toString());//write a function where it returns the text from the text boxes depending on the box selected, so a handle is needed for my text. 
				}
				Filewriter.close();
				System.out.println("Success! File \"hello.csv\" saved!");
			}
			catch(IOException e)
			{
				System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
			}
		}
		});
		

		viewObjects.add(save);
		viewObjects.add(check);
		viewObjects.add(delete);
		FileOpenButton fileButton = new FileOpenButton(100, 70, 120, 30, null, MainScreen.this);
		viewObjects.add(fileButton);
		
		
		//TextBox box1 = new TextBox(20, 210, 200, 100, "wow");
		//viewObjects.add(box1);
	}

	@Override
	public void setFile(File f) {
		BufferedReader br;
		String everything = "";
		try {
			br = new BufferedReader(new FileReader(f));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		    br.close();
		}catch(IOException e) {
		}
			System.out.println(everything);
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return StartScreen.a;
	}
	// SAVE FILE INTO A CSV FILE, THAT IS LATER CONVERTED INTO THE JAVA PROGRAM: BOOK CATALOG TAKES INFO FROM FILE AND CALLS A METHOD TO RECREATE IT.
	// USE REFERENCE FROM CATALOG MAKER, MAKE ADDITION FOR THE NUMBERS	
	//HANDLES ARE NEEDED? JAVAFX.
	public void act() {
		 //onload = function () {
		      // var e = document.getElementById('myInput');
		       //e.oninput = myHandler;
		       //e.onpropertychange = e.oninput; // for IE8
		       // e.onchange = e.oninput; // FF needs this in <select><option>...
		       // other things for onload().
		 //   };
	}
}
