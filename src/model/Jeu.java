package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private IAffichage affichage = new Affichage();
	
	public void lancerJeux() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		Joueur joueur = new Joueur();
		Joueur[] joueurs = joueur.recupererJoueurs();
		String[][] joueurParses = joueur.parserJoueurs(joueurs);
		affichage.afficherJoueurs(joueurParses);
		Carte carte = new Carte();
		Carte[] cartes;
		String[][] carteParses;
		for (int i = 0; i < Affichage.getNbJoueurMax(); i++) {
			cartes = carte.piocherCartes(Affichage.getNbCarteMain());
			carteParses = carte.parserCartes(cartes);
			affichage.piocherMain(carteParses, joueurParses[i][0]);
		}
		boolean avoirGagne = false;
		String[] carteParse;
		int choixCarte;
		ZoneJeu zoneJeu;
		do {
			for (int i = 0; i < Affichage.getNbJoueurMax(); i++) {
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
			}
			avoirGagne = avoirGagnant();
		} while (!avoirGagne);
		affichage.afficherGagnant(donnerGagnant());
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
