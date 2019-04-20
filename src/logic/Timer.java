package logic;

import gui.TimerGUI;
import javafx.application.Platform;
import main.Main;

public class Timer{

	public static final int SLEEP_TIME = 1000;
	public static final int COUNT_UP = 1;
	public static final int COUNT_DOWN = -1;

	private TimerGUI timerGUI;
	private int hour=0;
	private int minute=0;
	private int second=0;
	private int countMode;
	private boolean isCounting =false;
	private Thread thread;


	public Timer(String name, int countMode) {

		timerGUI = new TimerGUI(name);
		this.countMode = countMode;
		resetHandle();

		timerGUI.getControlPart().getStartStopButton().setOnAction(e -> startStopHandle());
		timerGUI.getControlPart().getResetButton().setOnAction(e -> resetHandle());

		threadInitialize();
	}

	private void threadInitialize() {
		thread = new Thread(){
			public void run() {
				setEventHandling();

			}
		};
	}

	private void startStopHandle() {

		if(thread.getState() == Thread.State.NEW){
			isCounting =! isCounting;
			thread.start();
		}
		else {
			if(this.equals(Main.Downtimer) || !Main.Downtimer.isCounting){
				isCounting = !isCounting;
				thread.interrupt();
				threadInitialize();
			}

		}
	}



	private void setEventHandling() {

		while(isCounting){
			try {
				if(Main.Downtimer.isCounting && !this.equals(Main.Downtimer)){
					try {
						Main.Downtimer.getThread().join();
					}catch (InterruptedException e){}
				}
				updateTime();
				updateGUI();
				Thread.sleep(SLEEP_TIME);
				//System.out.println(timerGUI.getName()+"is Running");
			}
			catch(InterruptedException e) {setEventHandling();}
		}

	}

	private void updateGUI() {
		Platform.runLater(new Runnable() {
			public void run() {
				timerGUI.getDisplayPart().update(getTimeString());
			}
		});

	}

	private void updateTime() {

		if(countMode == COUNT_UP) {

			if(second == 59) {
				if(minute ==59) {
					hour++; minute=0; second=0;
				}
				minute++; second=0;
			}
			second++;
		}
		if(countMode == COUNT_DOWN) {
			if(second==0) {
				isCounting = !isCounting;
				thread.interrupt();
				threadInitialize();
			}
			else second--;
		}

	}



	private String getTimeString() {
		return String.format("%d : %d : %d", hour, minute, second);
	}

	private void resetHandle() {
		if(countMode==1) hour=minute=second=0;
		if(countMode==-1) { hour=0;minute=0;second=30; }
		updateGUI();
	}








	//Generate Getters
	public TimerGUI getTimerGUI() {
		return this.timerGUI;
	}
	public Thread getThread() {
		return this.thread;
	}


}
