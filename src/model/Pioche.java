package model;

public class Pioche {
	private Carte[] cartes = new Carte[Jeu.getTaillePioche()];
	public Carte piocher() {
		//TODO
		return null;
	}
	public Main piocherMain() {
		Carte[] cartes = new Carte[Jeu.getTailleMain()];
		for(int i=0;i<Jeu.getTailleMain();i++) {
			cartes[i] = piocher();
		}
		return new Main(cartes);
	}
}
