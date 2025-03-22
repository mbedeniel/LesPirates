package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public abstract class Carte {
	protected String titre;
	protected String description;
	protected static IAffichage affichage = Jeu.getAffichage();

	protected Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}

	protected abstract void afficher(int numCarte);

	protected abstract ZoneJeu donnerZone();

	protected abstract void jouerCarte(Joueur joueur, int numCarte);

}
