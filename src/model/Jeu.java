package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int NB_JOUEUR = 2;
	private static IAffichage affichage = new Affichage();
	private Joueur[] joueurs = {new Joueur(Nom.BILL),new Joueur(Nom.JACK)};
	private Pioche pioche = new Pioche();

	public static IAffichage getAffichage() {
		return affichage;
	}
	
	public static int getNbJoueur() {
		return NB_JOUEUR;
	}

	public void lancerJeux() {
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
		int choixCarte;
		affichage.afficherTour(joueur.donnerNom());
		carte = pioche.piocher();
		ZoneJeu zoneJeu;
		carteAjoute = joueur.ajouterCarte(carte);
		if (carteAjoute) {
			affichage.piocherCarte(joueur.donnerNom());
			carte.afficher(Main.getTailleMain());
			joueur.afficherMain();
			choixCarte = affichage.choisirCarte(joueur.donnerNom());
			zoneJeu = carte.donnerZone();
			affichage.jouerCarte(joueur.donnerNom(), zoneJeu);
			switch (zoneJeu) {
				case ATTAQUE: {
					joueur.jouerCarteAttaque(adversaire, choixCarte);
					break;
				}
				case POPULARITE: {
					joueur.jouerCartePopularite(choixCarte);
					break;
				}
			}
			afficherJoueur();
			return false;
		}
		return true;
	}

	private void afficherJoueur() {
		affichage.afficherJoueurs();
		for (int j = 0; j < NB_JOUEUR; j++) {
			joueurs[j].afficher();
		}
	}

	private void initialiser() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		afficherJoueur();
		for (int i = 0; i < NB_JOUEUR; i++) {
			affichage.piocherMain(joueurs[i].donnerNom());
			joueurs[i].setMain(pioche.piocherMain());
			joueurs[i].afficherMain();
		}
	}

	public boolean avoirGagnant() {
		for (int i = 0; i < NB_JOUEUR; i++) {
			if (joueurs[i].getVie() == 0 || joueurs[i].getPopularite() == 5) {
				return true;
			}
		}
		return false;
	}

	public String donnerGagnant() {
		for (int i = 0; i < NB_JOUEUR; i++) {
			if (joueurs[i].getVie() == 0) {
				return joueurs[(i + 1)%NB_JOUEUR].donnerNom();
			}
			if(joueurs[i].getPopularite() == 5) {
				return joueurs[i].donnerNom();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.lancerJeux();
	}

}
