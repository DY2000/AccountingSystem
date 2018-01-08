package simonsays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;


public class SimonScreenDevin extends ClickableScreen implements Runnable {

	public SimonScreenDevin(int width, int height) {
		super(width, height);
		Thread yes = new Thread(this);
		yes.start();
	}
	private TextLabel txt;
	private ButtonInterfaceDevin[] buttons;
	private ProgressInterfaceDevin prog;
	private ArrayList<MoveInterfaceDevin> direct;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceDevin b: buttons){ 
		    viewObjects.add(b); 
		}
		prog = getProgress();
		txt = new TextLabel(130,230,300,40,"Let's play Simon!");
		direct = new ArrayList<MoveInterfaceDevin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		direct.add(randomMove());
		direct.add(randomMove());
		roundNumber = 0;
		viewObjects.add(prog);
		viewObjects.add(txt);

	}

	private MoveInterfaceDevin randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}
	private MoveInterfaceDevin getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDevin getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceDevin[numberOfButtons];
		
		Color[] color = new Color[5];
		color[0] = Color.red;
		color[1] = Color.black;
		color[2] = Color.blue;
		color[3] = Color.green;
		color[4] = Color.lightGray;
		color[5] = Color.orange;
		
		for (int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceDevin b = getAButton();
			buttons[i] = b;
			
			b.setColor(color[i]);
			b.setX(i*50 + 100);
			b.setY(200);
			
			b.setAction(new Action() {
				
				public void act() {
					if (acceptingInput) {
						Thread blink = new Thread (new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
									b.dim();
							}
						});
						blink.start();
						
						if (b == direct.get(sequenceIndex).getButton()){
							sequenceIndex++;
						} else {
							prog.gameOver();
						}
						
						if(sequenceIndex == direct.size()){
							Thread nextRound = new Thread(SimonScreenDevin.this); 
							nextRound.start();
						}
					}
				}
			});
		}
	}

	private ButtonInterfaceDevin getAButton() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void run() {
		txt.setText("");
		nextRound();

	}

	private void nextRound() {
		// TODO Auto-generated method stub
		
	}

}
