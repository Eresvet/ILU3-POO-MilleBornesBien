package utils;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class GestionCartes {
	public static <T> T extraire(ArrayList<T> liste) {
		int indiceRandom = (int) Math.random() * liste.size() - 1;
		T  element = liste.get(indiceRandom);
		liste.remove(indiceRandom);
		
		return element;
	}
	
	public static <T> T extraireIT(ArrayList<T> liste) {
		Iterator<T> it = liste.iterator();
		int indiceRandom = (int) Math.random() * liste.size() - 1;
		T  element = liste.get(indiceRandom);
//		for (T e : liste)  { // pas juste indiceRandom car il faut dépasser l'elt
//			it.next();
//		}
		liste.forEach( (n) -> it.next());
		it.remove();
		return element;
	} 
	
	public static <T> ArrayList<T> melanger(ArrayList<T> liste) {
		ArrayList<T> nouvelle_liste = new ArrayList<T>(liste.size());
		for(int i = 0; i < liste.size(); i++) {
			nouvelle_liste.add(extraire(liste));
		}
		return nouvelle_liste;
	}
	
	public static <T> boolean verifierMelange(ArrayList<T> liste1, ArrayList<T> liste2) {
		if(liste1.size() != liste2.size()) {
			return false;
		}
		
		for(T elt : liste1) {
			if(Collections.frequency(liste1, elt) != Collections.frequency(liste2, elt)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> ArrayList<T> rassembler(ArrayList<T> liste){
		
	}
}
