package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPart extends HBox{
	public static final String START_STOP_BUTTON_STRING = "Start/Stop";
	public static final String RESET_BUTTON_STRING = "Reset";
	private Button startStopButton;
	private Button resetButton;

	public ControlPart() {

		super();
		setPadding(new Insets(10));
		setSpacing(10);
		createStartStopButton();
		createResetButton();
		getChildren().addAll(startStopButton,resetButton);

	}

	private void createResetButton() {
		resetButton = new Button(this.RESET_BUTTON_STRING);
	}

	private void createStartStopButton() {
		startStopButton = new Button(this.START_STOP_BUTTON_STRING);
	}



	public Button getStartStopButton() {
		return startStopButton;
	}

	public void setStartStopButton(Button startStopButton) {
		this.startStopButton = startStopButton;
	}

	public Button getResetButton() {
		return resetButton;
	}

	public void setResetButton(Button resetButton) {
		this.resetButton = resetButton;
	}

	public static String getStartStopButtonString() {
		return START_STOP_BUTTON_STRING;
	}

	public static String getResetButtonString() {
		return RESET_BUTTON_STRING;
	}





}
