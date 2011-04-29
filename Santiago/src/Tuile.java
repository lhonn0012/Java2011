
public class Tuile {

	public String type;
	private int nbTrav;
	
	public Tuile (String type, int nbTrav) {
		this.type = type;
		this.nbTrav = nbTrav;
	}
	
	public String getType() {
		return this.type;
	}
	public int getNbTrav() {
		return this.nbTrav;
	}
}
