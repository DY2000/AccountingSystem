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
		ButtonInterfaceDevin a = null;
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		a = buttons[bIndex];
	    lastSelectedButton = bIndex;
		return getMove(a);
	}
	private MoveInterfaceDevin getMove(ButtonInterfaceDevin a) {
		return new MoveDevin(a);
	}

	private ProgressInterfaceDevin getProgress() {
		return new ProgDevin(50, 350, 100, 100);
	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceDevin[numberOfButtons];
		Color[] color = {Color.orange, Color.magenta, Color.yellow, Color.green, Color.blue};
		for(int i = 0; i < numberOfButtons; i++) {
			buttons[i] = getAButton();
			buttons[i].setColor(color[i]);
			buttons[i].setX(250 + i *25 + i * 50);
			buttons[i].setY(100);
			final ButtonInterfaceDevin b = buttons[i];
			b.dim();
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread changeButton = new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try {
									Thread.sleep(400);
								}catch(InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}
						});
						changeButton.start();
						if(b == direct.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}else {
							prog.setText("Game Over");
						}
						if(sequenceIndex == direct.size()) {
							Thread nextRound = new Thread(SimonScreenDevin.this); 
						    try {
								Thread.sleep(1000); //pause so user move doesn't collide with generation of moves
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							nextRound.start();
						}
					}	
				}
			});
		}
		
	}
	private ButtonInterfaceDevin getAButton() {
		
		return new ButtonDevin(0, 0, 75, 75, "", null);
	}
	@Override
	public void run() {
		txt.setText("");
		nextRound();

	}
	private void changeText(String string) {
		Thread blink = new Thread(new Runnable() {
			
			@Override
			public void run() {
				txt.setText(string);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txt.setText("");
			}
		});
	}


	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		direct.add(randomMove());
		
		prog.setRound(roundNumber);
		prog.setSequenceSize(direct.size());
		
		
		changeText("Simon's turn");
		txt.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceDevin b = null;
		for(int i = 0; i < direct.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = direct.get(i).getButton();
			b.highlight();
			int sleepTime = (1000 - (1 + i * 10 ));
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
	}
	}




