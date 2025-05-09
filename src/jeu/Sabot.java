package jeu;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.ArrayIndexOutOfBoundsException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] cartes;
	private int nbCartes = 0;
	private int nombreOperations = 0;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		try {
            if (nbCartes < cartes.length) {
                cartes[nbCartes] = carte;
                nbCartes++;
                nombreOperations++;
                System.out.println("Carte ajoute : " + carte);
            } else {
                throw new ArrayIndexOutOfBoundsException("Le tableau est plein");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();;
        }
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte piochee = it.next();
		it.remove();
		return piochee;
	}
	
	@Override
	 public Iterator<Carte> iterator() {
		return new Iterateur();
	 }
	
	 private class Iterateur implements Iterator<Carte> {
		 private int indiceIterateur = 0;
		 private boolean nextEffectue = false;
		 private int nombreOperationsReference = nombreOperations;
		 
		 @Override
		 public boolean hasNext() {
			 return indiceIterateur < nbCartes; 
		 }
		 
		 @Override
		 public Carte next() {
			 verificationConcurrence();
			 if(hasNext()) {
				 Carte carte = cartes[indiceIterateur];
				 indiceIterateur ++;
				 nextEffectue = true;
				 return carte;
			 } else {
				 throw new NoSuchElementException();
			 }
		 }
		 
		 @Override
		 public void remove() {
			 if(nbCartes < 1 || !nextEffectue) {
				 throw new IllegalStateException();
			 }
			 for(int i = indiceIterateur -1; i < nbCartes - 1; i++) {
				 cartes[i] = cartes[i+1];
			 }
			 nextEffectue = false;
			 indiceIterateur--;
			 nbCartes--;
			 nombreOperationsReference++;
			 nombreOperations++;
		 }
		 
		 private void verificationConcurrence() {
			 if(nombreOperations != nombreOperationsReference) {
				 throw new ConcurrentModificationException();
			 }
		 }
	 }
	
	
}
