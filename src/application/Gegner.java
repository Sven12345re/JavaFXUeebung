package application;

import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gegner {

	SpielController spielController = new SpielController();
	
	public void gewinnErmitteln() {
	
		spielController.gewonnen.setText("Gewonnen!");
		spielController.gewonnen.setFill(Color.LAWNGREEN);
		spielController.gewonnen.setLayoutY(350);
		spielController.gewonnen.setLayoutX(410);
		spielController.gegnerSetztSchiffe.setText("");
		ScaleTransition scaleTransition = new ScaleTransition();
		scaleTransition.setDuration(Duration.seconds(3));
		scaleTransition.setNode(spielController.gewonnen);
				
		// Klasse-spezifische Einstellungen
		scaleTransition.setByY(0.8); 
		scaleTransition.setByX(1.5);
				
		// Los!
		scaleTransition.play();
		spielController.gegnerGridPaneGitter.setDisable(true);
		
	}
}
