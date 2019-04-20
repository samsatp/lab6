package main;
import logic.Timer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static Timer Downtimer = new Timer("countDownTimer",-1);
	private static Timer UpTimer1 = new Timer("countUpTimer1",1);
	private static Timer UpTimer2 = new Timer("countUpTimer2",1);


	@Override
	public void start(Stage primaryStage) {

		HBox root = new HBox();


		root.getChildren().addAll(Downtimer.getTimerGUI(), UpTimer1.getTimerGUI(), UpTimer2.getTimerGUI() );

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
		Downtimer.getThread().interrupt();
		UpTimer1.getThread().interrupt();
		UpTimer2.getThread().interrupt();
		Platform.exit();

	}


}
