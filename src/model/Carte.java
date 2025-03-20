package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public abstract class Carte {
	protected String titre;
	protected String description;
	protected Jeu jeu;
	protected static IAffichage affichage = Jeu.getAffichage();

	protected Carte(String titre, String description, Jeu jeu) {
		this.titre = titre;
		this.description = description;
		this.jeu = jeu;
	}

	protected abstract void afficher(int numCarte);

	protected abstract ZoneJeu donnerZone();

	protected abstract void jouerCarte(Joueur joueur, int numCarte);

}
