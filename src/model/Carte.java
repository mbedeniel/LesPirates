package model;

public abstract class Carte {
	protected String titre;
	protected String description;
	
	public abstract void afficher();
	
	protected Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}










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
