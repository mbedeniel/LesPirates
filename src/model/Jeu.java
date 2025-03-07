package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int TAILLE_MAIN = 5;
	private static final int NB_JOUEUR = 2;
	private static final int TAILLE_PIOCHE = 15;
	private static IAffichage affichage = new Affichage();
	private Joueur[] joueurs = new Joueur[NB_JOUEUR];
	private Pioche pioche = new Pioche();
	
	
	
	public static IAffichage getAffichage() {
		return affichage;
	}
	
	public static int getTailleMain() {
		return TAILLE_MAIN;
	}

	public static int getNbJoueur() {
		return NB_JOUEUR;
	}
	
	public static int getTaillePioche() {
		return TAILLE_PIOCHE;
	}

	public void lancerJeux() {
		initialiser();
		gererTour();
		affichage.afficherGagnant(donnerGagnant());
	}

	private void gererTour() {
		for(int i=0;! avoirGagnant();i=(i+1)%NB_JOUEUR) {
			jouer(joueurs[i]);
		}
	}

	private void jouer(Joueur joueur) {
		boolean carteAjoute;
		Carte carte;
		int choixCarte;
		affichage.afficherTour(joueur.donnerNom());
		carte = pioche.piocher();
		carteAjoute = joueur.ajouterCarte(carte);
		if(carteAjoute) {
			affichage.piocherCarte(joueur.donnerNom());
			carte.afficher(TAILLE_MAIN);
			joueur.afficherMain();
			choixCarte = affichage.choisirCarte(joueur.donnerNom());
			affichage.jouerCarte(joueur.donnerNom(), carte.donnerZone());
			joueur.jouerCarte(choixCarte);
			for(int j = 0; j < NB_JOUEUR;j++) {
				joueurs[j].afficher();
			}
		}else {
			//TODO
		}
	}

	private void initialiser() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		for(int i = 0; i < NB_JOUEUR;i++) {
			joueurs[i].afficher();
			affichage.piocherMain(joueurs[i].donnerNom());
			joueurs[i].setMain(pioche.piocherMain());
			joueurs[i].afficherMain();
		}
	}

	public boolean avoirGagnant() {
		for(int i=0;i<NB_JOUEUR;i++) {
			if(joueurs[i].getVie() == 0 || joueurs[i].getPopularite() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public String donnerGagnant() {
		//TODO
		return null;
	}
	
}
