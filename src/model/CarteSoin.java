package model;

public class CarteSoin extends CarteSpecial {

	private int vie;

	public CarteSoin(String titre, int vie) {
		super(titre, "rajoute de la vie au joueur");
		this.vie = vie;
	}

	public int getVie() {
		return vie;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre, description, vie, numCarte);
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		joueur.modifierVie(vie);
	}

}
