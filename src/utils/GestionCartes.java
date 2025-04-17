package utils;
import java.util.Collections;
import java.util.Random;
import java.util.ListIterator;
import java.util.ArrayList;


public class GestionCartes {
	// final ?
	private GestionCartes() {
	}
	
	public static <T> T extraire(ArrayList<T> liste) {
		Random rand = new Random();
		int indiceRandom = rand.nextInt(liste.size());
		T  element = liste.get(indiceRandom);
		liste.remove(indiceRandom);
		
		return element;
	}
	
	public static <T> T extraireIT(ArrayList<T> liste) {
		Random rand = new Random();
		int indiceRandom = rand.nextInt(liste.size());
		
		ListIterator<T> it = liste.listIterator(indiceRandom);
			T current = it.next();
			it.remove();
		
		
		return current;
	} 
	
	public static <T> ArrayList<T> melanger(ArrayList<T> liste) {
		ArrayList<T> nouvelle_liste = new ArrayList<T>(liste.size());
		while (!liste.isEmpty()) {
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
	    ArrayList<T> resultat = new ArrayList<>();
        
        for (ListIterator<T> it = liste.listIterator();it.hasNext();) {
            T elt = it.next();
            
            if (!resultat.contains(elt)) {
                for(int i = 0; i < Collections.frequency(liste, elt); i++) {
                	resultat.add(elt);
                }
            }
        }
        
        return resultat;
	}
	
	public static <T> boolean verifierSuite(T courant, T valPrec, ListIterator<T> it, ArrayList<T> liste) {
		ListIterator<T> it2 = liste.listIterator(it.nextIndex());
        while (it2.hasNext()) {
            if (valPrec.equals(it2.next())) {
                return false;
            }
        }
        valPrec = courant;
        return true;
	}
	
	public static <T> boolean verifierRassemblement(ArrayList<T> liste) {
		boolean verifier = true;
		if (liste.size() <= 1) {
	        return verifier;
	    }

	    ListIterator<T> it1 = liste.listIterator();
	    T valPrec = it1.next();

	    while (it1.hasNext()) {
	        T courant = it1.next();
	        
	        verifier = verifierSuite(courant, valPrec, it1, liste);
	    }

	    return verifier;
	}
}
