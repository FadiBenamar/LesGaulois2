package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;

	public Village(String nom) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois];
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles");
		Gaulois gaulois = village.trouverHabitant(1);
//		Chef chef = new Chef("Abraracourcix", 6, village);
//		Gaulois asterix = new Gaulois("Astérix", 8);
//		Gaulois gaulois1 = village.trouverHabitant(1);
//		System.out.println(gaulois);

	}


}
