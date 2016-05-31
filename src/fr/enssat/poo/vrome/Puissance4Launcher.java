package fr.enssat.poo.vrome;

import fr.enssat.poo.vrome.controlers.ApplicationController;
import fr.enssat.poo.vrome.models.Modele;

public class Puissance4Launcher {

	/*public static void main(final String[] args) {
		new ApplicationController().launch();
		System.out.println("Bonjour");
	}*/
	
	public static void main(String args[]){
		
		//Déclaration d'une matrice
		Modele matricetest;
		//Création matrice test
		matricetest = Modele.creerMatrice(6,7,0);
		//Affichage de la matrice
		matricetest.afficheMatrice();
		
		//Changement de la ligne 6 colonne 3 en 1
		matricetest.setel(5,2,1);
		
		matricetest.afficheMatrice();
	}
}
