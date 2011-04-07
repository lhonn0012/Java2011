import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Partie {

	protected Plateau plateau;
	protected Joueur j1;
	protected Joueur j2;
	protected Joueur j3;
	protected Joueur j4;
	protected Joueur j5;
	protected Joueur alamain;
	protected int nbP;
	protected Pile p1;
	protected Pile p2;
	protected Pile p3;
	protected Pile p4;
	protected Pile p5;
	protected Joueur constr;
	protected Joueur[] tab;
	
	// J'ai cr√©e √ßa car le main ne voulait pas que j'applique genererPile a un objet cr√©e dans un if. Un relou quoi. 
	// Il y a sans doute un autre moyen, mais la j'ai pas envie. 
	public Partie () {};
	
	
	//contructeur pour une partie 5 joueurs
	public Partie (Plateau p, Joueur j1, Joueur j2, Joueur j3, Joueur j4 , Joueur j5, Pile p1,  Pile p2,
			 Pile p3,  Pile p4,  Pile p5) {
		this.plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.j4 = j4;
		this.j5 = j5;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.nbP = 5;
		this.alamain = j1;
		this.constr = null;
	
	}
	
	//contructeur pour une partie 3 joueurs
	public Partie (Plateau p, Joueur j1, Joueur j2, Joueur j3, Pile p1,  Pile p2,
			 Pile p3,Pile p4) {
		this.plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.nbP = 3;
		this.alamain = j1;
		this.constr = null;
		
		
	}
	
	
	//contructeur pour une partie 4 joueurs
	public Partie (Plateau p, Joueur j1, Joueur j2, Joueur j3, Joueur j4, Pile p1,  Pile p2,
			 Pile p3, Pile p4) {
		this.plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.j4 = j4;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4= p4;
		this.nbP = 4;
		this.alamain = j1;
		this.constr = null;
	
	}
	
	public void donnelamain(Joueur j) {
		this.alamain = j;
	}
	
	public int getNbp() {
		return this.nbP;
	}
	
	public Joueur getConstruc() {
		return this.constr;
	}
	
	public void setContr(Joueur j) {
		this.constr = j;
	}
	public void unsetContr(Joueur j) {
		this.constr = null;
	}
	
	//fonction qui creer un tableau de joueur 
	
	public Joueur[] tabDeJoueur() {
		Joueur[] tab = new Joueur[nbP-1];
		if (this.nbP == 3) {
			tab[0]= this.j1;
			tab[1]= this.j2;
			tab[2]= this.j3;
		} else  {
			if (this.nbP == 4) {
				tab[0]= this.j1;
				tab[1]= this.j2;
				tab[2]= this.j3;
				tab[3]= this.j4;
			} else {
				tab[0]= this.j1;
				tab[1]= this.j2;
				tab[2]= this.j3;
				tab[3]= this.j4;
				tab[4]= this.j5;
			}
		}
		return tab;
	}
	
	//Determination du constructeur de canal
	// BUG POTENTIEL DE POINTEURS
	// POSSIBILITE D'ERREUR
	
	public Joueur contructeurCanal() {
		boolean valid = false;
		Scanner sc = new Scanner(System.in);
		
		while (!valid) {
			System.out.println("Qui est le constructeur de canal ?");
			String construc = sc.next();
			if (construc.equals(this.j1.getCouleur())) {
					this.j1.setEstConstruc();
					valid = true;
					this.donnelamain(j1);
					this.setContr(j1);
					return j1;
			} else {
				if (construc.equals(this.j2.getCouleur())) {
					this.j2.setEstConstruc();
					valid = true;
					this.donnelamain(j2);
					this.setContr(j2);
					return j2;
				} else {
					if (construc.equals(this.j3.getCouleur())) {
						this.j3.setEstConstruc();
						valid = true;
						this.donnelamain(j3);
						this.setContr(j3);
						return j3;
					} else {
						if (this.nbP == 4) {
								if (construc.equals(this.j4.getCouleur())) {
										this.j4.setEstConstruc();
										valid = true;
										this.donnelamain(j4);
										this.setContr(j4);
										return j4;
								}
							}
							if (this.nbP == 5)  {
										if (construc.equals(this.j5.getCouleur())) {
											this.j5.setEstConstruc();
											valid = true;
											this.donnelamain(j5);
											this.setContr(j5);
											return j5;
										}
									}
							}
						}
					}
				}
			
		System.out.println("Ce nom d'existe pas");
		
		return null;
	}
	
	
	//Fonction qui determine qui doit jouer 
	//BUG DE POINTEUR A REGLER DEMAIN
	// REMPLACER LE TYPE DE RETOUR PAR VOID et mettre un exit 
	
		public int next() {
			
			if (this.nbP == 3) {
				List<Joueur> tab = new ArrayList(3);
				tab.add(this.j1);
				tab.add(this.j2);
				tab.add(this.j3);
				
				for (int i =0; i < tab.size();  i++ ) {
					
					if ((tab.get(i)).equals(this.alamain)) {
						
							if (i==2) {
									this.alamain=tab.get(0);
									
							} else {
								this.alamain=tab.get(i+1);
								return 0;
							}
					}
				}
			}
			
			if (this.nbP == 4) {
				List<Joueur> tab = new ArrayList(4);
				tab.add(this.j1);
				tab.add(this.j2);
				tab.add(this.j3);
				tab.add(this.j4);

				
				for (int i =0; i < tab.size();  i++ ) {
				
					if ((tab.get(i)).equals(this.alamain)) {
							if (i==3) {
									this.alamain=tab.get(0);
									return 0;
									
							} else {
								this.alamain=tab.get(i+1);
								return 0;
							}
					}
				}
			}
			if (this.nbP == 5) {
				List<Joueur> tab = new ArrayList(5);
				tab.add(this.j1);
				tab.add(this.j2);
				tab.add(this.j3);
				tab.add(this.j4);
				tab.add(this.j5);
				
				for (int i =0; i <= tab.size();  i++ ) {
				
					if ((tab.get(i)).equals(this.alamain)) {
							if (i==4) {
									this.alamain=tab.get(0);
									return 0;
							} else {
								this.alamain=tab.get(i+1);
								return 0;
							}
					}
				}
			}
		return 0;
		}
	
	//PHASE 1 Retourner la premiere tuile
	public void retournerPt (){
		System.out.println("Pile 1 : "+((Tuile) this.p1.content.get(0)).getCouleur());
		System.out.println("Pile 2 : "+((Tuile) this.p2.content.get(0)).getCouleur());
		System.out.println("Pile 3 : "+((Tuile) this.p3.content.get(0)).getCouleur());
		System.out.println("Pile 4 : "+((Tuile) this.p4.content.get(0)).getCouleur());
		
		if (this.nbP == 5) {
			System.out.println("Pile 5 : "+((Tuile) this.p5.content.get(0)).getCouleur());
		}
			
	}
	
	// PHASE 1 : mise des joueurs;
	
	public Joueur[] mise(int nbPlayer) {
		System.out.println("fonction mise");
		//je matte si il assez de sousous pour miser cette somme
		boolean valid= false;
		int tab[] = new int[nbPlayer-1];
		for (int a = 0; a <tab.length ; a++ ) {
			tab[a] = -1;
		}
		Joueur[] joueur = new Joueur[nbPlayer-1];
		int m;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= nbPlayer-2; i++) {
			valid = false;
			while (!valid) {
				System.out.println(this.alamain.getNom()+", combien d'escudos veux tu miser ?( 0 si passe)");
				int mise = sc.nextInt();
				if (mise <= this.alamain.getmoney()) {
					
					if (!check(tab,mise)) { 
						this.alamain.setmise(mise);
						tab[i] = mise;
						joueur[i]= this.alamain;
						this.next();
						valid = true;
					} else {
						System.out.println ("Somme deja proposÈe");
					}
				} else {
					System.out.println("Impossible , vous n'avez que "+this.alamain.getmoney()+" escudos");
				}
			}
		}
		return joueur;
	}
	
	// Phase 1 : fonction qui verifi si l'element parametre est pas deja ds le tab
	public boolean check(int t[], int e) {

		for (int i=0; i<t.length-1; i++) {
			if (t[i]==e && t[i] != 0) {
				return true;
			}
		}
	return false;
	}
	
	//fonction qui effectu la phase 2 : Si tous les joueurs ont misÈe , la plus petite mise devient constructeur
	// sinon certain ont passÈ, on prend le premiere joueur donc la mise est 0 
	
 
	public Joueur phase2(Joueur[] j) {
		boolean trouve = false;
		int i= 0; 
		int indice = -1;
		int mise = 1000;
		
		while (!trouve && i <j.length ) {
			System.out.println(j[i].getmise());
			if (j[i].getmise() == 0) {
				trouve = true;
				
				System.out.println(j[i].getNom());
				System.out.println("********************************");
				System.out.println("*********Etape 2********");
				System.out.println("********************************");
				
				this.getConstruc().UnsetEstConstruc();
				j[i].setEstConstruc();
				this.setContr(j[i]);
			
				System.out.println(j[i].getNom()+" est maintenant constructeur du canal");
				return j[i];
			} else {
				if (j[i].getmise() < mise) {
					
					mise = j[i].getmise();
					indice = i;
					}
				i++;
			
			}
		}
		
		System.out.println("********************************");
		System.out.println("*********Etape 2********");
		System.out.println("********************************");
		
		this.getConstruc().UnsetEstConstruc();
		j[indice].setEstConstruc();
		this.setContr(j[indice]);
		System.out.println(j[indice].getNom()+" est maintenant constructeur du canal");
		return j[indice];
		
	}

	
	public void paie(Joueur[] j) {
		int max = j[0].getmise();
		Joueur joueur  = j[0];
		for (int i = 1; i<j.length-1; i++) {
			if (j[i].getmise() > max ) {
				joueur = j[i];
			}
		}
		System.out.println(joueur.getNom());
	}
	
	public void triTabJoueur (Joueur[] tableau) {
	
		boolean fini = false; 
		
		while (!fini) {
				fini = true; 
				
		}
	     
	}
	
}