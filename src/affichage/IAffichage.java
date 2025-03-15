package affichage;

public interface IAffichage {

	void souhaiterBienvenue();

	void raconterHistoire();

	void presenterJeux();

	void afficherCarte(String titre, String description, int effet, int numCarte);

	void afficherJoueur(String nom, int vie, int popularite);

	void piocherMain(String nom, int nbCarte);

	void piocherCarte(String nom);

	void jouerCarte(String nom, ZoneJeu zoneJeu);

	void afficherTour(String nom);

	void afficherGagnant(String nom);

	int choisirCarte(String nom, int nbMaxCarte);

	void afficherProblem();

	void afficherJoueurs();

	void afficherCartes(String nom);

	void afficherCarteSpecial(String titre, String description, int numCarte);
	
	void renouvelerPioche();
	
	void afficherPermutation(String nomJoueur,String nomAdversaire, int numCarte);

}