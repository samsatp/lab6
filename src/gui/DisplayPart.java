package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class DisplayPart extends Label{

	public DisplayPart() {

		super();
		setPadding(new Insets(10));
		setFont(Font.font(18));

	}

	public void update(String text) {

		setText(text);

	}
}
