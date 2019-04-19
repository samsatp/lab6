package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPart extends HBox {
	public static final String START_STOP_BUTTON_STRING = "Start/Stop";
	public static final String RESET_BUTTON_STRING = "Reset";

	private Button startStopButton;
	private Button resetButton;

	public ControlPart() {
		setPadding(new Insets(10));
		setSpacing(10);
		startStopButton = new Button(START_STOP_BUTTON_STRING);
		resetButton = new Button(RESET_BUTTON_STRING);
		getChildren().addAll(startStopButton, resetButton);

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

}
