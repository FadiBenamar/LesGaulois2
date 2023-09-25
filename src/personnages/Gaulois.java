package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public void frapper(Romain romain, int effetPotion) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est 6 fois décuplée. ");

	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("Romain", 9);
		Gaulois obélix = new Gaulois("Obélix", 25);
		System.out.println(asterix);
		asterix.parler("Bonjour");
		asterix.frapper(romain, 1);
		asterix.boirePotion(6);
	}
}
