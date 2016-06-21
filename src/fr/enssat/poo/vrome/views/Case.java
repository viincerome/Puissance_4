package fr.enssat.poo.vrome.views;

import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {

    private static final int CASE_SIZE = 25;
    private static final int CERCLE_RAYON = 20;
    private static final long serialVersionUID = -8619336301008377067L;

    public Case() {
        Double size = 2.5 * CASE_SIZE;
        setPreferredSize(new Dimension(size.intValue(), size.intValue()));
        setBackground(Color.blue);
    }

    public static void drawCircle(final Graphics graphics, final int Centre_X, final int Centre_Y, final int Rayon) {
        graphics.fillOval(Centre_X - Rayon, Centre_Y - Rayon, 2 * Rayon, 2 * Rayon);
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.white);
        drawCircle(graphics, CASE_SIZE, CASE_SIZE, CERCLE_RAYON);
    }

}
