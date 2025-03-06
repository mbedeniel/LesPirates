package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int TAILLE_MAIN = 4;
	private static final int NB_JOUEUR = 2;
	private static final int TAILLE_PIOCHE = 15;
	private static IAffichage affichage = new Affichage();
	private Joueur[] joueurs = new Joueur[NB_JOUEUR];
	private Pioche pioche = new Pioche();
	
	
	
	public static IAffichage getAffichage() {
		return affichage;
	}

	public void lancerJeux() {
		initialiser();
		boolean aucunGagnant = true;
		String[] carteParse;
		int choixCarte;
		ZoneJeu zoneJeu;
		int i=0;
		do {
			affichage.afficherTour(joueurs[i].donnerNom());
			joueurs[i].ajouterCarte(pioche.piocher());
			carteParse = carte.parserCarte();
			affichage.piocherCarte(carteParse, joueurParses[i][0]);
			joueur = joueurs[i];
			cartes = joueur.recupererCartes();
			carteParses = carte.parserCartes(cartes);
			affichage.afficherCartes(carteParses);
			choixCarte = affichage.choisirCarte(joueurParses[i][0]);
			choixCarte--;
			zoneJeu = joueur.jouerCarte(choixCarte);
			affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
			affichage.afficherJoueurs(joueurParses);
			i=(i+1)%NB_JOUEUR;
			aucunGagnant = avoirGagnant();
		}while(aucunGagnant);
		String nomGagnant = donnerGagnant();
		affichage.afficherGagnant(nomGagnant);
	}

	private void initialiser() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		for(int i = 0; i < NB_JOUEUR;i++) {
			joueurs[i].afficher();
			joueurs[i].setMain(pioche.piocherMain());
			joueurs[i].afficherMain();
		}
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

	public boolean avoirGagnant() {
		//TODO
		return false;
	}
	
	public String donnerGagnant() {
		//TODO
		return null;
	}
	
}
