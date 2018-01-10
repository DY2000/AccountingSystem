package simonsays;

public class MoveDevin implements MoveInterfaceDevin {
	
	private ButtonInterfaceDevin a;
	
	public MoveDevin(ButtonInterfaceDevin a) {
		this.a = a;
	}
	
	public ButtonInterfaceDevin getButton() {
		return a;
	}
}
