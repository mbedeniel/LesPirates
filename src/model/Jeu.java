package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int NB_CARTE_MAIN = 4;
	private static final int NB_JOUEUR = 2;
	private static final int NB_CARTE_TOTAL = 15;
	private static IAffichage affichage = new Affichage();
	private Joueur[] joueurs = new Joueur[NB_JOUEUR];
	private Pioche pioche = new Pioche();
	
	
	
	public static IAffichage getAffichage() {
		return affichage;
	}

	public void lancerJeux() {
		afficherDepart();
		Carte carte = new Carte();
		Carte[] cartes;
		String[][] carteParses;
		for (int i = 0; i <NB_JOUEUR; i++) {
			for(int j=0;j<NB_CARTE_MAIN;j++) {
				joueurs[i].setMain(pioche.piocherMain());
			}
			cartes = carte.piocherCartes(NB_CARTE_MAIN);
			carteParses = carte.parserCartes(cartes);
			affichage.piocherMain(carteParses, joueurParses[i][0]);
		}
		boolean aucunGagnant = true;
		String[] carteParse;
		int choixCarte;
		ZoneJeu zoneJeu;
		int i=0;
		do {
			affichage.afficherTour(joueurParses[i][0]);
			carte = carte.piocherCarte();
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

	private void afficherDepart() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		for(int i = 0; i < NB_JOUEUR;i++) {
			joueurs[i].afficher();
		}
	}
	
	public static int getNbCarteMain() {
		return NB_CARTE_MAIN;
	}

	public static int getNbJoueurMax() {
		return NB_JOUEUR;
	}
	
	public static int getNbCarteTotal() {
		return NB_CARTE_TOTAL;
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
