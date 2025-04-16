package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
    private ZoneDeJeu zone;
    private MainJoueur main;

    public Joueur(String nom) {
        this.nom = nom;
        this.zone = new ZoneDeJeu();
        this.main = new MainJoueur();
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZone() {
        return zone;
    }

    public MainJoueur getMain() {
        return main;
    }

    public void donner(cartes.Carte carte) {
        main.prendre(carte);
    }

    @Override
    public String toString() {
        return nom;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Joueur) {
            Joueur joueur = (Joueur) obj;
            return nom.equals(joueur.nom);
        }
        return false;
    }
    
    public Carte prendreCarte(Sabot sabot) {
        if (sabot.estVide()) {
            return null;
        }
        Carte carte = sabot.piocher();
        this.main.prendre(carte);
        return carte;
    }
}
