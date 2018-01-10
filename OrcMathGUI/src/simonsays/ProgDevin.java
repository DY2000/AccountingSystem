package simonsays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import guiTeacher.components.Component;
import guiTeacher.components.TextLabel;

public class ProgDevin extends Component implements ProgressInterfaceDevin {
	private TextLabel text;
	private int round;
	private int sequence;
	private boolean a;
	
	public ProgDevin(int x,int y, int w, int h) {
		super(x, y, w, h);
		a = false;
	}
	public void gameOver() {
		a = true;
		update();

	}	


	@Override
	public void setRound(int roundNumber) {
		this.round = roundNumber;
		update();

	}

	@Override
	public void setSequenceSize(int size) {
		this.sequence = size;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.getFontMetrics();	
		int fontSize = 15;
	   	g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		if(a) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Game Over!", 15, 50);
		}else {
			g.setColor(Color.green);
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Round: " + round , 10, 30);
			g.drawString("Sequence: " + sequence , 10, 50);
		}
	}
	@Override
	public void setText(String string) {
		text.setText("The Game Begins!");
		
		
	}
	

}
