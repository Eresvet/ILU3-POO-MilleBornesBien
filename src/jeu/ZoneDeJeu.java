package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.Borne;
import cartes.Carte;

public class ZoneDeJeu {
	private List<Carte> pileLimites;
    private List<Carte> pileBataille;
    private List<Borne> bornes;

    public ZoneDeJeu() {
        this.pileLimites = new ArrayList<>();
        this.pileBataille = new ArrayList<>();
        this.bornes = new ArrayList<>();
    }

    public List<Carte> getPileLimites() {
        return pileLimites;
    }

    public List<Carte> getPileBataille() {
        return pileBataille;
    }

    public List<Borne> getBornes() {
        return bornes;
    }
}
