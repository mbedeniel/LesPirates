package model;

public class Main {
	private static final int TAILLE_MAIN = 5;
	private Carte[] cartes = new Carte[TAILLE_MAIN];
	private int nbCarte = TAILLE_MAIN - 1;

	public Main(Carte[] cartes) {
		this.cartes = cartes;
	}

	public static int getTailleMain() {
		return TAILLE_MAIN;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public void afficher() {
		for (int i = 0; i < nbCarte; i++) {
			cartes[i].afficher(i + 1);
		}
	}

	public boolean ajouterCarte(Carte carte) {
		if (cartes[nbCarte] == null) {
			cartes[nbCarte] = carte;
			nbCarte++;
			return true;
		}
		return false;
	}

	public Carte retirerCarte(int numCarte) {
		Carte carte = cartes[numCarte - 1];
		for (int i = numCarte; i < nbCarte; i++) {
			cartes[numCarte - 1] = cartes[numCarte];
		}
		cartes[nbCarte - 1] = null;
		nbCarte--;
		return carte;
	}
}
