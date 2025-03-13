package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import affichage.IAffichage;

public class Pioche {
	private static final int TAILLE_PIOCHE = 15;
	private Carte[] cartes = new Carte[TAILLE_PIOCHE];
	private int nbCarte = TAILLE_PIOCHE;
	private static SecureRandom random;
	private static IAffichage affichage = Jeu.getAffichage();
	private static final Carte[] TOUTE_CARTES = {

			new CarteSoin("Bandages", 2), new CarteFinal("Scorbut"), new CartePermutation("New chance") };

	public Pioche() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < TAILLE_PIOCHE; i++) {
			cartes[i] = TOUTE_CARTES[random.nextInt(0, TOUTE_CARTES.length)];
		}
	}

	public Carte piocher() {
		if (cartes[0] == null) {
			renouvelerPioche();
		}
		nbCarte--;
		if (nbCarte != 0) {
			return retirerCarte(random.nextInt(0, nbCarte));
		} else {
			return retirerCarte(nbCarte);
		}
	}

	public Main piocherMain() {
		int nbCarteMain = Main.getTailleMain();
		Carte[] mainCartes = new Carte[nbCarteMain];
		for (int i = 0; i < nbCarteMain - 1; i++) {
			mainCartes[i] = piocher();
		}
		return new Main(mainCartes);
	}

	public Carte retirerCarte(int indice) {
		Carte carte = cartes[indice];
		for (int i = indice; i < cartes.length - 1; i++) {
			cartes[indice] = cartes[indice + 1];
		}
		cartes[nbCarte] = null;
		return carte;
	}

	public void renouvelerPioche() {
		affichage.renouvelerPioche();
		Pioche pioche = new Pioche();
		cartes = pioche.cartes;
		nbCarte = TAILLE_PIOCHE;
	}
}
