package model;

public class Main {
	private Carte[] cartes = new Carte[Jeu.getTailleMain()];
	
	public Main(Carte[] cartes) {
		this.cartes = cartes;
	}

	public void afficher() {
		for(int i=0;i<Jeu.getTailleMain();i++) {
			cartes[i].afficher();
		}
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}
	
	public boolean ajouterCarte(Carte carte) {
		for(int i=0;i<cartes.length;i++) {
			if(cartes[i]==null) {
				cartes[i] = carte;
				return true;
			}
		}
		return false;
	}
	
}
