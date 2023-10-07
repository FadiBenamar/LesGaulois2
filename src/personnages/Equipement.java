package personnages;

public enum Equipement {
	C("Casque"), B("Bouclier");
	private String nom;
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}

}
