package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int MIN_VIE = 0;
	private static final int MAX_POPULARITE = 5;
	private static final int NB_JOUEUR = 2;
	private static IAffichage affichage = new Affichage();
	private static Joueur[] joueurs = { new Joueur(Nom.BILL), new Joueur(Nom.JACK) };
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
			avoirProblem = jouer(joueurs[i]);
		}
		if (avoirProblem) {
			affichage.afficherProblem();
		} else {
			affichage.afficherGagnant(donnerGagnant());
		}
	}

	private boolean jouer(Joueur joueur) {
		boolean carteAjoute;
		affichage.afficherTour(joueur.donnerNom());
		Carte cartePioche = pioche.piocher();
		carteAjoute = joueur.ajouterCarte(cartePioche);
		if (carteAjoute) {
			affichage.piocherCarte(joueur.donnerNom());
			cartePioche.afficher(Main.getTailleMain());
			joueur.afficherMain();
			jouerCarte(joueur);
			afficherJoueur();
			return false;
		}
		return true;
	}

	private void jouerCarte(Joueur joueur) {
		int choixCarte = affichage.choisirCarte(joueur.donnerNom(), Main.getTailleMain());
		Carte carteJoue = joueur.recupererCarte(choixCarte);
		ZoneJeu zoneJeu = carteJoue.donnerZone();
		affichage.jouerCarte(joueur.donnerNom(), zoneJeu);
		carteJoue.jouerCarte(joueur, choixCarte);
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

	private boolean avoirGagnant() {
		for (int i = 0; i < NB_JOUEUR; i++) {
			if (joueurs[i].getVie() == MIN_VIE || joueurs[i].getPopularite() == MAX_POPULARITE) {
				return true;
			}
		}
		return false;
	}

	private String donnerGagnant() {
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

	public static Joueur recupererAdversaire(Joueur joueur) {
		if (joueur.equals(joueurs[0])) {
			return joueurs[1];
		}
		return joueurs[0];
	}

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.lancerJeu();
	}

}
