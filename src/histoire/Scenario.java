package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		Gaulois obélix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		
		panoramix.parler(" Je vais aller préparer une petite potion...");
		panoramix.preparerPotion(5, 10);
		panoramix.booster(obélix);
		obélix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.boirePotion(6);
		
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus, 1);
		asterix.frapper(minus, 1);
		asterix.frapper(minus, 1);
	}

}
