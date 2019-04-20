package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TimerGUI extends VBox{

	Label nameLabel;
	DisplayPart displayPart;
	ControlPart controlPart;


	public TimerGUI(String name) {

		super();
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setPadding(new Insets(10));
		nameLabel = new Label(name);
		nameLabel.setFont(Font.font(22));

		displayPart = new DisplayPart();
		controlPart = new ControlPart();

		getChildren().addAll(nameLabel, displayPart, controlPart);

	}

	public String getName() {
		return this.nameLabel.toString().trim();
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}

	public DisplayPart getDisplayPart() {
		return displayPart;
	}

	public void setDisplayPart(DisplayPart displayPart) {
		this.displayPart = displayPart;
	}

	public ControlPart getControlPart() {
		return controlPart;
	}

	public void setControlPart(ControlPart controlPart) {
		this.controlPart = controlPart;
	}




}
