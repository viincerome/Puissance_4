package fr.enssat.poo.vrome.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.enssat.poo.vrome.controlers.ApplicationController;

import javax.swing.*;

public class InfoView extends JFrame {

    private static final long serialVersionUID = -2658676059456370329L;

    private final ApplicationController controler;
    
    private JLabel label_plateau = new JLabel("Plateau");
    private JLabel label_info = new JLabel("Info");
    
    private JButton quitter;

    public InfoView(ApplicationController controler) {
    	super("Puissance 4 - Vincent ROME");
        this.controler = controler;
        ViewsUtilities.setGeneralParameters(this);
        this.setBounds(150, 150, 150, 100);
        
        JPanel plateau = new JPanel();
        plateau.setLayout(new FlowLayout());
        plateau.add(label_plateau);
        
        JPanel info = new JPanel();
        info.setLayout(new FlowLayout());
        info.add(label_info);
        
        this.quitter = new JButton("Quitter");
        
        setLayout(new GridLayout(2,2));
        add(info);
        add(plateau);
        add(quitter);
        
        this.quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
    }

    public ApplicationController getControler() {
        return controler;
    }
    
   

}
