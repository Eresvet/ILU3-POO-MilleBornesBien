package utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

public class GestionCartes {
	public static <T> T extraire(ArrayList<T> liste) {
		int indiceRandom = (int) (Math.random() * liste.size());
		T  element = liste.get(indiceRandom);
		liste.remove(indiceRandom);
		
		return element;
	}
	
	public static <T> T extraireIT(ArrayList<T> liste) {
		Iterator<T> it = liste.iterator();
		int indiceRandom = (int) (Math.random() * liste.size());
		T  element = null;
		for (int i = 0; it.hasNext(); i++){
			T current = it.next();
			if(i == indiceRandom) {
				element = current;
				it.remove();
				break;
			}
		}
		return element;
	} 
	
	public static <T> ArrayList<T> melanger(ArrayList<T> liste) {
		ArrayList<T> nouvelle_liste = new ArrayList<T>(liste.size());
		int taille_list_init = liste.size()
;		for(int i = 0; i < taille_list_init; i++) {
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
		HashMap<T, ArrayList<T>> groupes = new HashMap<>();

	    for (T elt : liste) {
	        groupes.computeIfAbsent(elt, k -> new ArrayList<>()).add(elt); //si la clé elt existe dans map, renvoie sa valeur existante
	        //sinon crée une liste vite, associe elt dans le Hashmap et renvoie la nouvelle liste
	    }

	    ArrayList<T> resultat = new ArrayList<>(liste.size());
	    for (ArrayList<T> groupe : groupes.values()) {
	        resultat.addAll(groupe); //rassemble les groupes dans une même liste
	    }

	    return resultat;
	}
	
	public static <T> boolean verifierRassemblement(ArrayList<T> liste) {
		if (liste.size() <= 1) {
	        return true;
	    }

	    ListIterator<T> it1 = liste.listIterator();
	    T valPrec = it1.next();

	    while (it1.hasNext()) {
	        T courant = it1.next();
	        
	        if (!courant.equals(valPrec)) {
	            ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
	            while (it2.hasNext()) {
	                if (valPrec.equals(it2.next())) {
	                    return false;
	                }
	            }
	            valPrec = courant;
	        }
	    }

	    return true;
	}
}
