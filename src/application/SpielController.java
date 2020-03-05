package application;

//import java.awt.Button;
//import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import java.util.Random;

public class SpielController implements Initializable {

	//----------------------------
	private Random random = new Random ();
	int zaehlerMeineSchiffe = 0;
	int zaehlerGewonnen = 0;
	int zaehlerVerloren = 0;
	int zaehlerGegnerSetztSchiffe = 0;
	int zaehlerGitterGegner = 0;
	int trefferZaehler = 0;
	int i = 0;
	int j = 0;

	public char[][] gegnerSchiffe = null;
	 char [][] meineSchiffe = new char [12][12];
	 char [][] gegnerGreiftAn = new char [12][12];
	 char[][] pruefeMeinFeld = new char [12][12];
	private char[][] pruefe = null;
	Text textGegner = new Text();
	Text textGegnerSetztSchiff = new Text();
	Text test = new Text();
	boolean bereit = false;

	// Attribute von meinem Feld

	@FXML GridPane gridPaneGitter;
	@FXML Pane paneZelle0000;@FXML Pane paneZelle0001;@FXML Pane paneZelle0002;@FXML Pane paneZelle0003;@FXML Pane paneZelle0004;@FXML Pane paneZelle0005;
	@FXML Pane paneZelle0006;@FXML Pane paneZelle0007;@FXML Pane paneZelle0008;@FXML Pane paneZelle0009;@FXML Pane paneZelle0010;@FXML Pane paneZelle0011;
	@FXML Pane paneZelle0100;@FXML Pane paneZelle0101;@FXML Pane paneZelle0102;@FXML Pane paneZelle0103;@FXML Pane paneZelle0104;@FXML Pane paneZelle0105;
	@FXML Pane paneZelle0106;@FXML Pane paneZelle0107;@FXML Pane paneZelle0108;@FXML Pane paneZelle0109;@FXML Pane paneZelle0110;@FXML Pane paneZelle0111;
	@FXML Pane paneZelle0200;@FXML Pane paneZelle0201;@FXML Pane paneZelle0202;@FXML Pane paneZelle0203;@FXML Pane paneZelle0204;@FXML Pane paneZelle0205;
	@FXML Pane paneZelle0206;@FXML Pane paneZelle0207;@FXML Pane paneZelle0208;@FXML Pane paneZelle0209;@FXML Pane paneZelle0210;@FXML Pane paneZelle0211;
	@FXML Pane paneZelle0300;@FXML Pane paneZelle0301;@FXML Pane paneZelle0302;@FXML Pane paneZelle0303;@FXML Pane paneZelle0304;@FXML Pane paneZelle0305;
	@FXML Pane paneZelle0306;@FXML Pane paneZelle0307;@FXML Pane paneZelle0308;@FXML Pane paneZelle0309;@FXML Pane paneZelle0310;@FXML Pane paneZelle0311;
	@FXML Pane paneZelle0400;@FXML Pane paneZelle0401;@FXML Pane paneZelle0402;@FXML Pane paneZelle0403;@FXML Pane paneZelle0404;@FXML Pane paneZelle0405;
	@FXML Pane paneZelle0406;@FXML Pane paneZelle0407;@FXML Pane paneZelle0408;@FXML Pane paneZelle0409;@FXML Pane paneZelle0410;@FXML Pane paneZelle0411;
	@FXML Pane paneZelle0500;@FXML Pane paneZelle0501;@FXML Pane paneZelle0502;@FXML Pane paneZelle0503;@FXML Pane paneZelle0504;@FXML Pane paneZelle0505;
	@FXML Pane paneZelle0506;@FXML Pane paneZelle0507;@FXML Pane paneZelle0508;@FXML Pane paneZelle0509;@FXML Pane paneZelle0510;@FXML Pane paneZelle0511;
	@FXML Pane paneZelle0600;@FXML Pane paneZelle0601;@FXML Pane paneZelle0602;@FXML Pane paneZelle0603;@FXML Pane paneZelle0604;@FXML Pane paneZelle0605;
	@FXML Pane paneZelle0606;@FXML Pane paneZelle0607;@FXML Pane paneZelle0608;@FXML Pane paneZelle0609;@FXML Pane paneZelle0610;@FXML Pane paneZelle0611;
	@FXML Pane paneZelle0700;@FXML Pane paneZelle0701;@FXML Pane paneZelle0702;@FXML Pane paneZelle0703;@FXML Pane paneZelle0704;@FXML Pane paneZelle0705;
	@FXML Pane paneZelle0706;@FXML Pane paneZelle0707;@FXML Pane paneZelle0708;@FXML Pane paneZelle0709;@FXML Pane paneZelle0710;@FXML Pane paneZelle0711;
	@FXML Pane paneZelle0800;@FXML Pane paneZelle0801;@FXML Pane paneZelle0802;@FXML Pane paneZelle0803;@FXML Pane paneZelle0804;@FXML Pane paneZelle0805;
	@FXML Pane paneZelle0806;@FXML Pane paneZelle0807;@FXML Pane paneZelle0808;@FXML Pane paneZelle0809;@FXML Pane paneZelle0810;@FXML Pane paneZelle0811;
	@FXML Pane paneZelle0900;@FXML Pane paneZelle0901;@FXML Pane paneZelle0902;@FXML Pane paneZelle0903;@FXML Pane paneZelle0904;@FXML Pane paneZelle0905;
	@FXML Pane paneZelle0906;@FXML Pane paneZelle0907;@FXML Pane paneZelle0908;@FXML Pane paneZelle0909;@FXML Pane paneZelle0910;@FXML Pane paneZelle0911;
	@FXML Pane paneZelle1000;@FXML Pane paneZelle1001;@FXML Pane paneZelle1002;@FXML Pane paneZelle1003;@FXML Pane paneZelle1004;@FXML Pane paneZelle1005;
	@FXML Pane paneZelle1006;@FXML Pane paneZelle1007;@FXML Pane paneZelle1008;@FXML Pane paneZelle1009;@FXML Pane paneZelle1010;@FXML Pane paneZelle1011;
	@FXML Pane paneZelle1100;@FXML Pane paneZelle1101;@FXML Pane paneZelle1102;@FXML Pane paneZelle1103;@FXML Pane paneZelle1104;@FXML Pane paneZelle1105;
	@FXML Pane paneZelle1106;@FXML Pane paneZelle1107;@FXML Pane paneZelle1108;@FXML Pane paneZelle1109;@FXML Pane paneZelle1110;@FXML Pane paneZelle1111;
	@FXML GridPane gegnerGridPaneGitter;
	@FXML Pane gegnerPaneZelle0000;@FXML Pane gegnerPaneZelle0001;@FXML Pane gegnerPaneZelle0002;@FXML Pane gegnerPaneZelle0003;@FXML Pane gegnerPaneZelle0004;
	@FXML Pane gegnerPaneZelle0005;@FXML Pane gegnerPaneZelle0006;@FXML Pane gegnerPaneZelle0007;@FXML Pane gegnerPaneZelle0008;@FXML Pane gegnerPaneZelle0009;
	@FXML Pane gegnerPaneZelle0010;@FXML Pane gegnerPaneZelle0011;@FXML Pane gegnerPaneZelle0100;@FXML Pane gegnerPaneZelle0101;@FXML Pane gegnerPaneZelle0102;
	@FXML Pane gegnerPaneZelle0103;@FXML Pane gegnerPaneZelle0104;@FXML Pane gegnerPaneZelle0105;@FXML Pane gegnerPaneZelle0106;@FXML Pane gegnerPaneZelle0107;
	@FXML Pane gegnerPaneZelle0108;@FXML Pane gegnerPaneZelle0109;@FXML Pane gegnerPaneZelle0110;@FXML Pane gegnerPaneZelle0111;@FXML Pane gegnerPaneZelle0200;
	@FXML Pane gegnerPaneZelle0201;@FXML Pane gegnerPaneZelle0202;@FXML Pane gegnerPaneZelle0203;@FXML Pane gegnerPaneZelle0204;@FXML Pane gegnerPaneZelle0205;
	@FXML Pane gegnerPaneZelle0206;@FXML Pane gegnerPaneZelle0207;@FXML Pane gegnerPaneZelle0208;@FXML Pane gegnerPaneZelle0209;@FXML Pane gegnerPaneZelle0210;
	@FXML Pane gegnerPaneZelle0211;@FXML Pane gegnerPaneZelle0300;@FXML Pane gegnerPaneZelle0301;@FXML Pane gegnerPaneZelle0302;@FXML Pane gegnerPaneZelle0303;
	@FXML Pane gegnerPaneZelle0304;@FXML Pane gegnerPaneZelle0305;@FXML Pane gegnerPaneZelle0306;@FXML Pane gegnerPaneZelle0307;@FXML Pane gegnerPaneZelle0308;
	@FXML Pane gegnerPaneZelle0309;@FXML Pane gegnerPaneZelle0310;@FXML Pane gegnerPaneZelle0311;@FXML Pane gegnerPaneZelle0400;@FXML Pane gegnerPaneZelle0401;
	@FXML Pane gegnerPaneZelle0402;@FXML Pane gegnerPaneZelle0403;@FXML Pane gegnerPaneZelle0404;@FXML Pane gegnerPaneZelle0405;@FXML Pane gegnerPaneZelle0406;
	@FXML Pane gegnerPaneZelle0407;@FXML Pane gegnerPaneZelle0408;@FXML Pane gegnerPaneZelle0409;@FXML Pane gegnerPaneZelle0410;@FXML Pane gegnerPaneZelle0411;
	@FXML Pane gegnerPaneZelle0500;@FXML Pane gegnerPaneZelle0501;@FXML Pane gegnerPaneZelle0502;@FXML Pane gegnerPaneZelle0503;@FXML Pane gegnerPaneZelle0504;
	@FXML Pane gegnerPaneZelle0505;@FXML Pane gegnerPaneZelle0506;@FXML Pane gegnerPaneZelle0507;@FXML Pane gegnerPaneZelle0508;@FXML Pane gegnerPaneZelle0509;
	@FXML Pane gegnerPaneZelle0510;@FXML Pane gegnerPaneZelle0511;@FXML Pane gegnerPaneZelle0600;@FXML Pane gegnerPaneZelle0601;@FXML Pane gegnerPaneZelle0602;
	@FXML Pane gegnerPaneZelle0603;@FXML Pane gegnerPaneZelle0604;@FXML Pane gegnerPaneZelle0605;@FXML Pane gegnerPaneZelle0606;@FXML Pane gegnerPaneZelle0607;
	@FXML Pane gegnerPaneZelle0608;@FXML Pane gegnerPaneZelle0609;@FXML Pane gegnerPaneZelle0610;@FXML Pane gegnerPaneZelle0611;@FXML Pane gegnerPaneZelle0700;
	@FXML Pane gegnerPaneZelle0701;@FXML Pane gegnerPaneZelle0702;@FXML Pane gegnerPaneZelle0703;@FXML Pane gegnerPaneZelle0704;@FXML Pane gegnerPaneZelle0705;
	@FXML Pane gegnerPaneZelle0706;@FXML Pane gegnerPaneZelle0707;@FXML Pane gegnerPaneZelle0708;@FXML Pane gegnerPaneZelle0709;@FXML Pane gegnerPaneZelle0710;
	@FXML Pane gegnerPaneZelle0711;@FXML Pane gegnerPaneZelle0800;@FXML Pane gegnerPaneZelle0801;@FXML Pane gegnerPaneZelle0802;@FXML Pane gegnerPaneZelle0803;
	@FXML Pane gegnerPaneZelle0804;@FXML Pane gegnerPaneZelle0805;@FXML Pane gegnerPaneZelle0806;@FXML Pane gegnerPaneZelle0807;@FXML Pane gegnerPaneZelle0808;
	@FXML Pane gegnerPaneZelle0809;@FXML Pane gegnerPaneZelle0810;@FXML Pane gegnerPaneZelle0811;@FXML Pane gegnerPaneZelle0900;@FXML Pane gegnerPaneZelle0901;
	@FXML Pane gegnerPaneZelle0902;@FXML Pane gegnerPaneZelle0903;@FXML Pane gegnerPaneZelle0904;@FXML Pane gegnerPaneZelle0905;@FXML Pane gegnerPaneZelle0906;
	@FXML Pane gegnerPaneZelle0907;@FXML Pane gegnerPaneZelle0908;@FXML Pane gegnerPaneZelle0909;@FXML Pane gegnerPaneZelle0910;@FXML Pane gegnerPaneZelle0911;
	@FXML Pane gegnerPaneZelle1000;@FXML Pane gegnerPaneZelle1001;@FXML Pane gegnerPaneZelle1002;@FXML Pane gegnerPaneZelle1003;@FXML Pane gegnerPaneZelle1004;
	@FXML Pane gegnerPaneZelle1005;@FXML Pane gegnerPaneZelle1006;@FXML Pane gegnerPaneZelle1007;@FXML Pane gegnerPaneZelle1008;@FXML Pane gegnerPaneZelle1009;
	@FXML Pane gegnerPaneZelle1010;@FXML Pane gegnerPaneZelle1011;@FXML Pane gegnerPaneZelle1100;@FXML Pane gegnerPaneZelle1101;@FXML Pane gegnerPaneZelle1102;
	@FXML Pane gegnerPaneZelle1103;@FXML Pane gegnerPaneZelle1104;@FXML Pane gegnerPaneZelle1105;@FXML Pane gegnerPaneZelle1106;@FXML Pane gegnerPaneZelle1107;
	@FXML Pane gegnerPaneZelle1108;@FXML Pane gegnerPaneZelle1109;@FXML Pane gegnerPaneZelle1110;@FXML Pane gegnerPaneZelle1111;
	
