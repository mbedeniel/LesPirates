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
			new CartePopularite("Recit Heroique", "Le pirate raconte ses exploits, captivant l'equipage.", 1),
			new CartePopularite("Festin du Capitaine", "Un grand banquet offert a l'equipage renforce la loyaute.", 2),
			new CartePopularite("Tresor Partage",
					"Le pirate distribue une partie de son butin pour gagner la faveur de l'equipage.", 3),
			new CartePopularite("Chant de la Mer", "Un chant entrainant unit l'equipage et renforce leur admiration.",
					2),
			new CarteAttaque("Coup de Sabre", "Un coup de sabre bien place qui affaiblit l'adversaire.", -2),
			new CarteAttaque("Coup de Poing", "Un violent coup de poing qui sonne l'adversaire.", -1),
			new CarteAttaque("Jet d'Encre", "L'adversaire est aveugle temporairement et perd l'equilibre.", -1),
			new CarteAttaque("Coup de Rame", "Un coup puissant avec une rame inflige des degats.", -2),
			new CarteAttaque("Explosion de Baril", "Un baril de poudre explose pres de l'adversaire.", -2),
			new CarteAttaque("Lame Empoisonnee", "Une blessure avec une lame enduite de poison affaiblit l'adversaire.",
					-3),
			new CarteAttaque("Boulet de Canon", "Un tir direct qui cause de lourds degats.", -3),
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
		nbCarte--;
		return retirerCarte(random.nextInt(0, nbCarte));
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
		cartes[nbCarte] = null;
		return carte;
	}

	public void renouvelerPioche() {
		Pioche pioche = new Pioche();
		cartes = pioche.cartes;
	}
}
