import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Plateau {

	public int xsource;
	public int ysource;
	public int nbCanalBleu;
	public int nbTravailleur;
	
	public Plateau (int xsource, int ysource) {

		// Ici Etat contiendra autant de tableaux que de cases utilisées
		// Chaque tableau contiendra : Les coordonnés (x,y), la couleur des ouvriers sur le terrain ainsi que leur 			nombre
		// Lorsqu'on crée l'objet, tout est vide
		ArrayList etat = new ArrayList();
		
		// contient les coordonnées des differents canaux posés
		ArrayList reseau = new ArrayList();
		
		//coordonnées de la sources generées aléatoirement dans le main
		this.xsource = xsource;
		this.ysource = ysource;
		
		this.nbCanalBleu = 15;
		this.nbTravailleur = 110;
	}
	
	public int getXsource () {
		return this.xsource;
	}
	
	public int getYsource () {
		return this.ysource;
	}
	
	public int getnbTravailleurdispo () {
		return this.nbTravailleur;
	}
	
	public int getNbCanalBleu () {
		return this.nbCanalBleu;
	}
	
	//fonction qui modifie le nombre de travailleur disponible
	public void ChangeTrav (int n) {
		this.nbTravailleur = this.nbTravailleur - n;
	}
	
	//fonction qui modifie le nombre de canal bleu dispo
	public void ChangeCanalBleu (int n) {
		this.nbCanalBleu = this.nbCanalBleu - n;
	}
	
	//tout est dit. 
	public void genererPile(int nbP, Pile p1, Pile p2, Pile p3, Pile p4, Pile p5) {
		
			ArrayList card = new ArrayList();
			Tuile t1 = new Tuile ("blue",1);
			Tuile t2 = new Tuile ("red",2);
			Tuile t3 = new Tuile ("green",2);
			Tuile t4 = new Tuile ("orange",1);
			Tuile t5 = new Tuile ("brown",2);
			int nbBlue  =8; 
			int nbRed  =8; 
			int nbGreen  =8; 
			int nbOrange  =8; 
			int nbBrown  =8; 
			Random rnd = new Random();
			//le nombre de tuile dispo est 45
			int cardnumber = 45;
			//je sais c'est moche. 
			//Donc j'ajoute toutes les cartes dans la liste, dans melanger
			card.clear();
			
			if (nbP ==5){
				for (int i=0; i<= 8; i++) {
					card.add(t1); 
					}
					for (int j=0; j<= 8; j++) {
					card.add(t2); 
					}
					for (int l=0; l<= 8; l++) {
					card.add(t3); 
					}
					for (int m=0; m<= 8; m++) {
					card.add(t4); 
					}
					for (int n=0; n<= 8; n++) {
					card.add(t5); 
					}
				//generation de la pile p1;
				for (int i = 0; i<=8; i++) {
					//on tire au hazard une carte dans la pile
					int x = rnd.nextInt(cardnumber);
					p1.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
				}
				for (int i = 0; i<=8; i++) {
					//on tire au hazard une carte dans la pile
					int x = rnd.nextInt(cardnumber);
					p2.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
				for (int i = 0; i<=8; i++) {
					//on tire au hazard une carte dans la pile
					int x = rnd.nextInt(cardnumber);
					p3.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
				for (int i = 0; i<=8; i++) {
					//on tire au hazard une carte dans la pile
					int x = rnd.nextInt(cardnumber);
					p4.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
				for (int i = 0; i<=8; i++) {
					//on tire au hazard une carte dans la pile
					int x = rnd.nextInt(cardnumber);
					p5.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
			} 
			
			else {
				for (int i=0; i<= 8; i++) {
					card.add(t1); 
					}
					for (int j=0; j<= 8; j++) {
					card.add(t2); 
					}
					for (int l=0; l<= 8; l++) {
					card.add(t3); 
					}
					for (int m=0; m<= 8; m++) {
					card.add(t4); 
					}
					for (int n=0; n<= 8; n++) {
					card.add(t5); 
					}
				int x = rnd.nextInt(cardnumber);
				System.out.println("On retire une carte "+((Tuile) card.get(x)).getCouleur());	
				card.remove(x);
				cardnumber --;
				
				
				for (int i = 0; i<=10; i++) {
					//on tire au hazard une carte dans la pile
					x = rnd.nextInt(cardnumber);
					p1.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
				}
				for (int i = 0; i<=10; i++) {
					//on tire au hazard une carte dans la pile
					x = rnd.nextInt(cardnumber);
					p2.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
				for (int i = 0; i<=10; i++) {
					//on tire au hazard une carte dans la pile
					x = rnd.nextInt(cardnumber);
					p3.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
				for (int i = 0; i<=10; i++) {
					//on tire au hazard une carte dans la pile
					x = rnd.nextInt(cardnumber);
					p4.addCard((Tuile) card.get(x));
					card.remove(x);
					//On decremente a chaque tour le nombre de card dispo
					cardnumber --;
					}
			}
	}
	
	public void afficherPile(Pile p1) {		
		System.out.println(p1.getNom());
		for (int i =0; i<p1.content.size() ; i++) {
			System.out.println(((Tuile) p1.content.get(i)).getCouleur());			
		}
	}
	
}
