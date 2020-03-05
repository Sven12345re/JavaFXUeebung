package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;


public class MainProgramm extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Spielfeld.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Schiffe Versenken");
			primaryStage.setScene(scene);
			primaryStage.show();
			// AudioClip
			AudioClip audioClip = new AudioClip(getClass().getResource("background_music.wav").toString());
			audioClip.setCycleCount(AudioClip.INDEFINITE); // Ohne Ende wiederholen
			audioClip.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
	
	
		launch(args);
		
	}
}
