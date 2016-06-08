package fr.enssat.poo.vrome.models.entities;

public class Pion implements GameEntity {

    // Memorive the coordinates
    private Integer x; // Default null on initialisation
    private Integer y;
    
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
   
    public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
    public char getRepresentation() {
        return this.color.name().charAt(0);
    }
}
