package fr.enssat.poo.vrome.views;

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

public class Case extends JPanel{
	
	public Case(){
		setPreferredSize(new Dimension(25,25));
		setBackground(Color.blue);
	}
	
	 public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       g.setColor(Color.white);
	       drawCircle(g, 25, 25, 20);
	 }
	 
	 public void drawCircle(Graphics Cercle_g, int Centre_X, int Centre_Y, int Rayon) {
	       Cercle_g.fillOval(Centre_X - Rayon, Centre_Y - Rayon, 2*Rayon, 2*Rayon);
	   }
	 
	 public void update(Observable o, Object arg){
		 repaint();
	 }
}