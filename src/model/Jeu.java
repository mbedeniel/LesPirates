package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private static final int NB_CARTE_MAIN = 4;
	private static final int NB_JOUEUR_MAX = 2;
	private IAffichage affichage = new Affichage();
	private Joueur[] joueurs = new Joueur[NB_JOUEUR_MAX];
	
	public void lancerJeux() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		Joueur joueur = new Joueur();
		String[][] joueurParses = joueur.parserJoueurs(joueurs);
		affichage.afficherJoueurs(joueurParses);
		Carte carte = new Carte();
		Carte[] cartes;
		String[][] carteParses;
		for (int i = 0; i <NB_JOUEUR_MAX; i++) {
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
			cartes = joueurs[i].recupererCartes();
			carteParses = carte.parserCartes(cartes);
			affichage.afficherCartes(carteParses);
			choixCarte = affichage.choisirCarte(joueurParses[i][0]);
			choixCarte--;
			zoneJeu = joueurs[i].jouerCarte(choixCarte);
			affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
			affichage.afficherJoueurs(joueurParses);
			i=(i+1)%NB_JOUEUR_MAX;
			aucunGagnant = avoirGagnant();
		}while(aucunGagnant);
		affichage.afficherGagnant(donnerGagnant());
		
//		do {
//			for (int i = 0; i < NB_JOUEUR_MAX; i++) {
//				if(aucunGagnant) {
//					affichage.afficherTour(joueurParses[i][0]);
//					carte = carte.piocherCarte();
//					carteParse = carte.parserCarte();
//					affichage.piocherCarte(carteParse, joueurParses[i][0]);
//					cartes = joueurs[i].recupererCartes();
//					carteParses = carte.parserCartes(cartes);
//					affichage.afficherCartes(carteParses);
//					choixCarte = affichage.choisirCarte(joueurParses[i][0]);
//					choixCarte--;
//					zoneJeu = joueurs[i].jouerCarte(choixCarte);
//					affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
//					affichage.afficherJoueurs(joueurParses);
//					aucunGagnant = avoirGagnant();
//				}
//			}
//		} while (aucunGagnant);
		
//		for(int i=0;aucunGagnant;i=(i+1)%NB_JOUEUR_MAX) {
//			affichage.afficherTour(joueurParses[i][0]);
//			carte = carte.piocherCarte();
//			carteParse = carte.parserCarte();
//			affichage.piocherCarte(carteParse, joueurParses[i][0]);
//			cartes = joueurs[i].recupererCartes();
//			carteParses = carte.parserCartes(cartes);
//			affichage.afficherCartes(carteParses);
//			choixCarte = affichage.choisirCarte(joueurParses[i][0]);
//			choixCarte--;
//			zoneJeu = joueurs[i].jouerCarte(choixCarte);
//			affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
//			affichage.afficherJoueurs(joueurParses);
//			aucunGagnant = avoirGagnant();
//		}
	}
	
	public static int getNbCarteMain() {
		return NB_CARTE_MAIN;
	}

	public static int getNbJoueurMax() {
		return NB_JOUEUR_MAX;
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
