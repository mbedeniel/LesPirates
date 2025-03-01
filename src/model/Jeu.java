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
		String[][] joueurParses = new String[NB_JOUEUR_MAX][];
		for(int i=0;i<NB_JOUEUR_MAX;i++) {
			joueurParses[i] = joueurs[i].parserJoueur();
		}
		affichage.afficherJoueurs(joueurParses);
		Carte carte = new Carte();
		Carte[] cartes;
		String[][] carteParses = new String[NB_CARTE_MAIN][];
		for (int i = 0; i <NB_CARTE_MAIN; i++) {
			cartes = carte.piocherCartes(NB_CARTE_MAIN);
			for(int j=0;j<NB_CARTE_MAIN;j++) {
				carteParses[j] = cartes[j].parserCarte();
			}
			affichage.piocherMain(carteParses, joueurParses[i][0]);
		}
		boolean aucunGagnant = true;
		String[] carteParse;
		int choixCarte;
		ZoneJeu zoneJeu;
//		do {
//			for (int i = 0; i < Affichage.getNbJoueurMax(); i++) {
//				affichage.afficherTour(joueurParses[i][0]);
//				carte = carte.piocherCarte();
//				carteParse = carte.parserCarte();
//				affichage.piocherCarte(carteParse, joueurParses[i][0]);
//				cartes = joueurs[i].recupererCartes();
//				carteParses = carte.parserCartes(cartes);
//				affichage.afficherCartes(carteParses);
//				choixCarte = affichage.choisirCarte(joueurParses[i][0]);
//				choixCarte--;
//				zoneJeu = joueurs[i].jouerCarte(choixCarte);
//				affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
//				affichage.afficherJoueurs(joueurParses);
//			}
//			aucunGagnant = avoirGagnant();
//		} while (aucunGagnant);
		
		for(int i=0;aucunGagnant;i=(i+1)%2) {
			affichage.afficherTour(joueurParses[i][0]);
			carte = carte.piocherCarte();
			carteParse = carte.parserCarte();
			affichage.piocherCarte(carteParse, joueurParses[i][0]);
			cartes = joueurs[i].recupererCartes();
			carteParses = new String[NB_CARTE_MAIN+1][];
			for(int j=0;j<NB_CARTE_MAIN+1;j++) {
				carteParses[j] = cartes[j].parserCarte();
			}
			affichage.afficherCartes(carteParses);
			choixCarte = affichage.choisirCarte(joueurParses[i][0]);
			choixCarte--;
			zoneJeu = joueurs[i].jouerCarte(choixCarte);
			affichage.jouerCarte(carteParses[choixCarte], joueurParses[i][0], zoneJeu);
			affichage.afficherJoueurs(joueurParses);
			aucunGagnant = avoirGagnant();
		}while(aucunGagnant);
		affichage.afficherGagnant(donnerGagnant());
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
