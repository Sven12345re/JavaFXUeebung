package application;

import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SpielModell {

	//Attribut 
	private char[][] gitter = null;
	private char[] gitterTest = null;
	private char[][] gitterGegner = null;

	private int xZaehler = 0;
	private String s = "";
	public ArrayList<String> zellen = new ArrayList<String>();
	private Random random = new Random ();
	
	//Konstruktor
	public SpielModell() {
		gitter = new char[12][12];
		gitterTest = new char[5];
		gitterGegner = new char[14][14];
		
		
		
		// Das Gitter initialisieren
		for (int j = 0; j < 12; j++) {
			for (int i = 0; i < 12; i++) {
				
			
			gitter[j][i] = ' ';
			}
		}
		
		// Das GitterGegner initialisieren
		for (int i = 0; i < 5; i++) {
			gitterGegner[i][i] = ' ';
		}
	}
	
	//----------------------------
	// Methoden
	public void schiffeAngreifen(int i, int j) {
		if (gitter[j][i] == 'A') {
			
			gitter[j][i] = 'X';
			xZaehler++;
		}
		
		
		
	}
	
	public void schiffeSetzen(int j, int i) {
		gitter[j][i] = 'A';
	}
	
	public void drankommen(int i) {
		gitterTest[i] = 'O';
	}
	
	public char getZelle(int i, int j) {
		return gitter[j][i];
	}
	
	
	public char getZelle2(int i) {
		return gitterTest[i];
	}
	
	public boolean gewinnErmitteln() {
		boolean gewonnen = false;
		
		if (xZaehler == 4) {
			gewonnen = true;
			System.out.println(xZaehler);
		}
		
		return gewonnen;
	}
	
	public void visualisieren() {

		System.out.println("   1 " + " 2 " + " 3 " + " 4 " + " 5 " + " 6 " + " 7 " + " 8 " + " 9" + "  10" + " 11" +  " 12");
		System.out.println("  -------------------------------------");
		for (int i = 0; i< 12; i++) {
			char lower = (char) ('a' + i);
		
			
			System.out.println((lower + " ") + "| " + gitter[i][0] + "| " + gitter[i][1] + "| " + gitter[i][2] + "| " + gitter[i][3] + "| " + gitter[i][4] + "| " + gitter[i][5] + "| "
							 	   + gitter[i][6] + "| " + gitter[i][7] + "| " + gitter[i][8] + "| " + gitter[i][9] + "| " + gitter[i][10] + "| "+ gitter[i][11] + "| ");
			System.out.println("  -------------------------------------");
			
		}
		
		

		System.out.println("   1 " + " 2 " + " 3 " + " 4 " + " 5 " + " 6 " + " 7 " + " 8 " + " 9" + "  10" + " 11" +  " 12");
		System.out.println("  -------------------------------------");
		for (int j = 0; j< 12; j++) {
			char lower = (char) ('a' + j);
			System.out.print((lower + " "));
			
			for (int i = 0; i<12; i++) {
				
				
				System.out.print( "| " + gitterGegner[j+1][i+1] );
				
			}
			System.out.println("");
			
			System.out.println("  -------------------------------------");
			
		//	System.out.println((lower + " ") + "| " + gitterGegner[i+1][0] + "| " + gitterGegner[i+1][1] + "| " + gitterGegner[i+1][2] + "| " + gitterGegner[i+1][3] + "| " + gitterGegner[i+1][4] + "| " + gitterGegner[i+1][5] + "| "
			//				 	   + gitterGegner[i+1][6] + "| " + gitterGegner[i+1][7] + "| " + gitterGegner[i+1][8] + "| " + gitterGegner[i+1][9] + "| " + gitterGegner[i+1][10] + "| "+ gitterGegner[i+1][11] + "| ");
			
			
		}


	}
	
	public void zellenAlsString() {
		for (int j =0; j < gitter.length; j++) {
			
			
		for(int i = 0; i < gitter.length; i++) {
		
			 s= String.valueOf(j);
			s= s+ "," +  String.valueOf(i);
			//System.out.println(s);
			zellen.add(s);
			
		}
	}
		

	}
	
	public void GegnerSetztSchiffe(int i, int j) {
	
	 	int zaehler = 0;
	 
	
	      
	 	//setzt zufällig 4 U-Boote
	    while (zaehler<4) {
	        i = 1 + random.nextInt(12 - 1 + 1);
		      j = 1 + random.nextInt(12 - 1 + 1);
		    
		      
	  	if (gitterGegner[i][j] != 'G' && gitterGegner[i+1][j] != 'G'
	  							&& gitterGegner[i][j+1] != 'G'
	  							&& gitterGegner[i-1][j] != 'G'
	  							&& gitterGegner[i][j-1] != 'G'
	  							&& gitterGegner[i+1][j+1] != 'G'
	  							&& gitterGegner[i+1][j-1] != 'G'
	  							&& gitterGegner[i-1][j-1] != 'G'
	  							&& gitterGegner[i-1][j+1] != 'G') {
	  	  System.out.println(i + " " + j);
	  		gitterGegner[i][j] = 'G';
	  	
	  	    
	  		zaehler++;
	  	}
	  	 
	    } // end of while
	    

	
	}
	
	
}