	@FXML Text gegnerSetztSchiffe;
	@FXML Text gewonnen;
	@FXML Text treffer;
	@FXML Button button;
	@FXML Button bereitButton;
	

	//----------------------------
	// Methoden
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
				//Mein Feld
			paneZelle0000.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0001.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0002.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0003.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0004.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0005.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0006.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0007.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0008.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0009.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0010.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0011.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0100.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0101.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0102.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0103.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0104.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0105.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0106.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0107.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0108.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0109.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0110.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0111.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0200.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0201.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0202.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0203.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0204.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0205.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0206.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0207.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0208.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0209.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0210.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0211.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0300.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0301.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0302.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0303.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0304.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0305.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0306.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0307.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0308.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0309.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0310.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0311.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0400.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0401.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0402.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0403.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0404.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0405.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0406.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0407.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0408.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0409.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0410.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0411.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0500.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0501.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0502.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0503.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0504.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0505.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0506.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0507.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0508.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0509.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0510.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0511.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0600.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0601.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0602.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0603.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0604.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0605.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0606.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0607.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0608.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0609.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0610.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0611.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0700.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0701.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0702.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0703.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0704.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0705.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0706.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0707.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0708.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0709.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0710.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0711.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0800.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0801.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0802.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0803.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0804.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0805.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0806.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0807.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0808.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0809.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0810.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0811.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0900.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0901.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0902.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0903.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0904.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0905.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0906.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0907.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0908.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0909.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0910.setOnMouseClicked(this::handlePaneZelle);
			paneZelle0911.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1000.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1001.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1002.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1003.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1004.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1005.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1006.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1007.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1008.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1009.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1010.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1011.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1100.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1101.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1102.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1103.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1104.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1105.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1106.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1107.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1108.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1109.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1110.setOnMouseClicked(this::handlePaneZelle);
			paneZelle1111.setOnMouseClicked(this::handlePaneZelle);
		
		
		
