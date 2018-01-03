package simonsays;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;


public class SimonScreenDevin extends ClickableScreen implements Runnable {

	public SimonScreenDevin(int width, int height) {
		super(width, height);
		Thread yes = new Thread(this);
		yes.start();
	}
	private TextLabel txt;
	private ButtonInterfaceDevin[] dav;
	private ProgressInterfaceDevin prog;
	private ArrayList<MoveInterfaceDevin> direct;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceDevin b: dav){ 
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

	}
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceDevin getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
	}

}
