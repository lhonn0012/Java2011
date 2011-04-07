
public class Tuile {

	public String couleur;
	private int nbTrav;
	
	public Tuile (String couleur, int nbTrav) {
		this.couleur = couleur;
		this.nbTrav = nbTrav;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
}
