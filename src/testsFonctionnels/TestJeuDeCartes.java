package testsFonctionnels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestJeuDeCartes {
	
	public static <T> boolean testerConservationElements(List<T> listeOriginale, List<T> listeTestee) {
	    if (listeOriginale.size() != listeTestee.size()) return false;

	    for (T elt : listeOriginale) {
	        if (Collections.frequency(listeOriginale, elt) != Collections.frequency(listeTestee, elt)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageJeuCartes());
		
        if (!jeu.checkCount()) {
            System.out.println("erreur de nombre");
        }
        
        ArrayList<Carte> listeCarteNonMelangee = new ArrayList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }
        ArrayList<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

        System.out.println("Avant m�lange :");
        System.out.println(listeCartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        System.out.println("Apr�s m�lange :");
        System.out.println(listeCartes);

        System.out.println("Liste m�lang�e sans erreur ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        System.out.println("�l�ments conserv�s ? "
                + testerConservationElements(listeCarteNonMelangee, listeCartes));

        listeCartes = GestionCartes.rassembler(listeCartes);

        System.out.println("Apr�s rassemblement :");
        System.out.println(listeCartes);

        System.out.println("Liste rassembl�e sans erreur ? "
                + GestionCartes.verifierRassemblement(listeCartes));

        System.out.println("�l�ments toujours conserv�s ? "
                + testerConservationElements(listeCarteNonMelangee, listeCartes));

	}
}