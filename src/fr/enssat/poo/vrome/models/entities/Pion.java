package fr.enssat.poo.vrome.models.entities;

public class Pion implements GameEntity {

    // Memorive the coordinates
    private int x;
    private int y;
    
    private PionColor color;

    public Pion(PionColor color) {
        this.color = color;
    }

    public PionColor getColor() {
        return color;
    }

    public void setColor(PionColor color) {
        this.color = color;
    }

    @Override
    public char getRepresentation() {
        return this.color.name().charAt(0);
    }
}
