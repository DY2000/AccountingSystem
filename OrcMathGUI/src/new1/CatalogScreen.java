package new1;

import java.awt.event.ActionEvent;
import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField hi;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea area;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		area = new TextArea(40,150,200,30,"This is a box of Text");
		hi = new TextField(40,40,200,30,"txt goes here","description");
		viewObjects.add(hi);
		addButton = new Button(40,120,80,30,"add",new Action() {
			
			public void act() {
				addButtonClicked();
				
			}

		});
		viewObjects.add(addButton);
		viewObjects.add(area);

		
	}

	public void addButtonClicked() {
		Book b = new Book(hi.getText(),area.getText(),1000);
		//hi.getText();
		String s = area.getText() + b +"\n";
		area.setText(s);
		catalog.addBook(b);
		area.setText("");
		hi.setText("");
				
		
	}
}
//uses all listeners in the function = full function screen