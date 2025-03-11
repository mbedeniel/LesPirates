package affichage;

public enum ZoneJeu {
	ATTAQUE("ATTAQUE"), POPULARITE("POPULARITE"), SPECIAL("SPECIAL");

	private String nom;

	private ZoneJeu(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
