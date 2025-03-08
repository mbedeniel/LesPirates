package model;

public class Main {
	private static final int TAILLE_MAIN = Jeu.getTailleMain();
	private Carte[] cartes = new Carte[TAILLE_MAIN];
	
	public Main(Carte[] cartes) {
		this.cartes = cartes;
	}

	public void afficher() {
		for(int i=0;i<TAILLE_MAIN;i++) {
			if(cartes[i] != null) {
				cartes[i].afficher(i+1);
			}
		}
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}
	
	public boolean ajouterCarte(Carte carte) {
		int indice = TAILLE_MAIN-1;
		if(cartes[indice]==null) {
			cartes[indice] = carte;
			return true;
		}
		return false;
	}
	public void retirerCarte(int numCarte) {
		cartes[numCarte-1].afficher(numCarte);
		for(int i=numCarte;i<TAILLE_MAIN;i++) {
			cartes[numCarte-1] = cartes[numCarte];
		}
		cartes[TAILLE_MAIN-1] = null;
	}
}
