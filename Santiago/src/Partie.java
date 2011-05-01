import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
		this.alamain = j1;
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
		this.alamain = j1;
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
	
	
	public void mise(final JPanel j, final Partie p) {
		
		int[] money = null;	
		
		JButton ask = new JButton("(1) Miser");	
		ask.setBounds(10, 100, 100, 50);
		
		ask.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
					final JFrame mise = new JFrame();
					JPanel p2 = new JPanel();
					p2.setBackground(Color.black);
					
					if (p.getNbp() == 3 ) {
						
						//J1
						JLabel j1 = new JLabel();
						j1.setText(p.j1.getNom() +"mise :");
						final JComboBox misej1 = new JComboBox();
						misej1.addItem("Passe");
						for (int i = 1; i<= p.j1.getmoney() ; i ++) {
							misej1.addItem(i);
						}
						

						//J2
						JLabel j2 = new JLabel();
						j2.setText(p.j2.getNom() +"mise :");
						final JComboBox misej2 = new JComboBox();
						misej2.addItem("Passe");
						for (int i = 1; i<= p.j2.getmoney() ; i ++) {
							misej2.addItem(i);
						}
						
						
						//j3
						JLabel j3 = new JLabel();
						j3.setText(p.j3.getNom() +"mise :");
						final JComboBox misej3 = new JComboBox();
						misej3.addItem("Passe");
						for (int i = 1; i<= p.j3.getmoney() ; i ++) {
							misej3.addItem(i);
						}
						
						j1.setForeground(Color.white);
						j2.setForeground(Color.white);
						j3.setForeground(Color.white);
						
						p2.add(j1);
						p2.add(misej1);
						
						p2.add(j2);
						p2.add(misej2);
						
						p2.add(j3);
						p2.add(misej3);
						
						JButton go = new JButton("Miser");
						go.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								if (((String) misej1.getSelectedItem()).matches("Passe")) {
									p.j1.setmise(0);
								} else {
									p.j1.setmise((Integer) misej1.getSelectedItem());
								}
								if (((String) misej2.getSelectedItem()).matches("Passe")) {
									p.j2.setmise(0);
								} else {
									p.j2.setmise((Integer) misej2.getSelectedItem());
								}
								if (((String) misej3.getSelectedItem()).matches("Passe")) {
									p.j3.setmise(0);
								} else {
									p.j3.setmise((Integer) misej3.getSelectedItem());
								}
								mise.dispose();
							}
						});
						p2.add(go);
						mise.add(p2);
						mise.setLocationRelativeTo(null);
						mise.setSize(100,200);
						mise.setVisible(true);
						
					}
					if (p.getNbp() == 4 ) {
						System.out.println("lili");

						//J1
						JLabel j1 = new JLabel();
						j1.setText(p.j1.getNom() +"mise :");
						final JComboBox misej1 = new JComboBox();
						misej1.addItem("Passe");
						for (int i = 1; i<= p.j1.getmoney() ; i ++) {
							misej1.addItem(i);
						}
						
						
						//J2
						JLabel j2 = new JLabel();
						j2.setText(p.j2.getNom() +"mise :");
						final JComboBox misej2 = new JComboBox();
						misej2.addItem("Passe");
						for (int i = 1; i<= p.j2.getmoney() ; i ++) {
							misej2.addItem(i);
						}
						
						
						//j3
						JLabel j3 = new JLabel();
						j3.setText(p.j3.getNom() +"mise :");
						final JComboBox misej3 = new JComboBox();
						misej3.addItem("Passe");
						for (int i = 1; i<= p.j3.getmoney() ; i ++) {
							misej3.addItem(i);
						}
						
						//J4
						JLabel j4 = new JLabel();
						j4.setText(p.j4.getNom() +"mise :");
						final JComboBox misej4 = new JComboBox();
						misej4.addItem("Passe");
						for (int i = 1; i<= p.j4.getmoney() ; i ++) {
							misej4.addItem(i);
						}
						
						j1.setForeground(Color.white);
						j2.setForeground(Color.white);
						j3.setForeground(Color.white);
						j4.setForeground(Color.white);
						
						p2.add(j1);
						p2.add(misej1);
						
						p2.add(j2);
						p2.add(misej2);
						
						p2.add(j3);
						p2.add(misej3);
						
						p2.add(j4);
						p2.add(misej4);
						
						JButton go = new JButton("Miser");
						go.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								if (((String) misej1.getSelectedItem()).matches("Passe")) {
									p.j1.setmise(0);
								} else {
									p.j1.setmise((Integer) misej1.getSelectedItem());
								}
								if (((String) misej2.getSelectedItem()).matches("Passe")) {
									p.j2.setmise(0);
								} else {
									p.j2.setmise((Integer) misej2.getSelectedItem());
								}
								if (((String) misej3.getSelectedItem()).matches("Passe")) {
									p.j3.setmise(0);
								} else {
									p.j3.setmise((Integer) misej3.getSelectedItem());
								}
								if (((String) misej4.getSelectedItem()).matches("Passe")) {
									p.j4.setmise(0);
								} else {
									p.j4.setmise((Integer) misej4.getSelectedItem());
								}
								mise.dispose();
							}
						});
						p2.add(go);
						mise.add(p2);
						mise.setLocationRelativeTo(null);
						mise.setSize(100,200);
						mise.setVisible(true);
					}
					if (p.getNbp() == 5 ) {

						//J1
						JLabel j1 = new JLabel();
						j1.setText(p.j1.getNom() +"mise :");
						final JComboBox misej1 = new JComboBox();
						misej1.addItem("Passe");
						for (int i = 1; i<= p.j1.getmoney() ; i ++) {
							misej1.addItem(i);
						}
						
						
						//J2
						JLabel j2 = new JLabel();
						j2.setText(p.j2.getNom() +"mise :");
						final JComboBox misej2 = new JComboBox();
						misej2.addItem("Passe");
						for (int i = 1; i<= p.j2.getmoney() ; i ++) {
							misej2.addItem(i);
						}
						
						
						//j3
						JLabel j3 = new JLabel();
						j3.setText(p.j3.getNom() +"mise :");
						final JComboBox misej3 = new JComboBox();
						misej3.addItem("Passe");
						for (int i = 1; i<= p.j3.getmoney() ; i ++) {
							misej3.addItem(i);
						}
						
						//J4
						JLabel j4 = new JLabel();
						j4.setText(p.j4.getNom() +"mise :");
						final JComboBox misej4 = new JComboBox();
						misej4.addItem("Passe");
						for (int i = 1; i<= p.j4.getmoney() ; i ++) {
							misej4.addItem(i);
						}
						
						
						//J5
						JLabel j5 = new JLabel();
						j5.setText(p.j5.getNom() +"mise :");
						final JComboBox misej5 = new JComboBox();
						misej5.addItem("Passe");
						for (int i = 1; i<= p.j5.getmoney() ; i ++) {
							misej5.addItem(i);
						}
						j1.setForeground(Color.white);
						j2.setForeground(Color.white);
						j3.setForeground(Color.white);
						j4.setForeground(Color.white);
						j5.setForeground(Color.white);
						
						p2.add(j1);
						p2.add(misej1);
						
						p2.add(j2);
						p2.add(misej2);
						
						p2.add(j3);
						p2.add(misej3);
						
						p2.add(j4);
						p2.add(misej4);
						
						p2.add(j4);
						p2.add(misej5);
						
						JButton go = new JButton("Miser");
						go.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								if (((String) misej1.getSelectedItem()).matches("Passe")) {
									p.j1.setmise(0);
								} else {
									p.j1.setmise((Integer) misej1.getSelectedItem());
								}
								if (((String) misej2.getSelectedItem()).matches("Passe")) {
									p.j2.setmise(0);
								} else {
									p.j2.setmise((Integer) misej2.getSelectedItem());
								}
								if (((String) misej3.getSelectedItem()).matches("Passe")) {
									p.j3.setmise(0);
								} else {
									p.j3.setmise((Integer) misej3.getSelectedItem());
								}
								if (((String) misej4.getSelectedItem()).matches("Passe")) {
									p.j4.setmise(0);
								} else {
									p.j4.setmise((Integer) misej4.getSelectedItem());
								}
								if (((String) misej5.getSelectedItem()).matches("Passe")) {
									p.j5.setmise(0);
								} else {
									p.j5.setmise((Integer) misej5.getSelectedItem());
								}
								mise.dispose();
							}
						});
						p2.add(go);
						mise.add(p2);
						mise.setLocationRelativeTo(null);
						mise.setSize(150,400);
						mise.setVisible(true);
					}
					
			}
		});
		
		j.add(ask);
	}
	// PHASE 1 : mise des joueurs;
	
	/*public Joueur[] mise(int nbPlayer) {
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
	
	// Phase 1 : fonction qui verifie si l'element parametre est pas deja ds le tab
	public boolean check(int t[], int e) {

		for (int i=0; i<t.length-1; i++) {
			if (t[i]==e && t[i] != 0) {
				return true;
			}
		}
	return false;
	}
	
	//fonction qui effectue la phase 2 : Si tous les joueurs ont misÈe , la plus petite mise devient constructeur
	// sinon certain ont passÈ, on prend le premiere joueur donc la mise est 0 
	*/
 
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