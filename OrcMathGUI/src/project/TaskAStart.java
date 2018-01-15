package project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import guiPlayer.CustomPane;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TaskAStart extends FullFunctionScreen{
		private TextArea text;
		private Button win;
		private Button lose;
		private boolean a;
	
		public TaskAStart(int width, int height) {
			super(width,height);
		}
		public void initAllObjects(List<Visible> viewObjects) {
			text = new TextArea(40,40,200,30," Click on any of the buttons!");
			viewObjects.add(text);
			a = false;
			win = new Button(40,300,100,30,"win",new Action() {
				
				@Override
				public void act() {
					if(!a){
					text.setText("You Win!");
					a = true;
					}

				}
			});
			viewObjects.add(win);
			viewObjects.add(text);
			lose = new Button(40,300,100,100,"lose",new Action() {
				@Override
				public void act() {
					if(!a){
					text.setText("You Lose!");
					a = true;
				}
				}
				});
			viewObjects.add(lose);
			viewObjects.add(text);

		}
		/**
		* not needed
		**/
		public void addButton(Graphics2D g, boolean hover){
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.WHITE);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(Color.BLACK);
		}
}
