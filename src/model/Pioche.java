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
//			new CartePopularite("Discours Inspirant", "Un discours motivant qui renforce la loyaute de l'equipage.", 1),
//			new CartePopularite("Revolte Organisee", "Une mutinerie planifiee qui renforce la popularite du pirate.",
//					1),
//			new CartePopularite("Abordage Reussi", "Un abordage heroique qui impressionne l'equipage.", 2),
//			new CartePopularite("Recit Heroique", "Le pirate raconte ses exploits, captivant l'equipage.", 1),
//			new CartePopularite("Festin du Capitaine", "Un grand banquet offert a l'equipage renforce la loyaute.", 2),
//			new CartePopularite("Tresor Partage",
//					"Le pirate distribue une partie de son butin pour gagner la faveur de l'equipage.", 3),
//			new CartePopularite("Chant de la Mer", "Un chant entrainant unit l'equipage et renforce leur admiration.",
//					2),
//			new CartePopularite("Raid Audacieux", "Attaque surprise et fructueuse, butin et admiration.", 3),
//			new CarteAttaque("Coup de Sabre", "Un coup de sabre bien place qui affaiblit l'adversaire.", -2),
//			new CarteAttaque("Coup de Poing", "Un violent coup de poing qui sonne l'adversaire.", -1),
//			new CarteAttaque("Jet d'Encre", "L'adversaire est aveugle temporairement et perd l'equilibre.", -1),
//			new CarteAttaque("Coup de Rame", "Un coup puissant avec une rame inflige des degats.", -2),
//			new CarteAttaque("Explosion de Baril", "Un baril de poudre explose pres de l'adversaire.", -2),
//			new CarteAttaque("Lame Empoisonnee", "Une blessure avec une lame enduite de poison affaiblit l'adversaire.",
//					-3),
//			new CarteAttaque("Boulet de Canon", "Un tir direct qui cause de lourds degats.", -3),
//			new CarteAttaque("Tempête de Lames", "Coups de sabre rapides, confusion et blessures.", -2),
//			new CarteDiffamation("Rebellion", -1), new CarteDiffamation("Blaspheme", -2), new CarteSoin("Grog", 1),
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
