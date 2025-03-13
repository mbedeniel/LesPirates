package model;

public class CartePermutation extends CarteSpecial {

	public CartePermutation(String titre, String description) {
		super(titre, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void afficher(int numCarte) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		//TODO
		afficher(numCarte);
	}

}
