package affichage;

public interface IAffichage {

	void souhaiterBienvenue();

	void raconterHistoire();

	void presenterJeux();

	void afficherCarte(String titre, String description, String effet, int numCarte);

	void afficherJoueur(String nom,String vie, String popularite);

	void piocherMain(String nom);

	void piocherCarte(String nom);

	void jouerCarte(String nom, ZoneJeu zoneJeu);

	void afficherTour(String nom);

	void afficherGagnant(String nom);

	int choisirCarte(String nom);

}