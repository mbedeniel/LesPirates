package model;

public class Main {
	private static final int TAILLE_MAIN = 5;
	private Carte[] cartes = new Carte[TAILLE_MAIN];

	public Main(Carte[] cartes) {
		this.cartes = cartes;
	}

	public static int getTailleMain() {
		return TAILLE_MAIN;
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public void afficher() {
		for (int i = 0; i < TAILLE_MAIN && cartes[i] != null; i++) {
			cartes[i].afficher(i + 1);
		}
	}

	public boolean ajouterCarte(Carte carte) {
		int indice = TAILLE_MAIN - 1;
		if (cartes[indice] == null) {
			cartes[indice] = carte;
			return true;
		}
		return false;
	}

	public Carte retirerCarte(int numCarte) {
		Carte carte = cartes[numCarte - 1];
		for (int i = numCarte; i < TAILLE_MAIN; i++) {
			cartes[numCarte - 1] = cartes[numCarte];
		}
		cartes[TAILLE_MAIN - 1] = null;
		return carte;
	}
}