		//Gegner
		gegnerPaneZelle0000.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0001.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0002.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0003.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0004.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0005.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0006.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0007.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0008.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0009.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0010.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0011.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0100.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0101.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0102.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0103.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0104.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0105.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0106.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0107.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0108.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0109.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0110.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0111.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0200.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0201.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0202.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0203.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0204.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0205.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0206.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0207.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0208.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0209.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0210.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0211.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0300.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0301.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0302.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0303.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0304.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0305.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0306.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0307.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0308.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0309.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0310.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0311.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0400.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0401.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0402.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0403.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0404.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0405.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0406.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0407.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0408.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0409.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0410.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0411.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0500.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0501.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0502.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0503.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0504.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0505.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0506.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0507.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0508.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0509.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0510.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0511.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0600.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0601.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0602.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0603.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0604.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0605.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0606.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0607.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0608.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0609.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0610.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0611.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0700.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0701.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0702.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0703.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0704.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0705.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0706.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0707.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0708.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0709.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0710.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0711.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0800.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0801.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0802.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0803.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0804.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0805.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0806.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0807.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0808.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0809.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0810.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0811.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0900.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0901.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0902.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0903.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0904.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0905.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0906.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0907.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0908.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0909.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0910.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle0911.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1000.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1001.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1002.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1003.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1004.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1005.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1006.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1007.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1008.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1009.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1010.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1011.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1100.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1101.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1102.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1103.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1104.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1105.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1106.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1107.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1108.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1109.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1110.setOnMouseClicked(this::handlePaneZelle);
		gegnerPaneZelle1111.setOnMouseClicked(this::handlePaneZelle);
		
		
		
