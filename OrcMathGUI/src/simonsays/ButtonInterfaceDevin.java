package simonsays;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceDevin extends Clickable {

	void highlight();

	void dim();

	void setColor(Color color);



}
