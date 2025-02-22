package affichage;

public interface IAffichage {

	void souhaiterBienvenue();

	void raconterHistoire();

	void presenterJeux();

	void afficherCarte(String[] carte);

	void afficherCartes(String[][] cartes);

	void afficherJoueur(String[] joueur);

	void afficherJoueurs(String[][] joueurs);

	void piocherMain(String[][] cartes, String nom);

	void piocherCarte(String[] carte, String nom);

	void jouerCarte(String[] carte, String nom, ZoneJeu zoneJeu);

	void afficherTour(String nom);

	void afficherGagnant(String nom);

	int choisirCarte(String nom);

}