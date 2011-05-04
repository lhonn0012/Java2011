import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


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
	protected Tuile t;
	protected Joueur constr;
	protected Joueur[] tab;
	protected int nbTours = 1;
	final JComboBox misej1 = new JComboBox();
	final JComboBox misej2 = new JComboBox();
	final JComboBox misej3 = new JComboBox();
	final JComboBox misej4 = new JComboBox();
	final JComboBox misej5 = new JComboBox();
	
	final JComboBox offrej1 = new JComboBox();
	final JComboBox offrej2 = new JComboBox();
	final JComboBox offrej3 = new JComboBox();
	final JComboBox offrej4 = new JComboBox();
	final JComboBox offrej5 = new JComboBox();
	
	Icon constructeur = new ImageIcon("./images/constructeurIcone.jpg");
	Icon travailleurBleu = new ImageIcon("./images/construcBleu.jpg");
	Icon travailleurJaune = new ImageIcon("./images/construcJaune.jpg");
	Icon travailleurRouge = new ImageIcon("./images/construcRouge.jpg");
	Icon travailleurVert = new ImageIcon("./images/construcVert.jpg");
	Icon travailleurBlanc = new ImageIcon("./images/construcBlanc.jpg");
	
	final JButton cstruj1 = new JButton(constructeur);
	final JButton cstruj2 = new JButton(constructeur);
	final JButton cstruj3 = new JButton(constructeur);
	final JButton cstruj4 = new JButton(constructeur);
	final JButton cstruj5 = new JButton(constructeur);
	Joueur[] tabPassage = null ;
	final JButton boutonnext = new JButton("Jouer");
	final JButton boutonPhase5 = new JButton("Choix");
	int a = 0;
	
	int ph4 = 0;
	


	
	public static int max(int t[])
	{
	        int m=t[0] ;
	        for(int i=1 ;i < t.length ;i++) if(m < t[i]) m=t[i];
	        return m;
	}
	
	public void majComposant(Component j) {
		j.repaint();
	}
	// J'ai crÃ©e Ã§a car le main ne voulait pas que j'applique genererPile a un objet crÃ©e dans un if. Un relou quoi. 
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
		this.alamain = null;
		this.constr = null;
	}

	//contructeur pour une partie 3 joueurs
	public Partie (Plateau p, Joueur j1, Joueur j2, Joueur j3, Pile p1,  Pile p2,
			Pile p3,Pile p4, Tuile t) {
		this.plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.nbP = 3;
		this.alamain = null;
		this.constr = null;
		this.t= t;


	}

	//contructeur pour une partie 4 joueurs
	public Partie (Plateau p, Joueur j1, Joueur j2, Joueur j3, Joueur j4, Pile p1,  Pile p2,
			Pile p3, Pile p4, Tuile t) {
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
		this.alamain = null;
		this.constr = null;
		this.t= t;

	}

	//donne la main
	public void donnelamain(Joueur j) {
		this.alamain = j;
	}

	public int getNbp() {
		return this.nbP;
	}

	public Joueur getConstruc() {
		return this.constr;
	}

	public Plateau getPlat() {
		return this.plateau;	
	}

	public Tuile getTuile() {
		return this.t;
	}
	public void setContr(Joueur j) {
		this.constr = j;
		j.setalamain(true);
	}
	public void unsetContr(Joueur j) {
		this.constr = null;
		j.setalamain(false);
	}
	public void setalamain(Joueur j) {
		this.alamain = j;
	}


	//fonction qui creer un tableau de joueur 

	public Joueur[] tabDeJoueur() {
		Joueur[] tab = new Joueur[nbP];
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


	//Fonction qui determine qui doit jouer 
	//BUG DE POINTEUR A REGLER DEMAIN
	// REMPLACER LE TYPE DE RETOUR PAR VOID et mettre un exit 

	public Joueur next() {

		if (this.alamain == j1) {
			return j2;
		} else if (this.alamain == j2) {
			return j3;
		} else if (this.alamain == j3) {
			if (this.nbP == 3) {
				return j1;
			} else {
				return j4;
			}
		} else if (this.alamain == j4) {
			if (nbP == 4 ) {
				return j1;
			} else {
				return j5;
			}
		}
		return alamain;
	}		

	//change l'icone du constructeur au nouveau constructeur
	
	
	public void majConstruct(JPanel jp, Partie p, Icon i){
		final JButton cstru = new JButton(constructeur);
		cstruj1.setName("j1");
		cstruj2.setName("j2");
		cstruj3.setName("j3");
		
		cstruj1.setVisible(false);
		cstruj2.setVisible(false);
		cstruj3.setVisible(false);
		cstruj4.setVisible(false);
		cstruj5.setVisible(false);
		
		//
		if (p.j1.checkEstConstruc()) {
			cstruj1.setVisible(true);
			cstruj1.setBorderPainted(false);
			cstruj1.setBounds(910,191, 70, 70);
			jp.add(cstruj1);
		}
		else if (p.j2.checkEstConstruc()) {
			cstruj2.setVisible(true);
			cstruj2.setBorderPainted(false);
			cstruj2.setBounds(910,271, 70, 70);
			jp.add(cstruj2);
				
		}else if (p.j3.checkEstConstruc()) {
			cstruj3.setVisible(true);
			cstruj3.setBorderPainted(false);
			cstruj3.setBounds(910,351, 70, 70);
			jp.add(cstruj3);
		}
		if (p.nbP == 4){
			if (p.j4.checkEstConstruc()) {
				cstruj4.setVisible(true);	
				cstruj4.setBorderPainted(false);
				cstruj4.setBounds(910,431, 70, 70);
				jp.add(cstruj4);
			}
		}
		if(p.nbP==5){
			if (p.j4.checkEstConstruc()) {
				cstruj4.setVisible(true);
				cstruj4.setBorderPainted(false);
				cstruj4.setBounds(910,511,70, 70);
				jp.add(cstruj4);
			}
			else if (p.j5.checkEstConstruc()) {
				cstruj5.setVisible(true);
				cstruj5.setBorderPainted(false);
				cstruj5.setBounds(910,591, 70,70);
				jp.add(cstruj5);
			}
		}
		cstruj1.repaint();
		cstruj2.repaint();
		cstruj3.repaint();
		cstruj4.repaint();
		cstruj5.repaint();
		//JOptionPane.showMessageDialog(null, "le nouveau constructeur est "+p.getConstruc().getNom());
		
	}

	//PHASE 1 Retourner la premiere tuile
	public void retournerPt (){
		System.out.println("Pile 1 : "+((Tuile) this.p1.content.get(0)).getType());
		System.out.println("Pile 2 : "+((Tuile) this.p2.content.get(0)).getType());
		System.out.println("Pile 3 : "+((Tuile) this.p3.content.get(0)).getType());
		System.out.println("Pile 4 : "+((Tuile) this.p4.content.get(0)).getType());

		if (this.nbP == 5) {
			System.out.println("Pile 5 : "+((Tuile) this.p5.content.get(0)).getType());
		}

	}


	public Joueur[] mise(final JPanel j, final Partie p, final FenetrePrincipale f) {

	
		Joueur[] tab = p.tabDeJoueur();
		int indice = -1;
		final JFrame mise = new JFrame();
		JPanel p2 = new JPanel();
		p2.setBackground(Color.black);
		tabPassage = new Joueur[p.nbP];

		for(int i=0; i<tab.length; i++){
			if (tab[i].checkEstConstruc()){
				indice = i;
			}
		}

		if(indice < p.nbP){	
			int jit = 0;

			for(int i=indice+1; i<tab.length;i++){
				tabPassage[jit]=tab[i];
				jit++;
			}

			for(int i = 0; i<=indice; i++){
				tabPassage[jit]=tab[i];

				jit++;
			}	
		}

		if (p.getNbp() == 3 ) {

			//J1
			JLabel j1 = new JLabel();
			j1.setText(tabPassage[0].getNom() +" mise : ");

			misej1.addItem("Passe");
			for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
				misej1.addItem(i);
			}

			j1.setForeground(Color.white);
			p2.add(j1);
			p2.add(misej1);

			//J2
			JLabel j2 = new JLabel();
			j2.setText(tabPassage[1].getNom() +" mise : ");

			misej2.addItem("Passe");
			for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
				misej2.addItem(i);
			}

			j2.setForeground(Color.white);
			p2.add(j2);
			p2.add(misej2);


			//j3
			JLabel j3 = new JLabel();
			j3.setText(tabPassage[2].getNom() +" mise : ");

			misej3.addItem("Passe");
			for (int i = 1; i<= tabPassage[2].getmoney() ; i ++) {
				misej3.addItem(i);
			}

			j3.setForeground(Color.white);
			p2.add(j3);
			p2.add(misej3);


			JButton go = new JButton("Miser");

			go.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					if (String.valueOf(misej1.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[0].setmise(0);
					} else {
						tabPassage[0].setmise((Integer) misej1.getSelectedItem());
					}


					if (String.valueOf(misej2.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[1].setmise(0);
					} else {
						tabPassage[1].setmise((Integer) misej2.getSelectedItem());
					}


					if (String.valueOf(misej3.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[2].setmise(0);
					} else {
						tabPassage[2].setmise((Integer) misej3.getSelectedItem());
					}

					//choixConstruc(j,p);
					phase2(tabPassage, j, p, constructeur, f);
					mise.dispose();
				}
				
			});
			p2.add(go);
			mise.add(p2);
			mise.setLocationRelativeTo(null);
			mise.setSize(100,300);
			mise.setVisible(true);
			
			return tabPassage;	
		}

		if (p.getNbp() == 4 ) {

			//J1

			JLabel j1 = new JLabel();
			j1.setText(tabPassage[0].getNom() +" mise : ");

			misej1.addItem("Passe");
			for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
				misej1.addItem(i);
			}

			j1.setForeground(Color.white);
			p2.add(j1);
			p2.add(misej1);


			//J2
			JLabel j2 = new JLabel();
			j2.setText(tabPassage[1].getNom() +" mise : ");

			misej2.addItem("Passe");
			for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
				misej2.addItem(i);
			}

			j2.setForeground(Color.white);
			p2.add(j2);
			p2.add(misej2);


			//j3
			JLabel j3 = new JLabel();
			j3.setText(tabPassage[2].getNom() +" mise : ");

			misej3.addItem("Passe");
			for (int i = 1; i<= tabPassage[2].getmoney() ; i ++) {
				misej3.addItem(i);
			}

			j3.setForeground(Color.white);
			p2.add(j3);
			p2.add(misej3);



			//J4
			JLabel j4 = new JLabel();
			j4.setText(tabPassage[3].getNom() +"mise :");

			misej4.addItem("Passe");
			for (int i = 1; i<= tabPassage[3].getmoney() ; i ++) {
				misej4.addItem(i);
			}

			j4.setForeground(Color.white);
			p2.add(j4);
			p2.add(misej4);


			JButton go = new JButton("Miser");
			go.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (String.valueOf(misej1.getSelectedItem()).compareTo("Passe")==0) {
						tabPassage[0].setmise(0);
					} else {
						tabPassage[0].setmise((Integer) misej1.getSelectedItem());
					}
					if (String.valueOf(misej2.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[1].setmise(0);
					} else {
						tabPassage[1].setmise((Integer) misej2.getSelectedItem());
					}
					if (String.valueOf(misej3.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[2].setmise(0);
					} else {
						tabPassage[2].setmise((Integer) misej3.getSelectedItem());
					}
					if (String.valueOf(misej4.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[3].setmise(0);
					} else {
						tabPassage[3].setmise((Integer) misej4.getSelectedItem());
					}

					phase2(tabPassage, j, p, constructeur,f);

					mise.dispose();
				}
			});
			j.repaint();
			p2.add(go);;
			mise.add(p2);
			mise.setLocationRelativeTo(null);
			mise.setSize(100,400);
			mise.setVisible(true);
			return tabPassage;
		}
		if (p.getNbp() == 5 ) {

			//J1
			JLabel j1 = new JLabel();
			j1.setText(tabPassage[0].getNom() +" mise : ");

			misej1.addItem("Passe");
			for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
				misej1.addItem(i);
			}
			j1.setForeground(Color.white);
			p2.add(j1);
			p2.add(misej1);


			//J2
			JLabel j2 = new JLabel();
			j2.setText(tabPassage[1].getNom() +" mise : ");

			misej2.addItem("Passe");
			for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
				misej2.addItem(i);
			}
			j2.setForeground(Color.white);
			p2.add(j2);
			p2.add(misej2);


			//j3
			JLabel j3 = new JLabel();
			j3.setText(tabPassage[2].getNom() +" mise : ");

			misej3.addItem("Passe");
			for (int i = 1; i<=tabPassage[2].getmoney() ; i ++) {
				misej3.addItem(i);
			}
			j3.setForeground(Color.white);
			p2.add(j3);
			p2.add(misej3);



			//J4
			JLabel j4 = new JLabel();
			j4.setText(tabPassage[3].getNom() +"mise :");

			misej4.addItem("Passe");
			for (int i = 1; i<= tabPassage[3].getmoney() ; i ++) {
				misej4.addItem(i);
			}
			j4.setForeground(Color.white);
			p2.add(j4);
			p2.add(misej4);


			//J5
			JLabel j5 = new JLabel();
			j5.setText(tabPassage[4].getNom() +"mise :");

			misej5.addItem("Passe");
			for (int i = 1; i<= tabPassage[4].getmoney() ; i ++) {
				misej5.addItem(i);
			}
			j5.setForeground(Color.white);
			p2.add(j5);
			p2.add(misej5);


			JButton go = new JButton("Miser");
			go.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (!(tabPassage[0].checkEstConstruc()) && String.valueOf(misej1.getSelectedItem()).compareTo("Passe") ==0) {
						tabPassage[0].setmise(0);
					} else {
						tabPassage[0].setmise((Integer) misej1.getSelectedItem());
					}

					if (!(tabPassage[1].checkEstConstruc()) && String.valueOf(misej2.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[1].setmise(0);
					} else {
						tabPassage[1].setmise((Integer) misej2.getSelectedItem());
					}

					if (!(tabPassage[2].checkEstConstruc()) && String.valueOf(misej3.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[2].setmise(0);
					} else {
						tabPassage[2].setmise((Integer) misej3.getSelectedItem());
					}

					if (!(tabPassage[3].checkEstConstruc()) && String.valueOf(misej4.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[3].setmise(0);
					} else {
						tabPassage[3].setmise((Integer) misej4.getSelectedItem());
					}

					if (!(tabPassage[4].checkEstConstruc()) && String.valueOf(misej5.getSelectedItem()).compareTo("Passe") == 0) {
						tabPassage[4].setmise(0);
					} else {
						tabPassage[4].setmise((Integer) misej5.getSelectedItem());
					}
					phase2(tabPassage, j, p, constructeur,f);
					mise.dispose();
				}
			});
			//p2.add(go);;
			j.repaint();
			p2.add(go);;
			mise.add(p2);
			mise.setLocationRelativeTo(null);
			mise.setSize(150,500);
			mise.setVisible(true);
			return tabPassage;
		}
		return tabPassage;
	}

	public void choixConstruc (JPanel j, final Partie p) {
			int[] money = null;	

			final JComboBox choixConstruc = new JComboBox();

			final JFrame mise = new JFrame();
			JPanel p2 = new JPanel();
			p2.setBackground(Color.black);

			if (p.getNbp() == 3 ) {
				//J1
				if (!p.j1.checkEstConstruc())  {
					JLabel j1 = new JLabel();
					j1.setText(p.j1.getNom() +" mise : "+p.j1.getmise());
					j1.setForeground(Color.white);
					p2.add(j1);
				}
				//J2
				if (!p.j2.checkEstConstruc())  {
					JLabel j2 = new JLabel();
					j2.setText(p.j2.getNom() +" mise : "+p.j2.getmise());
					j2.setForeground(Color.white);
					p2.add(j2);
				}
				//j3
				if (!p.j3.checkEstConstruc())  {
					JLabel j3 = new JLabel();
					j3.setText(p.j3.getNom() +" mise : "+p.j3.getmise());
					j3.setForeground(Color.white);
					p2.add(j3);
				}

				JLabel choixC = new JLabel("Choix du constructeur");
				choixC.setText("Choix du constructeur : ");
				choixC.setForeground(Color.white);

				choixConstruc.addItem(p.j1.getNom());
				choixConstruc.addItem(p.j2.getNom());
				choixConstruc.addItem(p.j3.getNom());

				JButton choix = new JButton("Choisir");
				choix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mise.dispose();
						JOptionPane.showMessageDialog(null,choixConstruc.getSelectedItem()+ " à toi de poser le canal");
					}
				});

				p2.add(choixC);
				p2.add(choixConstruc);
				p2.add(choix);
				mise.add(p2);
				mise.setLocationRelativeTo(null);
				mise.setSize(100,200);
				mise.setVisible(true);
			}
		}

		public Joueur phase2(Joueur[] j, JPanel jp, Partie p, Icon ic, FenetrePrincipale f) {
			int min = 51;
			int indice = -1;
			
			for (int i=0; i<tabPassage.length; i++){
				if(tabPassage[i].getmise()==0){
					p.constr.UnsetEstConstruc();
					
					tabPassage[i].setEstConstruc();
					p.setalamain(tabPassage[i]);
					
					p.setContr(tabPassage[i]);
					
					majConstruct(jp, p, ic);
					phase3(tabPassage,jp,p,f);
					
					return tabPassage[i];
				}
				else if(tabPassage[i].getmise()< min){
					p.constr.UnsetEstConstruc();
					
					indice = i;
					min = tabPassage[i].getmise();
				}
			}
			tabPassage[indice].setEstConstruc();
			p.setalamain(tabPassage[indice]);
			p.setContr(tabPassage[indice]);
			majConstruct(jp, p,ic);
			phase3(tabPassage,jp,p,f);
			return tabPassage[indice];
		}
		
		
		public void phase3 (Joueur[] j, final JPanel jp, final Partie p, final FenetrePrincipale f){
			
			int max = -1;
			
			Joueur temp;
			final Joueur[] triParMise = j;
			for(int i=0;i<triParMise.length-1 ;i++){
				for(int k=i+1;k<triParMise.length;k++ ){
					if(triParMise[i].getmise()<triParMise[k].getmise()){
						temp = triParMise[i];
						triParMise[i]=triParMise[k];
						triParMise[k]=temp;
					}
				}
			}
			if (a == triParMise.length ) {
				boutonnext.setText("Finir");
			}
			boutonnext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (a < triParMise.length ) {
						System.out.println(triParMise[a].getNom());
						p.setalamain(triParMise[a]);
						phase3Jeu(triParMise[a],p,f);
					} else {
						if (a == triParMise.length +1) {
							boutonnext.setVisible(false);
							phase4(tabPassage,jp,p,f);
						} else {
						JOptionPane.showMessageDialog(null, "Debut de la phase 4, posez vos proposition de canaux");
						boutonnext.setText("Faire offre");
						a++;
						}
					}
				}
			});
			
			boutonnext.setBounds(40, 20, 100, 50);
			jp.add(boutonnext);
			jp.repaint();
		}
		
		public void phase3Jeu(Joueur j,final Partie p,FenetrePrincipale f) {
			System.out.println(p.alamain);
			f.changementCouleurTrav(p);
			a++;
			JOptionPane.showMessageDialog(null, j.getNom()+" a toi de jouer mec !");
			j.setMoney(j.getmise());
			
		}
		
		
		public void phase4(final Joueur[] j, final JPanel jp, final Partie p, final FenetrePrincipale f) {
			
			final JComboBox choixConstruc = new JComboBox();

			final JFrame mise = new JFrame();
			JPanel p2 = new JPanel();
			p2.setBackground(Color.black);
				
			if (p.getNbp() == 3 ) {
				//J1
				if (!j[0].checkEstConstruc())  {
					
					JLabel j1 = new JLabel();
					offrej1.removeAllItems();
					j1.setForeground(Color.white);
					j1.setText(tabPassage[0].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
						offrej1.addItem(i);
					}
					p2.add(j1);
					p2.add(offrej1);
				}
				//J2
				if (!j[1].checkEstConstruc())  {
					
					JLabel j2 = new JLabel();
					offrej2.removeAllItems();
					j2.setForeground(Color.white);
					j2.setText(tabPassage[1].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
						offrej2.addItem(i);
					}
					p2.add(j2);
					p2.add(offrej2);
				}
				//j3
				if (!j[2].checkEstConstruc())  {
					
					JLabel j3 = new JLabel();
					offrej3.removeAllItems();
					j3.setForeground(Color.white);
					j3.setText(tabPassage[2].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[2].getmoney() ; i ++) {
						offrej3.addItem(i);
					}
					p2.add(j3);
					p2.add(offrej3);
				}

				JLabel choixC = new JLabel("Choix du constructeur");
				choixC.setText("Choix du constructeur : ");
				choixC.setForeground(Color.white);

				choixConstruc.addItem(p.j1.getNom());
				choixConstruc.addItem(p.j2.getNom());
				choixConstruc.addItem(p.j3.getNom());
				
				JButton choix = new JButton("Choisir");
				choix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int tab [] = null;
						if ( a == 1) {
							tab[0] =  Integer.parseInt(offrej1.getSelectedItem().toString());
							} else if (offrej2.getSelectedItem() != null) {
							tab[1] =  Integer.parseInt(offrej2.getSelectedItem().toString());
								} else if (offrej3.getSelectedItem() != null) {
							tab[2] =  Integer.parseInt(offrej3.getSelectedItem().toString());
							}
						int max = max(tab);
							if (j[0].checkEstConstruc() && j[0].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[0].setMoney(max);
							} else if (j[1].checkEstConstruc()  && j[1].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[1].setMoney(max);
							}else if (j[2].checkEstConstruc()  && j[2].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[2].setMoney(max);
							}else						
								if (max == (Integer)misej1.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								} else if (max == (Integer)misej2.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								}
						mise.dispose();
						JOptionPane.showMessageDialog(null,choixConstruc.getSelectedItem()+ " à toi de poser le canal");
					}
				});

				p2.add(choixC);
				p2.add(choixConstruc);
				p2.add(choix);
				mise.add(p2);
				mise.setLocationRelativeTo(null);
				mise.setSize(100,200);
				mise.setVisible(true);
			} else if (p.getNbp() == 4 ) {
				if (!j[0].checkEstConstruc())  {
					JLabel j1 = new JLabel();
					offrej1.removeAllItems();
					j1.setForeground(Color.white);
					j1.setText(tabPassage[0].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
						offrej1.addItem(i);
					}
					p2.add(j1);
					p2.add(offrej1);
				}
				//J2
				if (!j[1].checkEstConstruc())  {
					JLabel j2 = new JLabel();
					offrej2.removeAllItems();
					j2.setForeground(Color.white);
					j2.setText(tabPassage[1].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
						offrej2.addItem(i);
					}
					p2.add(j2);
					p2.add(offrej2);
				}
				//j3
				if (!j[2].checkEstConstruc())  {
					JLabel j3 = new JLabel();
					offrej3.removeAllItems();
					j3.setForeground(Color.white);
					j3.setText(tabPassage[2].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[2].getmoney() ; i ++) {
						offrej3.addItem(i);
					}
					p2.add(j3);
					p2.add(offrej3);
				}
				//j4
				if (!j[3].checkEstConstruc())  {
					JLabel j4 = new JLabel();
					offrej4.removeAllItems();
					j4.setForeground(Color.white);
					j4.setText(tabPassage[3].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[3].getmoney() ; i ++) {
						offrej4.addItem(i);
					}
					p2.add(j4);
					p2.add(offrej4);
				}

				JLabel choixC = new JLabel("Choix du constructeur");
				choixC.setText("Choix du constructeur : ");
				choixC.setForeground(Color.white);

				choixConstruc.addItem(p.j1.getNom());
				choixConstruc.addItem(p.j2.getNom());
				choixConstruc.addItem(p.j3.getNom());
				choixConstruc.addItem(p.j4.getNom());
				
				JButton choix = new JButton("Choisir");
				choix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int tab [] = {(Integer) misej1.getSelectedItem(),(Integer) misej2.getSelectedItem(),(Integer) misej3.getSelectedItem(),(Integer) misej4.getSelectedItem()};
						int max = max(tab);
							if (j[0].checkEstConstruc() && j[0].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[0].setMoney(max);
							} else if (j[1].checkEstConstruc()  && j[1].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[1].setMoney(max);
							}else if (j[2].checkEstConstruc()  && j[2].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[2].setMoney(max);
							}else if (j[3].checkEstConstruc()  && j[3].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[4].setMoney(max);
							} else						
							if (max == (Integer)misej1.getSelectedItem()) {
								p.getConstruc().addMoney(max);
							} else if (max == (Integer)misej2.getSelectedItem()) {
								p.getConstruc().addMoney(max);
							} else if (max == (Integer)misej3.getSelectedItem()) {
								p.getConstruc().addMoney(max);
							} 
						mise.dispose();
						JOptionPane.showMessageDialog(null,choixConstruc.getSelectedItem()+ " à toi de poser le canal");
						
					}
				});

				p2.add(choixC);
				p2.add(choixConstruc);
				p2.add(choix);
				mise.add(p2);
				mise.setLocationRelativeTo(null);
				mise.setSize(100,200);
				mise.setVisible(true);
			} else if (p.getNbp() == 5 ) {
				if (!j[0].checkEstConstruc())  {
					JLabel j1 = new JLabel();
					offrej1.removeAllItems();
					j1.setForeground(Color.white);
					j1.setText(tabPassage[0].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[0].getmoney() ; i ++) {
						offrej1.addItem(i);
					}
					p2.add(j1);
					p2.add(offrej1);
				}
				//J2
				if (!j[1].checkEstConstruc())  {
					JLabel j2 = new JLabel();
					offrej2.removeAllItems();
					j2.setForeground(Color.white);
					j2.setText(tabPassage[1].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[1].getmoney() ; i ++) {
						offrej2.addItem(i);
					}
					p2.add(j2);
					p2.add(offrej2);
				}
				//j3
				if (!j[2].checkEstConstruc())  {
					JLabel j3 = new JLabel();
					offrej3.removeAllItems();
					j3.setForeground(Color.white);
					j3.setText(tabPassage[2].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[2].getmoney() ; i ++) {
						offrej3.addItem(i);
					}
					p2.add(j3);
					p2.add(offrej3);
				}
				//j4
				if (!j[3].checkEstConstruc())  {
					JLabel j4 = new JLabel();
					offrej4.removeAllItems();
					j4.setForeground(Color.white);
					j4.setText(tabPassage[3].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[3].getmoney() ; i ++) {
						offrej4.addItem(i);
					}
					p2.add(j4);
					p2.add(offrej4);
				}
				//j5
				if (!j[4].checkEstConstruc())  {
					JLabel j5 = new JLabel();
					offrej5.removeAllItems();
					j5.setForeground(Color.white);
					j5.setText(tabPassage[4].getNom()+" mise: ");
					for (int i = 1; i<= tabPassage[4].getmoney() ; i ++) {
						offrej5.addItem(i);
					}
					p2.add(j5);
					p2.add(offrej5);
				}

				JLabel choixC = new JLabel("Choix du constructeur");
				choixC.setText("Choix du constructeur : ");
				choixC.setForeground(Color.white);

				choixConstruc.addItem(p.j1.getNom());
				choixConstruc.addItem(p.j2.getNom());
				choixConstruc.addItem(p.j3.getNom());
				choixConstruc.addItem(p.j4.getNom());
				choixConstruc.addItem(p.j5.getNom());

				JButton choix = new JButton("Choisir");
				choix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int tab [] = {(Integer) misej1.getSelectedItem(),(Integer) misej2.getSelectedItem(),(Integer) misej3.getSelectedItem(),(Integer) misej4.getSelectedItem()};
						int max = max(tab);
							if (j[0].checkEstConstruc() && j[0].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[0].setMoney(max);
							} else if (j[1].checkEstConstruc()  && j[1].getNom().matches((String) choixConstruc.getSelectedItem())) {
								j[1].setMoney(max);
							}else if (j[2].checkEstConstruc()  && j[2].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[2].setMoney(max);
							}else if (j[3].checkEstConstruc()  && j[3].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[3].setMoney(max);
							}
							else if (j[4].checkEstConstruc()  && j[4].getNom().matches((String) choixConstruc.getSelectedItem())){
								j[4].setMoney(max);
							} else {
								if (max == (Integer)misej1.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								} else if (max == (Integer)misej2.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								} else if (max == (Integer)misej3.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								} 
								else if (max == (Integer)misej4.getSelectedItem()) {
									p.getConstruc().addMoney(max);
								} 
								
							}
						mise.dispose();
						JOptionPane.showMessageDialog(null,choixConstruc.getSelectedItem()+ " à toi de poser le canal");
					}
				});	
			}
			boutonPhase5.setText("Phase 5");
			boutonPhase5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					phase5(tabPassage,jp,p,f);
				}
			});
			boutonPhase5.setBounds(40 , 20, 100, 50);
			boutonPhase5.setVisible(true);
			jp.add(boutonPhase5);
			jp.repaint();
		}

		//Phase5
		public void phase5(Joueur[] tabPassage,final JPanel jp, Partie p, FenetrePrincipale f){
			boolean pose = false;
			int indice = 0;
			int rep;
			while(!pose && indice < tabPassage.length){
				if(tabPassage[indice].getNbCanalBleu()!=0){
					rep=JOptionPane.showConfirmDialog(null, tabPassage[indice].getNom()+", Voulez-vous placer un canal?", "Choix", JOptionPane.YES_NO_OPTION);
					if(rep == JOptionPane.YES_OPTION){
						p.setalamain(tabPassage[indice]);
						pose = true;
					}
					else {
						indice++;
					}
				}
			}	
			phase6(tabPassage,jp,p,f);
		}
				
		//Phase 6
		public void phase6(Joueur[] tabPassage, final JPanel jp, Partie p, FenetrePrincipale f){
			phase7(tabPassage,jp,p,f);
		}

		//Phase 7
		public void phase7(Joueur[] tabPassage, final JPanel jp,Partie p, FenetrePrincipale f){
			if(nbP==3 || nbP==4){
				if(nbTours<9){
					for(Joueur j : tabPassage){
						j.addMoney(3);
					}
					mise(jp,p,f);
				}
				else{
					JOptionPane.showMessageDialog(null,"Fin de la partie !");
				}
			}
			else if (nbP==50){
				if(nbTours<11){
					for(Joueur j : tabPassage){
						j.addMoney(3);
					}
					mise(jp,p,f);
				}
				else{
					JOptionPane.showMessageDialog(null,"Fin de la partie !");
				}
			}
		}

		public Icon couleurTrav(Partie p) {
			if (p.alamain.getCouleur().matches("jaune") ) {
				return travailleurJaune;
			} else if (p.alamain.getCouleur().matches("vert")) {
				return travailleurVert;
			} else if (p.alamain.getCouleur().matches("bleu")) {
				return travailleurBleu;
			} else if (p.alamain.getCouleur().matches("jaune")) {
				return travailleurJaune;
			} else if (p.alamain.getCouleur().matches("rouge")) {
				return travailleurRouge;
			}else if (p.alamain.getCouleur().matches("blanc")) {
				return travailleurBlanc;
			}
			return null;
		}
		

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==misej1){
				String newVal = (String) misej1.getSelectedItem();
				misej2.removeItem(newVal);	
				misej3.removeItem(newVal);
				misej4.removeItem(newVal);
				misej5.removeItem(newVal);
			}
			if (e.getSource()==misej2){
				String newVal = (String) misej2.getSelectedItem();
				misej1.removeItem(newVal);	
				misej3.removeItem(newVal);
				misej4.removeItem(newVal);
				misej5.removeItem(newVal);
			}
			if (e.getSource()==misej3){
				String newVal = (String) misej3.getSelectedItem();
				misej2.removeItem(newVal);	
				misej1.removeItem(newVal);
				misej4.removeItem(newVal);
				misej5.removeItem(newVal);
			}
			if (e.getSource()==misej4){
				String newVal = (String) misej4.getSelectedItem();
				misej2.removeItem(newVal);	
				misej3.removeItem(newVal);
				misej1.removeItem(newVal);
				misej5.removeItem(newVal);
			}
			if (e.getSource()==misej5){
				String newVal = (String) misej5.getSelectedItem();
				misej2.removeItem(newVal);	
				misej3.removeItem(newVal);
				misej4.removeItem(newVal);
				misej1.removeItem(newVal);
			}
		}

	}