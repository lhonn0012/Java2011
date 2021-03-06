
public class Joueur {
	
	protected String nom; 
	protected String couleur;
	private int nbTravailleurs;
	private int nbCanalDeBase;
	private int money;
	private int nbCanalBleu; 
	private boolean EstConstructeurCanal;
	private String j;
	private int mise;
	private boolean alamain;
	
	public Joueur (String nom, String couleur, String j ) {
		this.nom = nom;
		this.couleur =  couleur;
		this.nbTravailleurs = 22;
		this.nbCanalDeBase = 1;
		this.money = 10;
		this.nbCanalBleu = 1;
		this.EstConstructeurCanal = false;
		this.j=j;
		this.mise = -1;
		this.alamain = false;
	}
	
	public String getJ() {
		return this.j;
	}
	public String getNom() {
		return this.nom;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public int getNbTrav () {
		return this.nbTravailleurs;
	}
	
	public int getNbCanalBase () {
		return this.nbCanalDeBase;
	}
	
	public int getmoney() {
		return this.money;
	}
	public int getNbCanalBleu () {
		return this.nbCanalBleu;
	}
	public boolean checkEstConstruc() {
		return this.EstConstructeurCanal;
	}
	public void setEstConstruc() {
		this.EstConstructeurCanal = true;
	}
	public void UnsetEstConstruc() {
		this.EstConstructeurCanal = false;
	}
	public int getmise() {
		return this.mise;
	}
	public void setmise(int mise) {
		this.mise = mise;
	}
	public void setalamain(boolean f) {
		this.alamain = f;
	}

	
	public void setMoney(int money) {
		this.money -= money;
	}

	public void addMoney (int money) {
		this.money += money;
	}
	public void setTravailleur(int Travailleur) {
		this.nbTravailleurs -= Travailleur;
	}
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", couleur=" + couleur + ", mise=" + mise
				+ "]";
	}
	
	
}
