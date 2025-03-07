package model;

import affichage.ZoneJeu;

public abstract class Carte {
	protected String titre;
	protected String description;
	
	protected Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}
	

	protected abstract void afficher(int numCarte);
	
	protected abstract ZoneJeu donnerZone();










	public Carte[] piocherCartes(int nbCarte) {
		//TODO
		return null;
	}
	public Carte piocherCarte() {
		//TODO
		return null;
	}
	public String[] parserCarte() {
		//TODO
		return null;
	}
	public String[][] parserCartes(Carte[] cartes) {
		//TODO
		return null;
	}
}
