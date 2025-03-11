package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Pioche {
	private static final int TAILLE_PIOCHE = 15;
	private Carte[] cartes = new Carte[TAILLE_PIOCHE];
	private int nbCarte = TAILLE_PIOCHE;
	private static SecureRandom random;
	private static final Carte[] CARTES = {
			new CartePopularite("Discours Inspirant", "Un discours motivant qui renforce la loyaute de l'equipage.", 1),
			new CartePopularite("Revolte Organisee", "Une mutinerie planifiee qui renforce la popularite du pirate.",
					1),
			new CartePopularite("Abordage Reussi", "Un abordage heroique qui impressionne l'equipage.", 2),
			new CarteAttaque("Coup de Sabre", "Un coup de sabre bien place qui affaiblit l'adversaire.", -2),
			new CarteDiffamation("Rebellion", -1), new CarteDiffamation("Blaspheme", -2), new CarteSoin("Grog", 1),
			new CarteSoin("Bandages", 2), new CarteFinal("Scorbut") };

	public Pioche() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < TAILLE_PIOCHE; i++) {
			cartes[i] = CARTES[random.nextInt(0, CARTES.length - 1)];
		}
	}

	public Carte piocher() {
		if (cartes[0] == null) {
			renouvelerPioche();
		}
		return retirerCarte(random.nextInt(0, nbCarte - 1));
	}

	public Main piocherMain() {
		int nbCarteMain = Main.getTailleMain();
		Carte[] cartes = new Carte[nbCarteMain];
		for (int i = 0; i < nbCarteMain - 1; i++) {
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
