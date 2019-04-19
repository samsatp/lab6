package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TimerGUI extends VBox{

	private Label nameLabel;
	private DisplayPart displayPart;
	private ControlPart controlPart;
	

	public TimerGUI(String name) {
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setPadding(new Insets(10));
		nameLabel = new Label();
		nameLabel.setText(name);
		nameLabel.setFont(new Font(22));
		displayPart = new DisplayPart();
		controlPart = new ControlPart();
		getChildren().addAll(nameLabel, displayPart, controlPart);
	}
	
	public String getName() {
		return nameLabel.getText().trim();	
	}

	public DisplayPart getDisplayPart() {
		return displayPart;
	}

	public ControlPart getControlPart() {
		return controlPart;
	}

}
