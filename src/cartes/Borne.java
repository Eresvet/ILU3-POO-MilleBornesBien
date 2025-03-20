package cartes;

public class Borne extends Carte {
	private Integer km;
	
	public Borne(Integer km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km.equals(borne.km) && super.equals(obj);
		}
		return  false;
	}

}