		gegnerSetztSchiffe.setText("Setzte 4 Schiffe!(1x1)");
		gewonnen.setText("");
		treffer.setText("");
		button.setOnAction(this::handleButtonMalKlicken);
		bereitButton.setOnAction(this::handleBereitButton);
		//zugGegner();
		
	}

	public void handleBereitButton(ActionEvent event) {
		
		//Methoden methoden = new Methoden();
		//methoden.zufaelligSchiffeSetzten();
		//methoden.test();
		//zugGegner();
		schiffe();
		Gegner gegner = new Gegner();
		//gegner.schiffe();
		bereit = true;
		
	}
	
	public void handleButtonMalKlicken(ActionEvent event) {
		
	
		for(int i = 0 ; i< 10; i++) {
			
			
			for(int j = 0 ; j< 10; j++) {
				Text text2 = new Text();
				// Grosses X
				text2.setText("x");
				Font font = new Font(30);
				text2.setFont(font);
				// X in die Mitte der Zelle positionieren
				text2.setX(10);
				text2.setY(30);

				Pane	paneZelle = (Pane) gridPaneGitter.lookup("#paneZelle" + "0" + i + "0" + j);
				paneZelle.getChildren().clear();
				
				Pane	paneZelleGegner = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + "0" + i + "0" + j);
				paneZelleGegner.getChildren().clear();
			}
		}
		System.out.println("Hallo");
	}
	
	public void handlePaneZelle(MouseEvent event) {

		Node zelle = (Node) event.getSource();
		String fxId = zelle.getId();
		int length = fxId.length();
		j = Integer.parseInt(fxId.substring(length - 4, length - 2));
		i = Integer.parseInt(fxId.substring(length - 2, length ));
		
		if(zaehlerMeineSchiffe < 4) {
			schiffeSetzten();
			zaehlerMeineSchiffe++;
		}
		
		if(bereit == true) {
			schiffeAngreifen();
		}
	
		
	}
	
	public void schiffeSetzten(){
		
		Methoden methoden = new Methoden();
		Text text = new Text();
		Pane paneZelle = (Pane) gridPaneGitter.lookup("#paneZelle" + methoden.gitterAktualisieren(j, i));
	
		text.setText("A");
		Font font = new Font(30);
		text.setFont(font);
		text.setX(10);
		text.setY(30);

		paneZelle.getChildren().add(text);
		paneZelle.setDisable(true);
				
	}
	
	public void zugGegner(int laenge, int anzahl) {

			Methoden methoden = new Methoden();
			Random random = new Random();
			int schiffGroesse = 0; 
			for (int i = 0; i < anzahl; i++) {
				System.out.println("Neues Schiff");
				boolean welcheRichtung = random.nextBoolean();
				int jGegner =0 + (int)(Math.random() * (12));
				int iGegner =0 + (int)(Math.random() * (12));
				
				while(schiffGroesse < laenge) {
					try {
						Pane paneZelle = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner, iGegner));	
						Pane paneZellePruefe1 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner-1, iGegner-1));	            
						Pane paneZellePruefe2 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner-1, iGegner+1));	            
						Pane paneZellePruefe3 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner-1, iGegner));	            
						Pane paneZellePruefe4 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner+1, iGegner));	            
						Pane paneZellePruefe5 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner, iGegner-1));	            
						Pane paneZellePruefe6 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner, iGegner+1));	            
						Pane paneZellePruefe7 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner+1, iGegner-1));	            
						Pane paneZellePruefe8 = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner+1, iGegner+1));	            
						boolean nichtBelegt = true;	
						
						if(paneZelle.getChildren().isEmpty()) {
							try {
								if(!paneZellePruefe1.getChildren().isEmpty()) {
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe2.getChildren().isEmpty()) {	
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe3.getChildren().isEmpty()) {	
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe4.getChildren().isEmpty()) {
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe5.getChildren().isEmpty()) {
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe6.getChildren().isEmpty()) {	
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe7.getChildren().isEmpty()) {	
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							}
							try {
								if(!paneZellePruefe8.getChildren().isEmpty()) {	
									nichtBelegt = false;
								}		
							} catch (Exception e) {
							} 
							
							if (nichtBelegt == true) {
								schiffGroesse++;
								System.out.println("Schif: " + jGegner + " " + iGegner);
								if(welcheRichtung == true && (schiffGroesse < laenge)) {
									iGegner++;
								} 
								if(welcheRichtung == false && (schiffGroesse < laenge)) {
									jGegner++;
								}
									
							}
							if(nichtBelegt == false) {
								System.out.println("Nachbarzelle von: " + jGegner + " " + iGegner +  " ist besetzt");
								jGegner = 0 + (int)(Math.random() * (12));
								iGegner = 0 + (int)(Math.random() * (12));
								schiffGroesse = 0;
							}
					
						}
						else {
							System.out.println("Zelle: " + jGegner + " " + iGegner +  " ist besetzt");
							jGegner = 0 + (int)(Math.random() * (12));
							iGegner = 0 + (int)(Math.random() * (12));
							schiffGroesse = 0;	
						}
						
					} catch (Exception e) {
						System.out.println("Schiff landet mit: " + jGegner + " " + iGegner + " im nichts");
						jGegner = 0 + (int)(Math.random() * (12));
						iGegner = 0 + (int)(Math.random() * (12));
						schiffGroesse = 0;
						}
				}
			
				while(schiffGroesse > 0) {
					
					Text text = new Text();
					text.setText("A");
					Font font = new Font(30);
					text.setFont(font);
					text.setX(10);
					text.setY(30);
					Pane paneZelleSetzten = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(jGegner, iGegner));
					System.out.println("Endgültige platzierung vom Schiff bei " + jGegner + " " + iGegner);
					paneZelleSetzten.getChildren().add(text);
					
					if(welcheRichtung == true) {
						iGegner--;
					} else {
						jGegner--;
					}
					schiffGroesse--;	
				}
			}
			
			bereitButton.setDisable(true);
	}
	
	public void schiffe() {
		int laenge = 0;
		int anzahl = 0;
		//Schlachtschiff
		System.out.println("Schlachtschiff");
		 laenge = 5;
		 anzahl = 1;
		 zugGegner(laenge, anzahl);
		//Kreuzer
		 System.out.println("Kreuzer");
		 laenge = 4;
		 anzahl = 2;
		 zugGegner(laenge, anzahl);
		//Zerstörer
		 System.out.println("Zerstörer");
		 laenge = 3;
		 anzahl = 3;
		 zugGegner(laenge, anzahl);
		//Uboote
		 System.out.println("Uboote");
		 laenge = 2;
		 anzahl = 4;
		zugGegner(laenge, anzahl);
	}
	
	public void schiffeAngreifen() {
		
		Methoden methoden = new Methoden();
		Gegner gegner = new Gegner();
		Text text = new Text();
		Pane paneZelle = (Pane) gegnerGridPaneGitter.lookup("#gegnerPaneZelle" + methoden.gitterAktualisieren(j, i));
		Font font = new Font(30);
		text.setFont(font);
		text.setX(10);
		text.setY(30);
			
		if(paneZelle.getChildren().isEmpty()) {
				
			text.setText("O");
			paneZelle.getChildren().add(text);
			paneZelle.setDisable(true);
		}
		else {
			text.setText("X");
			paneZelle.getChildren().add(text);
			paneZelle.setDisable(true);
			trefferZaehler++;
			System.out.println(trefferZaehler);
		}
		
		if(trefferZaehler == 30) {
			gewonnen.setText("Gewonnen!");
			gewonnen.setFill(Color.LAWNGREEN);
			gewonnen.setLayoutY(350);
			gewonnen.setLayoutX(410);
			gegnerSetztSchiffe.setText("");
			ScaleTransition scaleTransition = new ScaleTransition();
			scaleTransition.setDuration(Duration.seconds(3));
			scaleTransition.setNode(gewonnen);
					
			// Klasse-spezifische Einstellungen
			scaleTransition.setByY(0.8); 
			scaleTransition.setByX(1.5);
					
			// Los!
			scaleTransition.play();
			gegnerGridPaneGitter.setDisable(true);
			
		}

	}
	
}
