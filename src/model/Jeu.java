package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private final int MIN_VIE = 0;
	private final int MAX_VIE = 5;
	private final int MAX_POPULARITE = 5;
	private final int MIN_POPULARITE = 0;
	private final int NB_JOUEUR = 2;
	private final Joueur[] joueurs = { new Joueur(Nom.BILL, this), new Joueur(Nom.JACK, this) };
	private Pioche pioche = new Pioche(this);
	private static IAffichage affichage = new Affichage();

	public static IAffichage getAffichage() {
		return affichage;
	}

	public int getNB_JOUEUR() {
		return NB_JOUEUR;
	}

	public int getMIN_VIE() {
		return MIN_VIE;
	}

	public int getMAX_VIE() {
		return MAX_VIE;
	}

	public int getMAX_POPULARITE() {
		return MAX_POPULARITE;
	}

	public int getMIN_POPULARITE() {
		return MIN_POPULARITE;
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
			cartePioche.afficher(joueur.recupererTailleMain());
			joueur.afficherMain();
			jouerCarte(joueur);
			afficherJoueur();
			return false;
		}
		return true;
	}

	private void jouerCarte(Joueur joueur) {
		int choixCarte = affichage.choisirCarte(joueur.donnerNom(), joueur.recupererNbCarte());
		Carte carteJoue = joueur.recupererCarte(choixCarte);
		ZoneJeu zoneJeu = carteJoue.donnerZone();
		affichage.jouerCarte(joueur.donnerNom(), zoneJeu);
		carteJoue.jouerCarte(joueur, choixCarte);
	}

	private void afficherJoueur() {
		affichage.afficherJoueurs();
		Joueur joueur;
		for (int i = 0; i < NB_JOUEUR; i++) {
			joueur = joueurs[i];
			joueur.afficher();
		}
	}

	private void initialiser() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		afficherJoueur();
		for (int i = 0; i < NB_JOUEUR; i++) {
			affichage.piocherMain(joueurs[i].donnerNom(), joueurs[i].recupererTailleMain() - 1);
			joueurs[i].setMain(pioche.piocherMain(joueurs[i].recupererTailleMain()));
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

	public Joueur recupererAdversaire(Joueur joueur) {
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
