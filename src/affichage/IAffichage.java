package affichage;

public interface IAffichage {

	void souhaiterBienvenue();

	void raconterHistoire();

	void presenterJeux();

	public void afficherCarte(String titre, String description, String effet);

	void afficherCartes(String[][] cartes);

	public void afficherJoueur(String nom,String vie, String popularite);

	void afficherJoueurs(String[][] joueurs);

	void piocherMain(String[][] cartes, String nom);

	void piocherCarte(String[] carte, String nom);

	void jouerCarte(String[] carte, String nom, ZoneJeu zoneJeu);

	void afficherTour(String nom);

	void afficherGagnant(String nom);

	int choisirCarte(String nom);

}