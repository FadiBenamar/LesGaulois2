package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	int nbEquipement = 0;
	private String texte;

	public Romain(Equipement equipement, String nom, int force) {
		assert force >= 0 : "la force d’un Romain est toujours positive\n";
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force >= 0 : "la force d’un Romain est positive\n";
//		int nouvelleForce = force - forceCoup;
//		if (nouvelleForce > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert nouvelleForce < force : "la force d’un Romain a diminué\n";
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
//		if (!(nbEquipement == 0)) {
//			texte += "\nMais heureusement, grace à mon équipement saforce est diminué de ";
//			for (int i = 0; i < nbEquipement;) {
////					if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
////						resistanceEquipement += 8;
////					} else {
////						System.out.println("Equipement casque");
////						resistanceEquipement += 5;
////					}
////					i++;
//			}
//			texte = +resistanceEquipement + "!";
//		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain romain = new Romain(Equipement.C, "Minus", 6);
		romain.recevoirCoup(11);
		romain.sEquiper(Equipement.C);
		romain.sEquiper(Equipement.C);
		romain.sEquiper(Equipement.B);
		romain.sEquiper(Equipement.C);
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;

		default:
			break;
		}
	}

	public void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

}
