package fr.enssat.poo.vrome;

import javax.swing.JFrame;

import fr.enssat.poo.vrome.controlers.ApplicationController;
import fr.enssat.poo.vrome.views.SettingView;

public class Puissance4Launcher {

    public static void main(final String[] args) {
        new ApplicationController().launch();
        //JFrame fenetre = new SettingView(null);
    }

//	public static void main(String args[]){
//		
//		//Declaration d'une matrice
//		Plateau matricetest;
//		//Creation matrice test
//		matricetest = Plateau.creerMatrice(6,7,0);
//		//Affichage de la matrice
//		matricetest.afficheMatrice();
//		
//		//Changement de la ligne 6 colonne 3 en 1
//		matricetest.setel(5,2,1);
//		
//		matricetest.afficheMatrice();
//		
//		JFrame fenetre = new SettingView();
//	}
}
