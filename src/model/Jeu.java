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
		boolean aucunGagnant = true;
		boolean carteAjoute;
		Carte carte;
		String[] carteParse;
		int choixCarte;
		ZoneJeu zoneJeu;
		int i=0;
		Joueur joueur;
		do {
			joueur = joueurs[i];
			affichage.afficherTour(joueur.donnerNom());
			carte = pioche.piocher();
			carteAjoute = joueur.ajouterCarte(carte);
			if(carteAjoute) {
				affichage.piocherCarte(joueur.donnerNom());
				carte.afficher(TAILLE_MAIN);
				joueur.afficherMain();
				choixCarte = affichage.choisirCarte(joueur.donnerNom());
				joueur.jouerCarte(choixCarte);
				zoneJeu = carte.donnerZone();
				affichage.jouerCarte(joueur.donnerNom(), zoneJeu);
				for(int j = 0; j < NB_JOUEUR;j++) {
					joueurs[j].afficher();
				}
				i=(i+1)%NB_JOUEUR;
				aucunGagnant = avoirGagnant();
			}
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
			affichage.piocherMain(joueurs[i].donnerNom());
			joueurs[i].setMain(pioche.piocherMain());
			joueurs[i].afficherMain();
		}
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
