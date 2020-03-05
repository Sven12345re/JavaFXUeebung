package application;

import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Methoden {
	
	public void handlePaneZelle(MouseEvent event) {
		SpielController spielController = new SpielController();
		
		Node zelle = (Node) event.getSource();
		String fxId = zelle.getId();
		int length = fxId.length();
		int i = 0;
		int j = 0;
	


		
		String stringJ = fxId.substring(length - 4, length -2 );
		String stringI = fxId.substring(length - 2, length);
	
		
		System.out.println(stringJ);	
		System.out.println(stringI);
			j = Integer.parseInt(fxId.substring(length - 4, length - 2));
			i = Integer.parseInt(fxId.substring(length - 2, length ));
			
		
		

		//System.out.println(j);
		//System.out.println(i);
	
		//zaehlerMeineSchiffe++;
		if(zaehlerMeineSchiffe < 4) {
			
			meineSchiffe[j][i] = 'A';
		gitterAktualisieren(j,i);
			
			
		}
		else {
		gitterGegnerAktualisieren(j,i);
			spielController.gegnerSetztSchiffe.setFill(Color.RED);
			if(!gewinnErmitteln()) {
				spielController.gegnerSetztSchiffe.setText("Der Gegner ist dran!");
			}
			
		}
		
		
		if(zaehlerMeineSchiffe >= 4) {
	
			spielController.gridPaneGitter.setDisable(true);
			
		}
	
	
	}
	
	private Random random = new Random ();
	int zaehlerMeineSchiffe = 0;
	int zaehlerGewonnen = 0;
	int zaehlerVerloren = 0;
	int zaehlerGegnerSetztSchiffe = 0;
	int zaehlerGitterGegner = 0;

	public char[][] gegnerSchiffe = null;
	 char [][] meineSchiffe = new char [12][12];
	 char [][] gegnerGreiftAn = new char [12][12];
	 char[][] pruefeMeinFeld = new char [12][12];
	private char[][] pruefe = null;
	Text textGegner = new Text();
	Text textGegnerSetztSchiff = new Text();
	Text test = new Text();
	
	public void test() {
		SpielController spielController = new SpielController();
		
	}

	public String gitterAktualisieren(int j, int i) {
		SpielController spielController = new SpielController();
		zaehlerMeineSchiffe++;
		if(zaehlerMeineSchiffe == 4) {
			//spielController.gridPaneGitter.setDisable(true);
		}
		String zelle = "";
		if((j==11 || j==10) && (i!=11 && i!=10) ) {
			 zelle = String.valueOf(j) + "0" + String.valueOf(i);
		}
		
		
		
		if ((j!=11 && j!=10) && (i!=11 && i!=10)){
			zelle = "0" + String.valueOf(j) + "0" + String.valueOf(i);
		}
		
		
		if ((j==11 || j==10) && (i==11 || i==10)){
			zelle = String.valueOf(j) + String.valueOf(i);
		}

		if((i==11 || i==10) && (j!=11 && j!=10) ) {
			 zelle = "0" + String.valueOf(j) +  String.valueOf(i);
		}
		
	
		return zelle;
	}
	

	public String gitterGegnerAktualisieren(int j, int i) {
		SpielController spielController = new SpielController();
		pruefe = new char[12][12];
		zaehlerMeineSchiffe++;	
		pruefe[j][i] = 'A';
		Text text = new Text();
		Pane paneZelleGegner = null;
	
	String zelleGegner = "";
		if((j==11 || j==10) && (i!=11 && i!=10) ) {
			 zelleGegner = String.valueOf(j) + "0" + String.valueOf(i);
		}
		
		
		
		if ((j!=11 && j!=10) && (i!=11 && i!=10)){
			zelleGegner = "0" + String.valueOf(j) + "0" + String.valueOf(i);
		}
		
		
		if ((j==11 || j==10) && (i==11 || i==10)){
			zelleGegner= String.valueOf(j) + String.valueOf(i);
		}

		if((i==11 || i==10) && (j!=11 && j!=10) ) {
			 zelleGegner = "0" + String.valueOf(j) +  String.valueOf(i);
		}
		if(zaehlerGegnerSetztSchiffe == 4) {
			
		//Überprüft ob es zu einem Treffer kommt
		if(spielController.gegnerSchiffe[j][i] == pruefe[j][i]) {
			
			text.setText("X");
			spielController.treffer.setText("Du hast getroffen");
			spielController.treffer.setLayoutX(1000);
			spielController.treffer.setLayoutY(150);
			spielController.treffer.setFill(Color.LAWNGREEN);
			Font font = new Font(30);
			text.setFont(font);
			
			text.setX(10);
			text.setY(30);

			// Der Text in die Zelle einfuegen
			paneZelleGegner.getChildren().add(text);
			paneZelleGegner.setDisable(true);
			zaehlerGewonnen++;
			if(!gewinnErmitteln()) {
				
				spielController.gegnerGridPaneGitter.setDisable(true);
				 PauseTransition holdTimer = new PauseTransition(Duration.seconds(2));
				    holdTimer.setOnFinished(event -> {
				      
				    	gegnerGreiftAn();
				  
							
						
				    	spielController.gegnerGridPaneGitter.setDisable(false);
				    });
				    holdTimer.play();
				
				}
			
			//Überprüft ein Gewinn bei Sieg sind keine weiteren Züge möglich
			if(gewinnErmitteln()) {
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
			else {
				
				text.setText("O");
				Font font = new Font(30);
				text.setFont(font);
		
				text.setX(10);
				text.setY(30);
				spielController.treffer.setText("Du hast daneben geschossen!");
				spielController.treffer.setLayoutX(1000);
				spielController.treffer.setLayoutY(150);
				spielController.treffer.setFill(Color.LAWNGREEN);
				// Der Text in die Zelle einfuegen
				paneZelleGegner.getChildren().add(text);
				paneZelleGegner.setDisable(true);
				spielController.gegnerGridPaneGitter.setDisable(true);
				 PauseTransition holdTimer = new PauseTransition(Duration.seconds(2));
				    holdTimer.setOnFinished(event -> {
				        //handler.handle(eventWrapper.content);
				    	gegnerGreiftAn();	
				    	spielController.gegnerGridPaneGitter.setDisable(false);
				    });
				    holdTimer.play();
			}
		
		
	}
	
		return zelleGegner;
}
	
	public void gegnerGreiftAn() {
		SpielController spielController = new SpielController();
		boolean feldBelegt = false;
		

		int iGegner = 0;
		int jGegner = 0;
		while(feldBelegt == false) {
	
			

		    	iGegner = 0 + random.nextInt(11 - 0 + 1);
				jGegner = 0 + random.nextInt(11 - 0 + 1);		
		if(pruefeMeinFeld[jGegner][iGegner]!= 'A') {
			
			gegnerGreiftAn[jGegner][iGegner]= 'A';
			pruefeMeinFeld[jGegner][iGegner]= 'A';
			Pane paneZelle = null;
			
			if ((jGegner!=11 && jGegner!=10) && (iGegner!=11 && iGegner!=10)){
			
				paneZelle = (Pane) spielController.gridPaneGitter.lookup("#paneZelle" + "0" +  jGegner  +  "0" + iGegner);
			
				}
		
			if((jGegner==11 || jGegner==10) && (iGegner!=11 && iGegner!=10) ) {
				paneZelle = (Pane) spielController.gridPaneGitter.lookup("#paneZelle" + jGegner  +  "0" + iGegner);
		
				}
		
			if((iGegner==11 || iGegner==10) && (jGegner!=11 && jGegner!=10) ) {
				paneZelle = (Pane) spielController.gridPaneGitter.lookup("#paneZelle" + "0" +  jGegner  +   iGegner);
	
				}
		
			if ((jGegner==11 || jGegner==10) && (iGegner==11 || iGegner==10)){
				paneZelle = (Pane) spielController.gridPaneGitter.lookup("#paneZelle" +  jGegner   +  iGegner);
		 
				}
		
			feldBelegt = true;
			
			if(pruefeMeinFeld[jGegner][iGegner] == meineSchiffe[jGegner][iGegner]) {
				
				 textGegner = new Text();
				textGegner.setText("X");
				Font fontTest = new Font(30);
				textGegner.setFont(fontTest);
				// X in die Mitte der Zelle positionieren
				textGegner.setX(10);
				textGegner.setY(30);
			
					spielController.treffer.setText("Der Gegner hat getroffen!");
					spielController.treffer.setLayoutX(1000);
					spielController.treffer.setLayoutY(150);
					spielController.treffer.setFill(Color.RED);
				
				
				// Der Text in die Zelle einfuegen
				

				 
				    paneZelle.getChildren().add(textGegner);
			 		paneZelle.setDisable(true);
				
				
				zaehlerVerloren++;
					
				if(niederlageErmitteln()) {
					spielController.gewonnen.setText("Verloren!");
					spielController.gewonnen.setFill(Color.RED);
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
			
			else {
				
				 textGegner = new Text();
				textGegner.setText("O");
				Font fontTest = new Font(30);
				textGegner.setFont(fontTest);
				// X in die Mitte der Zelle positionieren
				textGegner.setX(10);
				textGegner.setY(30);

				spielController.treffer.setText("Der Gegner hat daneben geschossen!");
				spielController.treffer.setLayoutX(1000);
				spielController.treffer.setLayoutY(150);
				spielController.treffer.setFill(Color.RED);
					
			
					paneZelle.getChildren().add(textGegner);
					paneZelle.setDisable(true);
					
			}
		
	
		}	
				
		}
		
		if(!niederlageErmitteln()) {
			spielController.gegnerSetztSchiffe.setFill(Color.LAWNGREEN);
			spielController.gegnerSetztSchiffe.setText("Du bist dran!");
		
		}

	}
	
	public boolean gewinnErmitteln() {
		if(zaehlerGewonnen> 3) {
			return true;
		}
		
		return false;
	}
	
	public boolean niederlageErmitteln() {
		if(zaehlerVerloren> 3) {
			return true;
		}
		
		return false;
	}

	
}
