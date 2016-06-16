package fr.enssat.poo.vrome.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;

import javax.swing.JPanel;

public class Case extends JPanel {

	private static final long serialVersionUID = -8619336301008377067L;

	public static void drawCircle(final Graphics Cercle_g, final int Centre_X, final int Centre_Y, final int Rayon) {
		Cercle_g.fillOval(Centre_X - Rayon, Centre_Y - Rayon, 2 * Rayon, 2 * Rayon);
	}

	public Case() {
		setPreferredSize(new Dimension(25, 25));
		setBackground(Color.blue);
	}

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		drawCircle(g, 25, 25, 20);
	}

	public void update(final Observable o, final Object arg) {
		repaint();
	}
}
