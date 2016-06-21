package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.PionColor;

public class Player {

    private String name;
    private PionColor pionColor;

    public Player(String name, PionColor pionColor) {
        this.name = name;
        this.pionColor = pionColor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PionColor getPionColor() {
        return this.pionColor;
    }

    public void setPionColor(PionColor pionColor) {
        this.pionColor = pionColor;
    }

}
