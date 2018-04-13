package accounting;

import java.util.List;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;


public class SubScreen extends FullFunctionScreen{
	
	private Button open;
	
	public SubScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		 open = new Button(20,265, 200, 30,"Open",new Action() {
			
			@Override
			public void act() {
				StartScreen.a.setScreen(StartScreen.screen1);
			}
			
		});
		viewObjects.add(open);
		Graphic on = new Graphic(20,300,"resources/menu.jpg");
		viewObjects.add(on);
		//d
	}
}
