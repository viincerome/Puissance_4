package fr.enssat.poo.vrome.models;

import fr.enssat.poo.vrome.models.entities.PionColor;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private PionColor pionColor;

    /**
     * The score of a player is the total number of games won.
     */
    private int score;

    public Player(String name, PionColor pionColor) {
        this.name = name;
        this.pionColor = pionColor;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
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
