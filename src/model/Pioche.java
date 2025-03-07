package model;

public class Pioche {
	private Carte[] cartes = new Carte[Jeu.getTaillePioche()];
	public Carte piocher() {
		//TODO piocher doit se servir dans cartes[]
		return null;
	}
	public Main piocherMain() {
		int nbCarteMain = Jeu.getTailleMain()-1;
		Carte[] cartes = new Carte[nbCarteMain];
		for(int i=0;i<nbCarteMain;i++) {
			cartes[i] = piocher();
		}
		return new Main(cartes);
	}
}
