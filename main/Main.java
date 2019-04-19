package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Timer;

public class Main extends Application {
	
	//count down timer
	public static Timer timer = new Timer("Timer", Timer.COUNT_DOWN);
	public Timer stopWatch_1;
	public Timer stopWatch_2;
	
	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox(10);
		stopWatch_1 = new Timer("Stopwatch 1", Timer.COUNT_UP);
		stopWatch_2 = new Timer("Stopwatch 2", Timer.COUNT_UP);
		root.getChildren().addAll(timer.getTimerGUI(), stopWatch_1.getTimerGUI(), stopWatch_2.getTimerGUI());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Timer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		timer.getThread().interrupt();
		stopWatch_1.getThread().interrupt();
		stopWatch_2.getThread().interrupt();
		Platform.exit();
	}
	
	
}
