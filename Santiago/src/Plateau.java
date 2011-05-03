import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Plateau {

	public JButton source;
	
	public int nbCanalBleu;
	public int nbTravailleur;
	
	Icon banane = new ImageIcon("./images/carte/banane1pl.jpg");
	Icon banane2 = new ImageIcon("./images/carte/banane2pl.jpg");
	Icon poivron = new ImageIcon("./images/carte/poivron1pl.jpg");
	Icon poivron2 = new ImageIcon("./images/carte/poivron2pl.jpg");
	Icon canne = new ImageIcon("./images/carte/canne1pl.jpg");
	Icon canne2 = new ImageIcon("./images/carte/canne2pl.jpg");
	Icon haricot = new ImageIcon("./images/carte/haricot1pl.jpg");
	Icon patate2 = new ImageIcon("./images/carte/pdt2pl.jpg");
	Icon patate = new ImageIcon("./images/carte/pdt1pl.jpg");
	Icon haricot2 = new ImageIcon("./images/carte/haricot2pl.jpg");
	
	public Plateau () {

		// Ici Etat contiendra autant de tableaux que de cases utilisées
		// Chaque tableau contiendra : Les coordonnés (x,y), la couleur des ouvriers sur le terrain ainsi que leur 			nombre
		// Lorsqu'on crée l'objet, tout est vide
		ArrayList etat = new ArrayList();
		
		// contient les coordonnées des differents canaux posés
		ArrayList reseau = new ArrayList();
		
		//coordonnées de la sources generées aléatoirement dans le main
		this.source = null;
		
		
		this.nbCanalBleu = 15;
		this.nbTravailleur = 110;
	}
	
	public JButton getXsource () {
		return this.source;
	}
	
	public void setSource(JButton b) {
		this.source = b;
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
	public Tuile genererPile(int nbP, Pile p1, Pile p2, Pile p3, Pile p4, Pile p5) {
		
		Tuile t1 = new Tuile ("Banane",1,banane);
		Tuile t2 = new Tuile ("Banane",1,banane);
		Tuile t3 = new Tuile ("Banane",1,banane);
		Tuile t4 = new Tuile ("Banane",1,banane);
		Tuile t5 = new Tuile ("Banane",1,banane);
		Tuile t6 = new Tuile ("Banane",1,banane);
		Tuile t7 = new Tuile ("Banane",2,banane2);
		Tuile t8 = new Tuile ("Banane",2,banane2);
		Tuile t9 = new Tuile ("Banane",2,banane2);
		
		Tuile t10 = new Tuile ("Poivron",1,poivron);
		Tuile t11 = new Tuile ("Poivron",1,poivron);
		Tuile t12 = new Tuile ("Poivron",1,poivron);
		Tuile t13 = new Tuile ("Poivron",1,poivron);
		Tuile t14 = new Tuile ("Poivron",1,poivron);
		Tuile t15 = new Tuile ("Poivron",1,poivron);
		Tuile t16 = new Tuile ("Poivron",2,poivron2);
		Tuile t17 = new Tuile ("Poivron",2,poivron2);
		Tuile t18 = new Tuile ("Poivron",2,poivron2);
		
		Tuile t19 = new Tuile ("Canne a sucre",1,canne);
		Tuile t20 = new Tuile ("Canne a sucre",1,canne);
		Tuile t21 = new Tuile ("Canne a sucre",1,canne);
		Tuile t22 = new Tuile ("Canne a sucre",1,canne);
		Tuile t23 = new Tuile ("Canne a sucre",1,canne);
		Tuile t24 = new Tuile ("Canne a sucre",1,canne);
		Tuile t25 = new Tuile ("Canne a sucre",2,canne2);
		Tuile t26 = new Tuile ("Canne a sucre",2,canne2);
		Tuile t27 = new Tuile ("Canne a sucre",2,canne2);
		
		Tuile t28 = new Tuile ("Haricot",1,haricot);
		Tuile t29 = new Tuile ("Haricot",1,haricot);
		Tuile t30 = new Tuile ("Haricot",1,haricot);
		Tuile t31 = new Tuile ("Haricot",1,haricot);
		Tuile t32 = new Tuile ("Haricot",1,haricot);
		Tuile t33 = new Tuile ("Haricot",1,haricot);
		Tuile t34 = new Tuile ("Haricot",2,haricot2);
		Tuile t35 = new Tuile ("Haricot",2,haricot2);
		Tuile t36 = new Tuile ("Haricot",2,haricot2);
		
		Tuile t37 = new Tuile ("Pomme de terre",1,patate);
		Tuile t38 = new Tuile ("Pomme de terre",1,patate);
		Tuile t39 = new Tuile ("Pomme de terre",1,patate);
		Tuile t40 = new Tuile ("Pomme de terre",1,patate);
		Tuile t41 = new Tuile ("Pomme de terre",1,patate);
		Tuile t42 = new Tuile ("Pomme de terre",1,patate);
		Tuile t43 = new Tuile ("Pomme de terre",2,patate2);
		Tuile t44 = new Tuile ("Pomme de terre",2,patate2);
		Tuile t45 = new Tuile ("Pomme de terre",2,patate2);
		
		ArrayList<Tuile> card = new ArrayList<Tuile>();
		card.add(t1);
		card.add(t2);
		card.add(t3);
		card.add(t4);
		card.add(t5);
		card.add(t6);
		card.add(t7);
		card.add(t8);
		card.add(t9);
		card.add(t10);
		card.add(t11);
		card.add(t12);
		card.add(t13);
		card.add(t14);
		card.add(t15);
		card.add(t16);
		card.add(t17);
		card.add(t18);
		card.add(t19);
		card.add(t20);
		card.add(t21);
		card.add(t22);
		card.add(t23);
		card.add(t24);
		card.add(t25);
		card.add(t26);
		card.add(t27);
		card.add(t28);
		card.add(t29);
		card.add(t30);
		card.add(t31);
		card.add(t32);
		card.add(t33);
		card.add(t34);
		card.add(t35);
		card.add(t36);
		card.add(t37);
		card.add(t38);
		card.add(t39);
		card.add(t40);
		card.add(t41);
		card.add(t42);
		card.add(t43);
		card.add(t44);
		card.add(t45);
		
		//je melange les cartes 
		Collections.shuffle(card);
		
		
		if (nbP == 5 ) {
			
			p1.addCard((Tuile) card.get(1));
			p1.addCard((Tuile) card.get(2));
			p1.addCard((Tuile) card.get(3));
			p1.addCard((Tuile) card.get(4));
			p1.addCard((Tuile) card.get(5));
			p1.addCard((Tuile) card.get(6));
			p1.addCard((Tuile) card.get(7));
			p1.addCard((Tuile) card.get(8));
			p1.addCard((Tuile) card.get(9));
			
			p2.addCard((Tuile) card.get(10));
			p2.addCard((Tuile) card.get(11));
			p2.addCard((Tuile) card.get(12));
			p2.addCard((Tuile) card.get(13));
			p2.addCard((Tuile) card.get(14));
			p2.addCard((Tuile) card.get(15));
			p2.addCard((Tuile) card.get(16));
			p2.addCard((Tuile) card.get(17));
			p2.addCard((Tuile) card.get(18));
			
			p3.addCard((Tuile) card.get(19));
			p3.addCard((Tuile) card.get(20));
			p3.addCard((Tuile) card.get(21));
			p3.addCard((Tuile) card.get(22));
			p3.addCard((Tuile) card.get(23));
			p3.addCard((Tuile) card.get(24));
			p3.addCard((Tuile) card.get(25));
			p3.addCard((Tuile) card.get(26));
			p3.addCard((Tuile) card.get(27));
			
			p4.addCard((Tuile) card.get(28));
			p4.addCard((Tuile) card.get(29));
			p4.addCard((Tuile) card.get(30));
			p4.addCard((Tuile) card.get(31));
			p4.addCard((Tuile) card.get(32));
			p4.addCard((Tuile) card.get(33));
			p4.addCard((Tuile) card.get(34));
			p4.addCard((Tuile) card.get(35));
			p4.addCard((Tuile) card.get(36));
			
			p5.addCard((Tuile) card.get(37));
			p5.addCard((Tuile) card.get(38));
			p5.addCard((Tuile) card.get(39));
			p5.addCard((Tuile) card.get(40));
			p5.addCard((Tuile) card.get(41));
			p5.addCard((Tuile) card.get(42));
			p5.addCard((Tuile) card.get(43));
			p5.addCard((Tuile) card.get(44));
			p5.addCard((Tuile) card.get(0));
			return null;
		} else {
			p1.addCard((Tuile) card.get(1));
			p1.addCard((Tuile) card.get(2));
			p1.addCard((Tuile) card.get(3));
			p1.addCard((Tuile) card.get(4));
			p1.addCard((Tuile) card.get(5));
			p1.addCard((Tuile) card.get(6));
			p1.addCard((Tuile) card.get(7));
			p1.addCard((Tuile) card.get(8));
			p1.addCard((Tuile) card.get(9));
			p1.addCard((Tuile) card.get(10));
			p1.addCard((Tuile) card.get(11));
			
			p2.addCard((Tuile) card.get(12));
			p2.addCard((Tuile) card.get(13));
			p2.addCard((Tuile) card.get(14));
			p2.addCard((Tuile) card.get(15));
			p2.addCard((Tuile) card.get(16));
			p2.addCard((Tuile) card.get(17));
			p2.addCard((Tuile) card.get(18));
			p2.addCard((Tuile) card.get(19));
			p2.addCard((Tuile) card.get(20));
			p2.addCard((Tuile) card.get(21));
			p2.addCard((Tuile) card.get(22));
			
			p3.addCard((Tuile) card.get(23));
			p3.addCard((Tuile) card.get(24));
			p3.addCard((Tuile) card.get(25));
			p3.addCard((Tuile) card.get(26));
			p3.addCard((Tuile) card.get(27));
			p3.addCard((Tuile) card.get(28));
			p3.addCard((Tuile) card.get(29));
			p3.addCard((Tuile) card.get(30));
			p3.addCard((Tuile) card.get(31));
			p3.addCard((Tuile) card.get(32));
			p3.addCard((Tuile) card.get(33));
			
			p4.addCard((Tuile) card.get(34));
			p4.addCard((Tuile) card.get(35));
			p4.addCard((Tuile) card.get(36));
			p4.addCard((Tuile) card.get(37));
			p4.addCard((Tuile) card.get(38));
			p4.addCard((Tuile) card.get(39));
			p4.addCard((Tuile) card.get(40));
			p4.addCard((Tuile) card.get(41));
			p4.addCard((Tuile) card.get(42));
			p4.addCard((Tuile) card.get(43));
			p4.addCard((Tuile) card.get(44));
			
			return (Tuile) (card.get(0));
		}
	
	}
	
	public void afficherPile(Pile p1) {		
		System.out.println(p1.getNom());
		for (int i =0; i<p1.content.size() ; i++) {
			System.out.println(((Tuile) p1.content.get(i)).getType());			
		}
	}
	
}
