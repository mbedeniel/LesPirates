package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Pioche {
	private static final int TAILLE_PIOCHE = 15;
	private Carte[] cartes = new Carte[TAILLE_PIOCHE];
	private int nbCarte = TAILLE_PIOCHE;
	private static SecureRandom random;
	private static  Carte[] touteCartes = {new CartePopularite("B", "description", 2),new CarteAttaque("A", "description", 2),new CarteAttaque("B", "description", 6),new CartePopularite("C", "descrition", 2)};
	private static final CarteSpecial[] CARTE_SPECIALS = {new CarteDiffamation("Rebellion", -1),new CarteDiffamation("Blaspheme", -2),new CarteSoin("Grog", 1),new CarteSoin("Bandages", 2), new CarteFinal("Scorbut")};
	private static final CarteAttaque[] CARTE_ATTAQUES = {};
	private static final CartePopularite[] CARTE_POPULARITES = {};
	
	public Pioche() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for(int i=0;i<TAILLE_PIOCHE;i++) {
			cartes[i] = touteCartes[random.nextInt(0, touteCartes.length - 1)];
		}
	}

	public Carte piocher() {
		if(cartes[0]==null) {
			renouvelerPioche();
		}
		return retirerCarte(random.nextInt(0, nbCarte - 1));
	}

	public Main piocherMain() {
		int nbCarteMain = Main.getTailleMain();
		Carte[] cartes = new Carte[nbCarteMain];
		for (int i = 0; i < nbCarteMain-1; i++) {
			cartes[i] = piocher();
		}
		return new Main(cartes);
	}

	public Carte retirerCarte(int indice) {
		Carte carte = cartes[indice];
		for (int i = indice; i < cartes.length - 1; i++) {
			cartes[indice] = cartes[indice + 1];
		}
		cartes[nbCarte - 1] = null;
		nbCarte--;
		return carte;
	}
	
	public void renouvelerPioche() {
		Pioche pioche = new Pioche();
		cartes = pioche.cartes;
	}
}
