package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int MIN_VIE = 0;
	private static final int MAX_POPULARITE = 5;
	private static final int NB_JOUEUR = 2;
	private static IAffichage affichage = new Affichage();
	private Joueur[] joueurs = { new Joueur(Nom.BILL), new Joueur(Nom.JACK) };
	private Pioche pioche = new Pioche();

	public static IAffichage getAffichage() {
		return affichage;
	}

	public static int getNbJoueur() {
		return NB_JOUEUR;
	}

	public void lancerJeu() {
		initialiser();
		gererJeu();
	}

	private void gererJeu() {
		boolean avoirProblem = true;
		for (int i = 0; !avoirGagnant(); i = (i + 1) % NB_JOUEUR) {
			avoirProblem = jouer(joueurs[i], joueurs[(i + 1) % NB_JOUEUR]);
		}
		if (avoirProblem) {
			affichage.afficherProblem();
		} else {
			affichage.afficherGagnant(donnerGagnant());
		}
	}

	private boolean jouer(Joueur joueur, Joueur adversaire) {
		boolean carteAjoute;
		Carte carte;
		affichage.afficherTour(joueur.donnerNom());
		carte = pioche.piocher();
		carteAjoute = joueur.ajouterCarte(carte);
		if (carteAjoute) {
			affichage.piocherCarte(joueur.donnerNom());
			carte.afficher(Main.getTailleMain());
			joueur.afficherMain();
			jouerCarte(joueur, adversaire, carte);
			afficherJoueur();
			return false;
		}
		return true;
	}

	private void jouerCarte(Joueur joueur, Joueur adversaire, Carte carte) {
		int choixCarte = affichage.choisirCarte(joueur.donnerNom(), Main.getTailleMain());
		ZoneJeu zoneJeu = carte.donnerZone();
		affichage.jouerCarte(joueur.donnerNom(), zoneJeu);
		switch (zoneJeu) {
		case ATTAQUE: {
			joueur.jouerAttaque(adversaire, choixCarte);
			break;
		}
		case POPULARITE: {
			joueur.jouerPopularite(choixCarte);
			break;
		}
		case SPECIAL: {
			jouerSpecial(joueur, adversaire, carte, choixCarte);
			break;
		}
		}
	}

	private void jouerSpecial(Joueur joueur, Joueur adversaire, Carte carte, int choixCarte) {
		if (carte instanceof CarteDiffamation) {
			joueur.jouerDiffamation(adversaire, choixCarte);
		} else if (carte instanceof CarteSoin) {
			joueur.jouerSoin(choixCarte);
		} else {
			joueur.jouerFinal(adversaire, choixCarte);
		}
	}

	private void afficherJoueur() {
		affichage.afficherJoueurs();
		for (int i = 0; i < NB_JOUEUR; i++) {
			joueurs[i].afficher();
		}
	}

	private void initialiser() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		afficherJoueur();
		for (int i = 0; i < NB_JOUEUR; i++) {
			affichage.piocherMain(joueurs[i].donnerNom(), Main.getTailleMain() - 1);
			joueurs[i].setMain(pioche.piocherMain());
			joueurs[i].afficherMain();
		}
	}

	public boolean avoirGagnant() {
		for (int i = 0; i < NB_JOUEUR; i++) {
			if (joueurs[i].getVie() == MIN_VIE || joueurs[i].getPopularite() == MAX_POPULARITE) {
				return true;
			}
		}
		return false;
	}

	public String donnerGagnant() {
		for (int i = 0; i < NB_JOUEUR; i++) {
			if (joueurs[i].getVie() == MIN_VIE) {
				return joueurs[(i + 1) % NB_JOUEUR].donnerNom();
			}
			if (joueurs[i].getPopularite() == MAX_POPULARITE) {
				return joueurs[i].donnerNom();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.lancerJeu();
	}

}
