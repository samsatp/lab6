package logic;

import gui.TimerGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;

public class Timer {

	public static final int SLEEP_TIME = 500;
	public static final int COUNT_UP = 1;
	public static final int COUNT_DOWN = -1;

	private TimerGUI timerGUI;
	private int hour;
	private int minute;
	private int second;
	private int countMode;
	private boolean isCounting;
	private Thread thread;

	private int totalSeconds;

	public Timer(String name, int countMode) {
		timerGUI = new TimerGUI(name);
		this.countMode = countMode;
		setTotalSeconds(0);
		threadInitialize();
		resetHandle();
		timerGUI.getControlPart().getStartStopButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				startStopHandle();
			}
		});
		timerGUI.getControlPart().getResetButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				resetHandle();
			}
		});
	}

	private void threadInitialize() {
		thread = new Thread(() -> {
			try {
				while (isCounting) {
					if (this == Main.timer) {
						updateTime();
						updateGUI();
					} else {
						if (Main.timer.isCounting) {

						} else {
							updateTime();
							updateGUI();
						}
					}
					Thread.sleep(SLEEP_TIME);
					updateGUI();
				}
			} catch (InterruptedException e) {

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	private void updateGUI() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				timerGUI.getDisplayPart().update(getTimeString());
			}
		});
	}

	private void updateTime() {
		setTotalSeconds(totalSeconds + countMode);
	}

	private String getTimeString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	private void resetHandle() {
		thread.interrupt();
		if (countMode == COUNT_UP) {
			setTotalSeconds(0);
		} else {
			setTotalSeconds(30);
		}
		updateGUI();
	}

	private void startStopHandle() {
		if (!isCounting) {
			threadInitialize();
			thread.start();
		} else {
			thread.interrupt();
		}
		isCounting = !isCounting;
	}

	private void setEventHandling() {

	}

	public TimerGUI getTimerGUI() {
		return timerGUI;
	}

	public Thread getThread() {
		return thread;
	}

	public boolean isCounting() {
		return isCounting;
	}

	public void setCounting(boolean isCounting) {
		this.isCounting = isCounting;
	}

	private void setTotalSeconds(int totalSeconds) {
		this.totalSeconds = totalSeconds <= 0 ? 0 : totalSeconds;
		if (totalSeconds == 0 && countMode == COUNT_DOWN) {
			isCounting = false;
		}
		int tempTime = totalSeconds;
		hour = tempTime / 3600;
		tempTime = tempTime - hour * 3600;
		minute = tempTime / 60;
		tempTime = tempTime - minute * 60;
		second = tempTime;

	}

}