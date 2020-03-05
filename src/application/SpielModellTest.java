package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class SpielModellTest {

	@Test
	void test() {
		//----------------------------
		// Arrange
		SpielModell dasSpiel = new SpielModell();
		dasSpiel.zellenAlsString();
		int i = 0;
		int j = 0;
		
	dasSpiel.GegnerSetztSchiffe(i, j);
	dasSpiel.visualisieren();
	
		//System.out.println(dasSpiel.zellen.get();
		
		System.out.println("----- Das Leere Spielfeld -----");
		System.out.println();
		dasSpiel.visualisieren();
		System.out.println();
		
	
		
		//4 U-Boote setzen
	
		dasSpiel.schiffeSetzen(1, 1);
		
		dasSpiel.schiffeSetzen(8, 8);
	
		
		dasSpiel.schiffeSetzen(11, 0);
	
		
		dasSpiel.schiffeSetzen(0, 11);

		
		
		System.out.println("----- Schiffe alle gesetzt -----");
		System.out.println();
		dasSpiel.visualisieren();
		System.out.println();
		
		
		//Angreifen
		
		dasSpiel.schiffeAngreifen(0, 7);
		dasSpiel.schiffeAngreifen(1, 7);
		dasSpiel.schiffeAngreifen(2, 7);
		dasSpiel.schiffeAngreifen(3, 7);
		dasSpiel.schiffeAngreifen(4, 7);
			
		dasSpiel.schiffeAngreifen(6, 0);
		dasSpiel.schiffeAngreifen(6, 1);
		dasSpiel.schiffeAngreifen(6, 2);
		dasSpiel.schiffeAngreifen(6, 3);
		
		dasSpiel.schiffeAngreifen(5, 11);
		dasSpiel.schiffeAngreifen(6, 11);
		dasSpiel.schiffeAngreifen(7, 11);
		dasSpiel.schiffeAngreifen(8, 11);
		

		dasSpiel.schiffeAngreifen(11, 8);
		dasSpiel.schiffeAngreifen(11, 9);
		dasSpiel.schiffeAngreifen(11, 10);
		
		dasSpiel.schiffeAngreifen(9, 4);
		dasSpiel.schiffeAngreifen(9, 5);
		dasSpiel.schiffeAngreifen(9, 6);
		
		dasSpiel.schiffeAngreifen(2, 3);
		dasSpiel.schiffeAngreifen(3, 3);
		dasSpiel.schiffeAngreifen(4, 3);
		

		dasSpiel.schiffeAngreifen(0, 1);
		dasSpiel.schiffeAngreifen(1, 1);
		
		dasSpiel.schiffeAngreifen(8, 8);
		dasSpiel.schiffeAngreifen(9, 8);
		
		dasSpiel.schiffeAngreifen(11, 0);
		dasSpiel.schiffeAngreifen(11, 1);
		
		dasSpiel.schiffeAngreifen(0, 11);
		dasSpiel.schiffeAngreifen(0, 10);
		
		dasSpiel.visualisieren();
		
		assertTrue(dasSpiel.gewinnErmitteln());
		
		
	}

}
