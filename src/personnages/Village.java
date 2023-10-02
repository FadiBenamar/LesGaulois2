package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum = 30;

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
//		Gaulois gaulois = village.trouverHabitant(1);
//		le tableau est definie de 0->29, 30 out of range
		Chef chef = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Un seul villageois asterix d'indice 0 qui a ete ajouter au tableau 
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(chef);
	}

	public void afficherVillageois(Chef chef) {
		System.out.println("Dans le village du chef" + chef.getNom() + "vivent les légendaires gaulois:\n");
		for (int i = 0; (i < villageois.length) && (villageois[i] != null); i++) {
			System.out.println(villageois[i]);
		}
	}

}
