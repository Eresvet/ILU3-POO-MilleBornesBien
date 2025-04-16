package jeu;

import java.util.ArrayList;
import java.util.Collections;
import utils.GestionCartes;
import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
	private Sabot sabot;

    public Jeu() {
        Carte[] cartes = new JeuDeCartes().donnerCartes();

        ArrayList<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);

        this.sabot = new Sabot(cartesMelangees);
    }
    
    public Sabot getSabot() {
        return sabot;
    }
}
