
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class FenetrePrincipale extends JFrame implements ActionListener{

	public int x;
	public int y;
	private JPanel accueil = new JPanel();
	private JPanel droite = new JPanel();
	private JPanel gauche = new JPanel();
	private JComboBox combo = new JComboBox();
	private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
	private JComboBox combo3 = new JComboBox();
	private JComboBox combo4 = new JComboBox();
	private JComboBox combo5 = new JComboBox();
	private String coul1 = "------";
	private String coul2 = "------";
	private String coul3 = "------";
	private String coul4 = "------";
	private String coul5 = "------";
	private JComboBox[] tabCombo = new JComboBox[5];
	private String[] nomLabel = { "Nom du joueur 1", "Nom du joueur 2", "Nom du joueur 3", "Nom du joueur 4", "Nom du joueur 5"};
	private JTextField[] textField = new JTextField[5];
	private JLabel[] tabLabel = new JLabel[5];

	//fonction qui met a jour toute les infos du plateau
	public void miseajour() {

	}

	public Icon gestionPile(Pile p) {
		
		if (p.getHeap().getType().matches("Banane") && p.getHeap().getNbTrav() == 1) {
			Icon banane = new ImageIcon("./images/carte/banane1pl.jpg");
			return banane;
		}

		if (p.getHeap().getType().matches("Banane") && p.getHeap().getNbTrav() == 2) {
			Icon banane = new ImageIcon("./images/carte/banane2pl.jpg");
			return banane;
		}

		if (p.getHeap().getType().matches("Poivron") && p.getHeap().getNbTrav() == 1) {
			Icon poivron = new ImageIcon("./images/carte/poivron1pl.jpg");
			return poivron;
		}

		if (p.getHeap().getType().matches("Poivron") && p.getHeap().getNbTrav() == 2) {
			Icon poivron = new ImageIcon("./images/carte/poivron2pl.jpg");
			return poivron;
		}

		if (p.getHeap().getType().matches("Canne a sucre") && p.getHeap().getNbTrav() == 1) {
			Icon canne = new ImageIcon("./images/carte/canne1pl.jpg");
			return canne;
		}

		if (p.getHeap().getType().matches("Canne a sucre") && p.getHeap().getNbTrav() == 2) {
			Icon canne = new ImageIcon("./images/carte/canne2pl.jpg");
			return canne;
		}

		if (p.getHeap().getType().matches("Haricot") && p.getHeap().getNbTrav() == 1) {
			Icon haricot = new ImageIcon("./images/carte/haricot1pl.jpg");
			return haricot;
		}

		if (p.getHeap().getType().matches("Haricot") && p.getHeap().getNbTrav() == 2) {
			Icon haricot = new ImageIcon("./images/carte/haricot2pl.jpg");
			return haricot;
		}

		if (p.getHeap().getType().matches("Pomme de terre") && p.getHeap().getNbTrav() == 1) {
			Icon patate = new ImageIcon("./images/carte/pdt1pl.jpg");
			return patate;
		}

		if (p.getHeap().getType().matches("Pomme de terre") && p.getHeap().getNbTrav() == 2) {
			Icon patate = new ImageIcon("./images/carte/pdt2pl.jpg");
			return patate;
		}
		return null;
	}
	
	
	//DIEU QUE J'EN AI CHIE POUR CETTE PUTIN DE FENETRE
	public FenetrePrincipale(int x, int y) {  			
		combo.setSize(20,70);
		combo1.setSize(20,70);
		combo2.setSize(20,70);
		combo3.setSize(20,70);
		combo4.setSize(20,70);
		combo5.setSize(20,70);

		Font font = new Font("Courier", Font.BOLD, 12);

		/*declaration des layout*/
		FlowLayout mapg = new FlowLayout();
		gauche.setLayout(mapg);

		FlowLayout mapD = new FlowLayout();
		droite.setLayout(mapD);

		/*declaration de l'image et ajout au panel*/
		JLabel image = new JLabel(new ImageIcon("./images/Santiago.jpg"));
		gauche.add(image);
		image.setBounds(0, 150, 200, 200);

		/*declaration du combobox et label associe*/
		int nbJ = combo.getSelectedIndex();
		int nbJCol = nbJ;
		JLabel label = new JLabel("Nombre de Joueur : ");
		label.setForeground(Color.white);
		droite.add(label);
		label.setBounds(50,100,30,10);
		
		combo.setPreferredSize(new Dimension(40,20));
		combo.addItem("3");
		combo.addItem("4");
		combo.addItem("5");
		combo.addActionListener(new ActionListener() {
			/*action realisee au changement du nombre de joueur dans la combo*/
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==combo){ 
					int nbJ = 4 + combo.getSelectedIndex();
					for (int i=4; i<6; i++){
						tabLabel[i-1].setVisible(false);
						textField[i-1].setVisible(false);
						tabCombo[i-1].setVisible(false);
					}
					for (int i=4; i<nbJ; i++){
						tabLabel[i-1].setVisible(true);
						textField[i-1].setVisible(true);
						tabCombo[i-1].setVisible(true);
					}
				}

			}
		});
		droite.add(combo);
		combo.setBounds(80,100,40,20);

		int[] nbP = {3,4,5};
		final JFrame f = new JFrame();
		final JTextField text = new JTextField(15);

		JButton go = new JButton("Go Negro !");
		go.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
			
				final JFrame construc = new JFrame();
				JPanel p2 = new JPanel();
				p2.setBackground(Color.black);
				final JComboBox comboConstruc = new JComboBox();
				if (Integer.parseInt((String) combo.getSelectedItem()) == 3 ) {
					comboConstruc.addItem(textField[0].getText());
					comboConstruc.addItem(textField[1].getText());
					comboConstruc.addItem(textField[2].getText());
				}
				if (Integer.parseInt((String) combo.getSelectedItem()) == 4 ) {
					comboConstruc.addItem(textField[0].getText());
					comboConstruc.addItem(textField[1].getText());
					comboConstruc.addItem(textField[2].getText());
					comboConstruc.addItem(textField[3].getText());
				}
				if (Integer.parseInt((String) combo.getSelectedItem()) == 5 ) {
					comboConstruc.addItem(textField[0].getText());
					comboConstruc.addItem(textField[1].getText());
					comboConstruc.addItem(textField[2].getText());
					comboConstruc.addItem(textField[3].getText());
					comboConstruc.addItem(textField[4].getText());
				}
				JLabel cons = new JLabel ("Qui est le constructeur ? :");

				JButton launcher = new JButton("Lancer partie");
				JButton cancel = new JButton("Annuler");
				
				p2.add(cons);
				p2.add(comboConstruc);
				
				cancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						construc.dispose();
					}
				});

				launcher.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Plateau p = new Plateau ();
						if (Integer.parseInt((String) combo.getSelectedItem()) == 3 ) {
							
							p.ChangeCanalBleu(3);
							p.ChangeTrav(66);
							if (textField[0].getText().equals("") || textField[1].getText().equals("") || textField[2].getText().equals("")){
								JOptionPane.showMessageDialog(null, "Le nom de tous les joueurs doit etre saisi !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else if (((String) tabCombo[0].getSelectedItem()).equals("------") || ((String) tabCombo[1].getSelectedItem()).equals("------") || ((String) tabCombo[2].getSelectedItem()).equals("------")){
									JOptionPane.showMessageDialog(null, "Une couleur pour chaque joueur doit etre choisie !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else{
								
								Joueur j1= new Joueur(textField[0].getText(),(String) combo1.getSelectedItem(),"j1");
								Joueur j2= new Joueur(textField[1].getText(),(String) combo2.getSelectedItem(),"j2");
								Joueur j3= new Joueur(textField[2].getText(),(String) combo3.getSelectedItem(),"j3");
	
								Pile p1 = new Pile("p1");
								Pile p2 = new Pile("p2");
								Pile p3 = new Pile("p3");
								Pile p4 = new Pile("p4");
								Pile p5 = new Pile("p5");
	
								Partie part = new Partie (p,j1,j2,j3,p1,p2,p3,p4,p.genererPile(3,p1,p2,p3,p4,p5));
								if (j1.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j1);
									j1.setEstConstruc();
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
								}	
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
								}
								FenetrePrincipale fen = new FenetrePrincipale(part);
							}

						}

						if (Integer.parseInt((String) combo.getSelectedItem()) == 4 ) {
							p.ChangeCanalBleu(4);
							p.ChangeTrav(88);
							
							if (textField[0].getText().equals("") || textField[1].getText().equals("") || textField[2].getText().equals("") || textField[3].getText().equals("")){
								JOptionPane.showMessageDialog(null, "Le nom de tous les joueurs doit etre saisi !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else if (((String) tabCombo[0].getSelectedItem()).equals("------") || ((String) tabCombo[1].getSelectedItem()).equals("------") || ((String) tabCombo[2].getSelectedItem()).equals("------") || ((String) tabCombo[3].getSelectedItem()).equals("------")){
									JOptionPane.showMessageDialog(null, "Une couleur pour chaque joueur doit etre choisie !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else{
								Joueur j1= new Joueur(textField[0].getText(),(String) combo1.getSelectedItem(),"j1");
								Joueur j2= new Joueur(textField[1].getText(),(String) combo2.getSelectedItem(),"j2");
								Joueur j3= new Joueur(textField[2].getText(),(String) combo3.getSelectedItem(),"j3");
								Joueur j4= new Joueur(textField[3].getText(),(String) combo4.getSelectedItem(),"j4");
	
								Pile p1 = new Pile("p1");
								Pile p2 = new Pile("p2");
								Pile p3 = new Pile("p3");
								Pile p4 = new Pile("p4");
								Pile p5 = new Pile("p5");
	
								Partie part = new Partie (p,j1,j2,j3,j4,p1,p2,p3,p4,p.genererPile(4,p1,p2,p3,p4,p5));
								if (j1.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j1);
									j1.setEstConstruc();	    							
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
								}
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
								}
								if (j4.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j4);
									j4.setEstConstruc();
								}

								FenetrePrincipale fen = new FenetrePrincipale(part);
							}
						}

						if (Integer.parseInt((String) combo.getSelectedItem()) == 5 ) {
							if (textField[0].getText().equals("") || textField[1].getText().equals("") || textField[2].getText().equals("") || textField[3].getText().equals("") || textField[4].getText().equals("")){
								JOptionPane.showMessageDialog(null, "Le nom de tous les joueurs doit etre saisi !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else if (((String) tabCombo[0].getSelectedItem()).equals("------") || ((String) tabCombo[1].getSelectedItem()).equals("------") || ((String) tabCombo[2].getSelectedItem()).equals("------") || ((String) tabCombo[3].getSelectedItem()).equals("------") || ((String) tabCombo[4].getSelectedItem()).equals("------")){
									JOptionPane.showMessageDialog(null, "Une couleur pour chaque joueur doit etre choisie !", "Attention !", JOptionPane.WARNING_MESSAGE);						
							}
							else{
								Joueur j1= new Joueur(textField[0].getText(),(String) combo1.getSelectedItem(),"j1");
								Joueur j2= new Joueur(textField[1].getText(),(String) combo2.getSelectedItem(),"j2");
								Joueur j3= new Joueur(textField[2].getText(),(String) combo3.getSelectedItem(),"j3");
								Joueur j4= new Joueur(textField[3].getText(),(String) combo4.getSelectedItem(),"j4");
								Joueur j5= new Joueur(textField[4].getText(),(String) combo5.getSelectedItem(),"j5");
								Pile p1 = new Pile("p1");
								Pile p2 = new Pile("p2");
								Pile p3 = new Pile("p3");
								Pile p4 = new Pile("p4");
								Pile p5 = new Pile("p5");
								p.genererPile(5,p1,p2,p3,p4,p5);
								Partie part = new Partie (p,j1,j2,j3,j4,j5,p1,p2,p3,p4,p5);
								if (j1.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j1);
									j1.setEstConstruc();
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
								}
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
								}
								if (j4.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j4);
									j4.setEstConstruc();
								}
								if (j5.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j5);
									j5.setEstConstruc();
								}
								FenetrePrincipale fen = new FenetrePrincipale(part);
							}
						}
				}}); 
				p2.add(launcher);
				p2.add(cancel);
				construc.add(p2);
				construc.setSize(300,300);
				construc.setLocationRelativeTo(null);
				construc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				construc.setVisible(true);
			} } );
		/**/
		go.setBounds(50,270,70,10);
		droite.add(go); 


		//init. des JComboBox pour le choix des couleurs des joueurs
		combo1.addItem("------");
		combo1.addItem("jaune");
		combo1.addItem("vert");
		combo1.addItem("bleu");
		combo1.addItem("rouge");
		combo1.addItem("blanc");
		combo1.addActionListener(this);
		combo2.addItem("------");
		combo2.addItem("vert");		
		combo2.addItem("rouge");
		combo2.addItem("bleu");
		combo2.addItem("blanc");
		combo2.addItem("jaune");
		combo2.addActionListener(this);
		combo3.addItem("------");	
		combo3.addItem("rouge");
		combo3.addItem("bleu");
		combo3.addItem("blanc");
		combo3.addItem("jaune");
		combo3.addItem("vert");	
		combo3.addActionListener(this);
		combo4.addItem("------");
		combo4.addItem("bleu");
		combo4.addItem("blanc");
		combo4.addItem("jaune");
		combo4.addItem("vert");		
		combo4.addItem("rouge");
		combo4.addActionListener(this);
		combo5.addItem("------");
		combo5.addItem("blanc");
		combo5.addItem("jaune");
		combo5.addItem("vert");		
		combo5.addItem("rouge");
		combo5.addItem("bleu");
		combo5.addActionListener(this);
		tabCombo[0] = combo1;
		tabCombo[1] = combo2;
		tabCombo[2] = combo3;
		tabCombo[3] = combo4;
		tabCombo[4] = combo5;

		// init. du tableau des JLabel et JTextField affich? suite au comboBox
		int ordonnee = 240;
		for (int i=0; i<nomLabel.length; i++){
			tabLabel[i] = new JLabel(nomLabel[i]);
			tabLabel[i].setFont(font);
			tabLabel[i].setForeground(Color.white);
			tabLabel[i].setVisible(false);
			droite.add(tabLabel[i]);
			textField[i] = new JTextField(12);

			textField[i].setVisible(false);

			droite.add(textField[i]);
			tabCombo[i].setVisible(false);
			droite.add(tabCombo[i]);
			ordonnee += 10;
			if ( i == 0 || i == 1 || i == 2){
				tabLabel[i].setVisible(true);
				textField[i].setVisible(true);
				tabCombo[i].setVisible(true);
			}
		}

		/*ajout des panel gauche et droite au panel de fond et placement*/
		accueil.setBackground(Color.black);
		gauche.setBackground(Color.black);
		droite.setBackground(Color.black);
		accueil.add(gauche);
		gauche.setBounds(20, 20, 320, 450);
		accueil.add(droite);
		droite.setBounds(350, 60, 350, 500);



		/*parametre de la fenetre*/
		this.setContentPane(accueil);	
		this.getContentPane().setLayout(null);
		this.setSize(x,y);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	public FenetrePrincipale (Partie p) {
		// Fenetre principale

		/*
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		device.setFullScreenWindow(this);*/

		this.setTitle("Hisse et ho, Santiago!");
		this.setSize(1200,728);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		this.setResizable(true);
		
		JPanel panneauPrinc = new JPanel();
		panneauPrinc.setLayout(null);
		Color col = new Color(0,0,0);
		panneauPrinc.setBackground(col); 
		this.setContentPane(panneauPrinc);

		// Je place mon plateau 
		Panneau plateau = new Panneau("./images/plateau.jpg", 801,600,100,100,0,0);
		plateau.setBounds(801, 600, 15, 54);
		plateau.setLayout(null);
		panneauPrinc.add(plateau);


		// Icon de friche
		Icon friche = new ImageIcon("./images/friche.jpg");
		Icon fricheCol = new ImageIcon("./images/colonneFriche.jpg");
		Icon fricheLig = new ImageIcon("./images/LigneFriche.jpg");
		Icon ficheInter = new ImageIcon("./images/InterFriche.jpg");
		Icon sourceImage = new ImageIcon("./images/source.jpg");
		final Icon eaucol = new ImageIcon("./images/eaucol.jpg");
		final Icon eaulig = new ImageIcon("./images/eaulig.jpg");
		final Icon constructeurImage = new ImageIcon("./images/construc.jpg");
		//Plateau 
		//Rang 1
		JButton carte1 = new JButton(friche);
		carte1.setBounds(23,17,90,90);
		plateau.add(carte1);

		JButton carte2 = new JButton(friche);
		carte2.setBounds(114,17,90,90);
		plateau.add(carte2);

		JButton carte3 = new JButton(friche);
		carte3.setBounds(215,17,90,90);
		plateau.add(carte3);

		JButton carte4 = new JButton(friche);
		carte4.setBounds(306,17,90,90);
		plateau.add(carte4);

		JButton carte5 = new JButton(friche);
		carte5.setBounds(407,17,90,90);
		plateau.add(carte5);

		JButton carte6 = new JButton(friche);
		carte6.setBounds(498,17,90,90);
		plateau.add(carte6);

		JButton carte7 = new JButton(friche);
		carte7.setBounds(599,17,90,90);
		plateau.add(carte7);

		JButton carte8 = new JButton(friche);
		carte8.setBounds(690,17,90,90);
		plateau.add(carte8);

		//Rang 2
		JButton carte9 = new JButton(friche);
		carte9.setBounds(23,108,90,90);
		plateau.add(carte9);

		JButton carte10 = new JButton(friche);
		carte10.setBounds(114,108,90,90);
		plateau.add(carte10);

		JButton carte11 = new JButton(friche);
		carte11.setBounds(215,108,90,90);
		plateau.add(carte11);

		JButton carte12 = new JButton(friche);
		carte12.setBounds(306,108,90,90);
		plateau.add(carte12);

		JButton carte13 = new JButton(friche);
		carte13.setBounds(407,108,90,90);
		plateau.add(carte13);

		JButton carte14 = new JButton(friche);
		carte14.setBounds(498,108,90,90);
		plateau.add(carte14);

		JButton carte15 = new JButton(friche);
		carte15.setBounds(599,108,90,90);
		plateau.add(carte15);

		JButton carte16 = new JButton(friche);
		carte16.setBounds(690,108,90,90);
		plateau.add(carte16);

		//rang 3

		JButton carte17 = new JButton(friche);
		carte17.setBounds(23,208,90,90);
		plateau.add(carte17);

		JButton carte18 = new JButton(friche);
		carte18.setBounds(114,208,90,90);
		plateau.add(carte18);

		JButton carte19 = new JButton(friche);
		carte19.setBounds(215,208,90,90);
		plateau.add(carte19);

		JButton carte20 = new JButton(friche);
		carte20.setBounds(306,208,90,90);
		plateau.add(carte20);

		JButton carte21 = new JButton(friche);
		carte21.setBounds(407,208,90,90);
		plateau.add(carte21);

		JButton carte22 = new JButton(friche);
		carte22.setBounds(498,208,90,90);
		plateau.add(carte22);

		JButton carte23 = new JButton(friche);
		carte23.setBounds(599,208,90,90);
		plateau.add(carte23);

		JButton carte24 = new JButton(friche);
		carte24.setBounds(690,208,90,90);
		plateau.add(carte24);

		// rang 4
		JButton carte25= new JButton(friche);
		carte25.setBounds(23,299,90,90);
		plateau.add(carte25);

		JButton carte26 = new JButton(friche);
		carte26.setBounds(114,299,90,90);
		plateau.add(carte26);

		JButton carte27 = new JButton(friche);
		carte27.setBounds(215,299,90,90);
		plateau.add(carte27);

		JButton carte28 = new JButton(friche);
		carte28.setBounds(306,299,90,90);
		plateau.add(carte28);

		JButton carte29 = new JButton(friche);
		carte29.setBounds(407,299,90,90);
		plateau.add(carte29);

		JButton carte30 = new JButton(friche);
		carte30.setBounds(498,299,90,90);
		plateau.add(carte30);

		JButton carte31 = new JButton(friche);
		carte31.setBounds(599,299,90,90);
		plateau.add(carte31);

		JButton carte32 = new JButton(friche);
		carte32.setBounds(690,299,90,90);
		plateau.add(carte32);

		//rang 4

		JButton carte33 = new JButton(friche);
		carte33.setBounds(23,399,90,90);
		plateau.add(carte33);

		JButton carte34 = new JButton(friche);
		carte34.setBounds(114,399,90,90);
		plateau.add(carte34);

		JButton carte35 = new JButton(friche);
		carte35.setBounds(215,399,90,90);
		plateau.add(carte35);

		JButton carte36 = new JButton(friche);
		carte36.setBounds(306,399,90,90);
		plateau.add(carte36);

		JButton carte37 = new JButton(friche);
		carte37.setBounds(407,399,90,90);
		plateau.add(carte37);

		JButton carte38 = new JButton(friche);
		carte38.setBounds(498,399,90,90);
		plateau.add(carte38);

		JButton carte39 = new JButton(friche);
		carte39.setBounds(599,399,90,90);
		plateau.add(carte39);

		JButton carte40 = new JButton(friche);
		carte40.setBounds(690,399,90,90);
		plateau.add(carte40);

		// rang 4
		JButton carte41= new JButton(friche);
		carte41.setBounds(23,490,90,90);
		plateau.add(carte41);

		JButton carte42 = new JButton(friche);
		carte42.setBounds(114,490,90,90);
		plateau.add(carte42);

		JButton carte43 = new JButton(friche);
		carte43.setBounds(215,490,90,90);
		plateau.add(carte43);

		JButton carte44 = new JButton(friche);
		carte44.setBounds(306,490,90,90);
		plateau.add(carte44);

		JButton carte45 = new JButton(friche);
		carte45.setBounds(407,490,90,90);
		plateau.add(carte45);

		JButton carte46 = new JButton(friche);
		carte46.setBounds(498,490,90,90);
		plateau.add(carte46);

		JButton carte47 = new JButton(friche);
		carte47.setBounds(599,490,90,90);
		plateau.add(carte47);

		JButton carte48 = new JButton(friche);
		carte48.setBounds(690,490,90,90);
		plateau.add(carte48);

		//Colonne de friche

		final JButton col1 = new JButton(fricheCol);
		col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col1.setIcon(eaucol);
			}
		});

		col1.setBounds(204,17,12,181);
		plateau.add(col1);

		final JButton col2 = new JButton(fricheCol);
		col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col2.setIcon(eaucol);
			}
		});
		col2.setBounds(14,17,10,181);
		plateau.add(col2);

		final JButton col3 = new JButton(fricheCol);
		col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col3.setIcon(eaucol);
			}
		});
		col3.setBounds(396,17,12,181);
		plateau.add(col3);

		final JButton col4 = new JButton(fricheCol);
		col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col4.setIcon(eaucol);
			}
		});
		col4.setBounds(588,17,12,181);
		plateau.add(col4);

		final JButton col5 = new JButton(fricheCol);
		col5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col5.setIcon(eaucol);
			}
		});
		col5.setBounds(780,17,7,181);
		plateau.add(col5);

		final JButton col6 = new JButton(fricheCol);
		col6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col6.setIcon(eaucol);
			}
		});
		col6.setBounds(204,208,12,181);
		plateau.add(col6);

		final JButton col7 = new JButton(fricheCol);
		col7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col7.setIcon(eaucol);
			}
		});
		col7.setBounds(14,208,10,181);
		plateau.add(col7);

		final JButton col8 = new JButton(fricheCol);
		col8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col8.setIcon(eaucol);
			}
		});
		col8.setBounds(396,208,12,181);
		plateau.add(col8);

		final JButton col9 = new JButton(fricheCol);
		col9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col9.setIcon(eaucol);
			}
		});
		col9.setBounds(588,208,12,181);
		plateau.add(col9);

		final JButton col10 = new JButton(fricheCol);
		col10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col10.setIcon(eaucol);
			}
		});
		col10.setBounds(780,208,7,181);
		plateau.add(col10);

		final JButton col11 = new JButton(fricheCol);
		col11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col11.setIcon(eaucol);
			}
		});
		col11.setBounds(204,399,12,181);
		plateau.add(col11);

		final JButton col12 = new JButton(fricheCol);
		col12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col12.setIcon(eaucol);
			}
		});
		col12.setBounds(14,399,10,181);
		plateau.add(col12);

		final JButton col13 = new JButton(fricheCol);
		col13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col13.setIcon(eaucol);
			}
		});
		col13.setBounds(396,399,12,181);
		plateau.add(col13);

		final JButton col14 = new JButton(fricheCol);
		col14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col14.setIcon(eaucol);
			}
		});
		col14.setBounds(588,399,12,181);
		plateau.add(col14);

		final JButton col15 = new JButton(fricheCol);
		col15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col15.setIcon(eaucol);
			}
		});
		col15.setBounds(780,399,7,181);
		plateau.add(col15);

		//Lignes de friche

		final JButton lig1 = new JButton(fricheLig);
		lig1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig1.setIcon(eaulig);
			}
		});
		lig1.setBounds(23,7,181,10);
		plateau.add(lig1);

		final JButton lig2 = new JButton(fricheLig);
		lig2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig2.setIcon(eaulig);
			}
		});
		lig2.setBounds(215,7,181,10);
		plateau.add(lig2);

		final JButton lig3 = new JButton(fricheLig);
		lig3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig3.setIcon(eaulig);
			}
		});
		lig3.setBounds(407,7,181,10);
		plateau.add(lig3);

		final JButton lig4 = new JButton(fricheLig);
		lig4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig4.setIcon(eaulig);
			}
		});
		lig4.setBounds(599,7,181,10);
		plateau.add(lig4);

		final JButton lig5 = new JButton(fricheLig);
		lig5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig5.setIcon(eaulig);
			}
		});
		lig5.setBounds(23,198,181,10);
		plateau.add(lig5);

		final JButton lig6 = new JButton(fricheLig);
		lig6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig6.setIcon(eaulig);
			}
		});
		lig6.setBounds(407,198,181,10);
		plateau.add(lig6);

		final JButton lig7 = new JButton(fricheLig);
		lig7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig7.setIcon(eaulig);
			}
		});
		lig7.setBounds(599,198,181,10);
		plateau.add(lig7);

		final JButton lig8 = new JButton(fricheLig);
		lig8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig8.setIcon(eaulig);
			}
		});
		lig8.setBounds(215,198,181,10);
		plateau.add(lig8);
		this.setVisible(true);

		final JButton lig9 = new JButton(fricheLig);
		lig9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig9.setIcon(eaulig);
			}
		});
		lig9.setBounds(23,389,181,10);
		plateau.add(lig9);

		final JButton lig10 = new JButton(fricheLig);
		lig10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig10.setIcon(eaulig);
			}
		});
		lig10.setBounds(407,389,181,10);
		plateau.add(lig10);

		final JButton lig11 = new JButton(fricheLig);
		lig11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig11.setIcon(eaulig);
			}
		});
		lig11.setBounds(599,389,181,10);
		plateau.add(lig11);

		final JButton lig12 = new JButton(fricheLig);
		lig12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig12.setIcon(eaulig);
			}
		});
		lig12.setBounds(215,389,181,10);
		plateau.add(lig12);
		this.setVisible(true);

		final JButton lig13 = new JButton(fricheLig);
		lig13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig13.setIcon(eaulig);
			}
		});
		lig13.setBounds(23,579,181,13);
		plateau.add(lig13);

		final JButton lig14 = new JButton(fricheLig);
		lig14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig14.setIcon(eaulig);
			}
		});
		lig14.setBounds(407,579,181,13);
		plateau.add(lig14);

		final JButton lig15 = new JButton(fricheLig);
		lig15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig15.setIcon(eaulig);
			}
		});
		lig15.setBounds(599,579,181,13);
		plateau.add(lig15);

		final JButton lig16 = new JButton(fricheLig);
		lig16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig16.setIcon(eaulig);
			}
		});
		lig16.setBounds(215,579,181,13);
		plateau.add(lig16);

		// Les intersections maintenant ! 

		JButton inter1 = new JButton(ficheInter);
		inter1.setBounds(13,7,11,11);
		plateau.add(inter1);

		JButton inter2 = new JButton(ficheInter);
		inter2.setBounds(204,7,11,11);
		plateau.add(inter2);

		JButton inter3 = new JButton(ficheInter);
		inter3.setBounds(396,7,11,11);
		plateau.add(inter3);

		JButton inter4 = new JButton(ficheInter);
		inter4.setBounds(588,7,11,11);
		plateau.add(inter4);

		JButton inter5 = new JButton(ficheInter);
		inter5.setBounds(778,7,9,11);
		plateau.add(inter5);


		JButton inter6 = new JButton(ficheInter);
		inter6.setBounds(13,198,11,11);
		plateau.add(inter6);

		JButton inter7 = new JButton(ficheInter);
		inter7.setBounds(204,198,11,11);
		plateau.add(inter7);

		JButton inter8 = new JButton(ficheInter);
		inter8.setBounds(396,198,11,11);
		plateau.add(inter8);

		JButton inter9 = new JButton(ficheInter);
		inter9.setBounds(588,198,11,11);
		plateau.add(inter9);

		JButton inter10 = new JButton(ficheInter);
		inter10.setBounds(778,198,9,11);
		plateau.add(inter10);

		JButton inter11 = new JButton(ficheInter);
		inter11.setBounds(13,389,11,11);
		plateau.add(inter11);

		JButton inter12 = new JButton(ficheInter);
		inter12.setBounds(204,389,11,11);
		plateau.add(inter12);

		JButton inter13 = new JButton(ficheInter);
		inter13.setBounds(396,389,11,11);
		plateau.add(inter13);

		JButton inter14 = new JButton(ficheInter);
		inter14.setBounds(588,389,11,11);
		plateau.add(inter14);

		JButton inter15 = new JButton(ficheInter);
		inter15.setBounds(778,389,9,11);
		plateau.add(inter15);


		JButton inter16 = new JButton(ficheInter);
		inter16.setBounds(13,579,11,13);
		plateau.add(inter16);

		JButton inter17 = new JButton(ficheInter);
		inter17.setBounds(204,579,11,13);
		plateau.add(inter17);

		JButton inter18 = new JButton(ficheInter);
		inter18.setBounds(396,579,11,13);
		plateau.add(inter18);

		JButton inter19 = new JButton(ficheInter);
		inter19.setBounds(588,579,11,13);
		plateau.add(inter19);

		JButton inter20 = new JButton(ficheInter);
		inter20.setBounds(778,579,9,13);
		plateau.add(inter20);

		// Bouton de sortie

		JButton sortie = new JButton("Quitter");
		sortie.setText("Quitter");
		sortie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		sortie.setBounds(1000, 0, 100, 50);
		panneauPrinc.add(sortie);

		//Gestion des cartes
		JButton carteretire = new JButton();
		if (p.nbP != 5) {
			if (p.getTuile().getType().matches("Banane") && p.getTuile().getNbTrav() == 1) {
				Icon banane = new ImageIcon("./images/carte/banane1pl.jpg");
				carteretire.setIcon(banane);
			}

			if (p.getTuile().getType().matches("Banane") && p.getTuile().getNbTrav() == 2) {
				Icon banane = new ImageIcon("./images/carte/banane2pl.jpg");
				carteretire.setIcon(banane);
			}

			if (p.getTuile().getType().matches("Poivron") && p.getTuile().getNbTrav() == 1) {
				Icon poivron = new ImageIcon("./images/carte/poivron1pl.jpg");
				carteretire.setIcon(poivron);
			}

			if (p.getTuile().getType().matches("Poivron") && p.getTuile().getNbTrav() == 2) {
				Icon poivron = new ImageIcon("./images/carte/poivron2pl.jpg");
				carteretire.setIcon(poivron);
			}

			if (p.getTuile().getType().matches("Canne a sucre") && p.getTuile().getNbTrav() == 1) {
				Icon canne = new ImageIcon("./images/carte/canne1pl.jpg");
				carteretire.setIcon(canne);
			}

			if (p.getTuile().getType().matches("Canne a sucre") && p.getTuile().getNbTrav() == 2) {
				Icon canne = new ImageIcon("./images/carte/canne2pl.jpg");
				carteretire.setIcon(canne);
			}

			if (p.getTuile().getType().matches("Haricot") && p.getTuile().getNbTrav() == 1) {
				Icon haricot = new ImageIcon("./images/carte/haricot1pl.jpg");
				carteretire.setIcon(haricot);
			}

			if (p.getTuile().getType().matches("Haricot") && p.getTuile().getNbTrav() == 2) {
				Icon haricot = new ImageIcon("./images/carte/haricot2pl.jpg");
				carteretire.setIcon(haricot);
			}

			if (p.getTuile().getType().matches("Pomme de terre") && p.getTuile().getNbTrav() == 1) {
				Icon patate = new ImageIcon("./images/carte/pdt1pl.jpg");
				carteretire.setIcon(patate);
			}

			if (p.getTuile().getType().matches("Pomme de terre") && p.getTuile().getNbTrav() == 2) {
				Icon patate = new ImageIcon("./images/carte/pdt2pl.jpg");
				carteretire.setIcon(patate);
			}
		}
		// Gestion des joueurs.
		
		//J2
		
		JLabel nom2 = new JLabel();
		nom2.setText(p.j2.getNom());
		nom2.setBounds(1050, 175, 50, 50);
		panneauPrinc.add(nom2);
		
		Icon poin1 = new ImageIcon("./images/pion1.jpg");
		JButton j2 = new JButton(poin1);
		j2.setBounds(1050,210, 70, 82);
		panneauPrinc.add(j2);

		Icon portemonnaie = new ImageIcon("./images/portemonnaie.jpg");
		/*JButton porte2 = new JButton(portemonnaie);
		porte2.setBounds(1130,205, 40, 40);
		panneauPrinc.add(porte2); */

		if (p.j2.checkEstConstruc()) {
			JButton cstru = new JButton(constructeurImage);
			cstru.setBounds(1130,250, 40, 40);
			panneauPrinc.add(cstru);
		}

		JLabel argentj2 = new JLabel();
		argentj2.setText(""+p.j2.getmoney());
		argentj2.setBounds(1130, 210, 50, 10);
		panneauPrinc.add(argentj2);

		JLabel escudos = new JLabel("escudos");
		escudos.setText("Escudos");
		escudos.setBounds(1150, 205, 50, 20);
		panneauPrinc.add(escudos);

		//Affichage du nombre de canal dispo
		// IL RESTE A FAIRE DE MEME POUR LE J1 J3 J4 J5 
		JLabel canalj2 = new JLabel();
		canalj2.setText(""+p.j2.getNbCanalBleu());
		canalj2.setBounds(1180, 230, 20, 10);
		panneauPrinc.add(canalj2);

		Icon can2 = new ImageIcon("./images/eaulig.jpg");
		JButton canal2 = new JButton(can2);
		canal2.setBounds(1200,230,30,10);
		panneauPrinc.add(canal2);



		//J1
		
		JLabel nom1 = new JLabel();
		nom1.setText(p.j1.getNom());
		nom1.setBounds(1050, 75, 50, 50);
		panneauPrinc.add(nom1);
		
		Icon poin2 = new ImageIcon("./images/pion1.jpg");
		JButton j1 = new JButton(poin1);
		j1.setBounds(980,110, 70, 82);
		panneauPrinc.add(j1);

		if (p.j1.checkEstConstruc()) {
			JButton cstru = new JButton(constructeurImage);
			cstru.setBounds(1130,150, 40, 40);
			panneauPrinc.add(cstru);
		}

		JLabel argentj1 = new JLabel();
		argentj1.setText(""+p.j1.getmoney());
		argentj1.setBounds(1000, 115, 20, 10);
		panneauPrinc.add(argentj1);

		JLabel escudos2 = new JLabel("escudos");
		escudos2.setText("Escudos");
		escudos2.setBounds(1150, 110, 50, 20);
		panneauPrinc.add(escudos2);


		//J3
		Icon poin3 = new ImageIcon("./images/pion1.jpg");
		JButton j3 = new JButton(poin1);
		j3.setBounds(980,310, 70, 82);
		panneauPrinc.add(j3);


		/*JButton porte3 = new JButton(portemonnaie);
		porte3.setBounds(1130,305, 40, 40);
		panneauPrinc.add(porte3)*/

		if (p.j3.checkEstConstruc()) {
			JButton cstru = new JButton(constructeurImage);
			cstru.setBounds(1130,350, 40, 40);
			panneauPrinc.add(cstru);
		}

		JLabel argentj3 = new JLabel();
		argentj3.setText(""+p.j2.getmoney());
		argentj3.setBounds(1130, 315, 20, 10);
		panneauPrinc.add(argentj3);

		JLabel escudos3 = new JLabel("escudos");
		escudos3.setText("Escudos");
		escudos3.setBounds(1150, 310, 50, 20);
		panneauPrinc.add(escudos3);

		if (p.nbP == 3 || p.nbP== 4) {
			JLabel carteRemoved = new JLabel();
			carteRemoved.setText("On a retir�: ");
			carteRemoved.setBounds(900,600, 100, 20);
			panneauPrinc.add(carteRemoved);
			carteretire.setBounds(1000,600, 90, 90);
			panneauPrinc.add(carteretire);
		}



		if (p.nbP > 3) {
			//J4
			Icon poin4 = new ImageIcon("./images/pion1.jpg");
			JButton j4 = new JButton(poin1);
			j4.setBounds(980,400, 70, 82);
			panneauPrinc.add(j4);

			/*JButton porte4 = new JButton(portemonnaie);
			porte4.setBounds(1130,405, 40, 40);
			panneauPrinc.add(porte4);*/

			if (p.j4.checkEstConstruc()) {
				JButton cstru = new JButton(constructeurImage);
				cstru.setBounds(1130,440, 40, 40);
				panneauPrinc.add(cstru);
			}
			JLabel argentj4 = new JLabel();
			argentj4.setText(""+p.j2.getmoney());
			argentj4.setBounds(1130, 415, 20, 10);
			panneauPrinc.add(argentj4);

			JLabel escudos4 = new JLabel("escudos");
			escudos4.setText("Escudos");
			escudos4.setBounds(1150, 410, 50, 20);
			panneauPrinc.add(escudos4);

			if (p.nbP == 5) {
				//J5
				Icon poin5 = new ImageIcon("./images/pion1.jpg");
				JButton j5 = new JButton(poin1);
				j5.setBounds(980,500, 70, 82);
				panneauPrinc.add(j5);

				/*JButton porte5 = new JButton(portemonnaie);
				porte5.setBounds(1130,505, 40, 40);
				panneauPrinc.add(porte5);*/

				if (p.j5.checkEstConstruc()) {
					JButton cstru = new JButton(constructeurImage);
					cstru.setBounds(1130,540, 40, 40);
					panneauPrinc.add(cstru);
				}

				JLabel argentj5 = new JLabel();
				argentj5.setText(""+p.j5.getmoney());
				argentj5.setBounds(1130, 515, 20, 10);
				panneauPrinc.add(argentj5);

				JLabel escudos5 = new JLabel("escudos");
				escudos5.setText("Escudos");
				escudos5.setBounds(1150, 510, 50, 20);
				panneauPrinc.add(escudos5);


			}	
		}
		// Affichage des piles
		JButton pile1 = new JButton(gestionPile(p.p1));
		pile1.setBounds(200,2, 90, 90);
		panneauPrinc.add(pile1);

		JButton pile2 = new JButton(gestionPile(p.p2));
		pile2.setBounds(350,2, 90, 90);
		panneauPrinc.add(pile2);
		
		JButton pile3 = new JButton(gestionPile(p.p3));
		pile3.setBounds(500,2, 90, 90);
		panneauPrinc.add(pile3);
		
		JButton pile4 = new JButton(gestionPile(p.p4));
		pile4.setBounds(650,2, 90, 90);
		panneauPrinc.add(pile4);
		
		if (p.getNbp() == 5) {
			JButton pile5 = new JButton(gestionPile(p.p5));
			pile5.setBounds(800,2, 90, 90);
			panneauPrinc.add(pile5);
		}
		
	
		this.setVisible(true);
	
		// debut du code de la partie
		int nbTour;

		JButton[] source = {inter1,inter2,inter3,inter4,inter5,inter6,inter7,inter8,inter9,inter10,inter11,inter12,inter13,inter14,inter15,inter16,inter17,inter18,inter19,inter20};    
		Random rnd = new Random();
		int x = rnd.nextInt(20);
		p.getPlat().setSource(source[x]);
		
		source[x].setIcon(sourceImage);

		if (p.getNbp() == 3 ) {
			nbTour = 11;
			p.getPlat().ChangeCanalBleu(3);
			p.getPlat().ChangeTrav(66);
		}  else if (p.getNbp()==4) {
			nbTour = 11;
			p.getPlat().ChangeCanalBleu(4);
			p.getPlat().ChangeTrav(88);
		} else if (p.getNbp()==5) {
			nbTour = 9;
			p.getPlat().ChangeCanalBleu(5);
			p.getPlat().ChangeTrav(100);
		}
		
		p.mise(panneauPrinc,p);
		System.out.println(p.j1.getmise());
		System.out.println(p.j2.getmise());
		System.out.println(p.j3.getmise());
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==combo1){
			String newVal = (String) combo1.getSelectedItem();
			if (newVal.equals("------")){
				combo2.addItem(coul1);	
				combo3.addItem(coul1);
				combo4.addItem(coul1);
				combo5.addItem(coul1);
				coul1="------";
			}
			if (newVal.equals("jaune")){
				if (!(coul1.equals("------"))){
					combo2.addItem(coul1);	
					combo3.addItem(coul1);
					combo4.addItem(coul1);
					combo5.addItem(coul1);
					coul1="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}else{
					coul1="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}
			}
			if (newVal.equals("vert")){
				if (!(coul1.equals("------"))){
					combo2.addItem(coul1);	
					combo3.addItem(coul1);
					combo4.addItem(coul1);
					combo5.addItem(coul1);
					coul1="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
				else{
					coul1="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
			}
			if (newVal.equals("bleu")){
				if(!(coul1.equals("------"))){
					combo2.addItem(coul1);	
					combo3.addItem(coul1);
					combo4.addItem(coul1);
					combo5.addItem(coul1);
					coul1="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}else{
					coul1="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}
			}
			if (newVal.equals("rouge")){
				if(!(coul1.equals("------"))){
					combo2.addItem(coul1);	
					combo3.addItem(coul1);
					combo4.addItem(coul1);
					combo5.addItem(coul1);
					coul1="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}else{
					coul1="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}
			}
			if (newVal.equals("blanc")){
				if(!(coul1.equals("------"))){
					combo2.addItem(coul1);	
					combo3.addItem(coul1);
					combo4.addItem(coul1);
					combo5.addItem(coul1);
					coul1="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}else{
					coul1="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}
			}
		}
		if (e.getSource()==combo2){
			String newVal = (String) combo2.getSelectedItem();
			if (newVal.equals("------")){
				combo1.addItem(coul2);	
				combo3.addItem(coul2);
				combo4.addItem(coul2);
				combo5.addItem(coul2);
				coul2="------";
			}
			if (newVal.equals("jaune")){
				if (!(coul2.equals("------"))){
					combo1.addItem(coul2);	
					combo3.addItem(coul2);
					combo4.addItem(coul2);
					combo5.addItem(coul2);
					coul2="jaune";
					combo1.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}else{
					coul2="jaune";
					combo1.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}
			}
			if (newVal.equals("vert")){
				if (!(coul2.equals("------"))){
					combo1.addItem(coul2);	
					combo3.addItem(coul2);
					combo4.addItem(coul2);
					combo5.addItem(coul2);
					coul2="vert";
					combo1.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
				else{
					coul2="vert";
					combo1.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
			}
			if (newVal.equals("bleu")){
				if(!(coul2.equals("------"))){
					combo1.addItem(coul2);	
					combo3.addItem(coul2);
					combo4.addItem(coul2);
					combo5.addItem(coul2);
					coul2="bleu";
					combo1.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}else{
					coul2="bleu";
					combo1.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}
			}
			if (newVal.equals("rouge")){
				if(!(coul2.equals("------"))){
					combo1.addItem(coul2);	
					combo3.addItem(coul2);
					combo4.addItem(coul2);
					combo5.addItem(coul2);
					coul2="rouge";
					combo1.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}else{
					coul2="rouge";
					combo1.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}
			}
			if (newVal.equals("blanc")){
				if(!(coul2.equals("------"))){
					combo1.addItem(coul2);	
					combo3.addItem(coul2);
					combo4.addItem(coul2);
					combo5.addItem(coul2);
					coul2="blanc";
					combo1.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}else{
					coul2="blanc";
					combo1.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}
			}
		}
		if (e.getSource()==combo3){
			String newVal = (String) combo3.getSelectedItem();
			if (newVal.equals("------")){
				combo2.addItem(coul3);	
				combo1.addItem(coul3);
				combo4.addItem(coul3);
				combo5.addItem(coul3);
				coul3="------";
			}
			if (newVal.equals("jaune")){
				if (!(coul3.equals("------"))){
					combo2.addItem(coul3);	
					combo1.addItem(coul3);
					combo4.addItem(coul3);
					combo5.addItem(coul3);
					coul3="jaune";
					combo2.removeItem("jaune");
					combo1.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}else{
					coul3="jaune";
					combo2.removeItem("jaune");
					combo1.removeItem("jaune");
					combo4.removeItem("jaune");
					combo5.removeItem("jaune");
				}
			}
			if (newVal.equals("vert")){
				if (!(coul3.equals("------"))){
					combo2.addItem(coul3);	
					combo1.addItem(coul3);
					combo4.addItem(coul3);
					combo5.addItem(coul3);
					coul3="vert";
					combo2.removeItem("vert");
					combo1.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
				else{
					coul3="vert";
					combo2.removeItem("vert");
					combo1.removeItem("vert");
					combo4.removeItem("vert");
					combo5.removeItem("vert");
				}
			}
			if (newVal.equals("bleu")){
				if(!(coul3.equals("------"))){
					combo2.addItem(coul3);	
					combo1.addItem(coul3);
					combo4.addItem(coul3);
					combo5.addItem(coul3);
					coul3="bleu";
					combo2.removeItem("bleu");
					combo1.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}else{
					coul3="bleu";
					combo2.removeItem("bleu");
					combo1.removeItem("bleu");
					combo4.removeItem("bleu");
					combo5.removeItem("bleu");
				}
			}
			if (newVal.equals("rouge")){
				if(!(coul3.equals("------"))){
					combo2.addItem(coul3);	
					combo1.addItem(coul3);
					combo4.addItem(coul3);
					combo5.addItem(coul3);
					coul3="rouge";
					combo2.removeItem("rouge");
					combo1.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}else{
					coul3="rouge";
					combo2.removeItem("rouge");
					combo1.removeItem("rouge");
					combo4.removeItem("rouge");
					combo5.removeItem("rouge");
				}
			}
			if (newVal.equals("blanc")){
				if(!(coul3.equals("------"))){
					combo2.addItem(coul3);	
					combo1.addItem(coul3);
					combo4.addItem(coul3);
					combo5.addItem(coul3);
					coul3="blanc";
					combo2.removeItem("blanc");
					combo1.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}else{
					coul3="blanc";
					combo2.removeItem("blanc");
					combo1.removeItem("blanc");
					combo4.removeItem("blanc");
					combo5.removeItem("blanc");
				}
			}
		}
		if (e.getSource()==combo4){
			String newVal = (String) combo4.getSelectedItem();
			if (newVal.equals("------")){
				combo2.addItem(coul4);	
				combo3.addItem(coul4);
				combo1.addItem(coul4);
				combo5.addItem(coul4);
				coul4="------";
			}
			if (newVal.equals("jaune")){
				if (!(coul4.equals("------"))){
					combo2.addItem(coul4);	
					combo3.addItem(coul4);
					combo1.addItem(coul4);
					combo5.addItem(coul4);
					coul4="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo1.removeItem("jaune");
					combo5.removeItem("jaune");
				}else{
					coul4="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo1.removeItem("jaune");
					combo5.removeItem("jaune");
				}
			}
			if (newVal.equals("vert")){
				if (!(coul4.equals("------"))){
					combo2.addItem(coul4);	
					combo3.addItem(coul4);
					combo1.addItem(coul4);
					combo5.addItem(coul4);
					coul4="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo1.removeItem("vert");
					combo5.removeItem("vert");
				}
				else{
					coul4="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo1.removeItem("vert");
					combo5.removeItem("vert");
				}
			}
			if (newVal.equals("bleu")){
				if(!(coul4.equals("------"))){
					combo2.addItem(coul4);	
					combo3.addItem(coul4);
					combo1.addItem(coul4);
					combo5.addItem(coul4);
					coul4="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo1.removeItem("bleu");
					combo5.removeItem("bleu");
				}else{
					coul4="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo1.removeItem("bleu");
					combo5.removeItem("bleu");
				}
			}
			if (newVal.equals("rouge")){
				if(!(coul4.equals("------"))){
					combo2.addItem(coul4);	
					combo3.addItem(coul4);
					combo1.addItem(coul4);
					combo5.addItem(coul4);
					coul4="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo1.removeItem("rouge");
					combo5.removeItem("rouge");
				}else{
					coul4="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo1.removeItem("rouge");
					combo5.removeItem("rouge");
				}
			}
			if (newVal.equals("blanc")){
				if(!(coul4.equals("------"))){
					combo2.addItem(coul4);	
					combo3.addItem(coul4);
					combo1.addItem(coul4);
					combo5.addItem(coul4);
					coul4="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo1.removeItem("blanc");
					combo5.removeItem("blanc");
				}else{
					coul4="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo1.removeItem("blanc");
					combo5.removeItem("blanc");
				}
			}
		}
		if (e.getSource()==combo5){
			String newVal = (String) combo5.getSelectedItem();
			if (newVal.equals("------")){
				combo2.addItem(coul5);	
				combo3.addItem(coul5);
				combo4.addItem(coul5);
				combo1.addItem(coul5);
				coul5="------";
			}
			if (newVal.equals("jaune")){
				if (!(coul5.equals("------"))){
					combo2.addItem(coul5);	
					combo3.addItem(coul5);
					combo4.addItem(coul5);
					combo1.addItem(coul5);
					coul5="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo1.removeItem("jaune");
				}else{
					coul5="jaune";
					combo2.removeItem("jaune");
					combo3.removeItem("jaune");
					combo4.removeItem("jaune");
					combo1.removeItem("jaune");
				}
			}
			if (newVal.equals("vert")){
				if (!(coul5.equals("------"))){
					combo2.addItem(coul5);	
					combo3.addItem(coul5);
					combo4.addItem(coul5);
					combo1.addItem(coul5);
					coul5="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo1.removeItem("vert");
				}
				else{
					coul5="vert";
					combo2.removeItem("vert");
					combo3.removeItem("vert");
					combo4.removeItem("vert");
					combo1.removeItem("vert");
				}
			}
			if (newVal.equals("bleu")){
				if(!(coul5.equals("------"))){
					combo2.addItem(coul5);	
					combo3.addItem(coul5);
					combo4.addItem(coul5);
					combo1.addItem(coul5);
					coul5="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo1.removeItem("bleu");
				}else{
					coul5="bleu";
					combo2.removeItem("bleu");
					combo3.removeItem("bleu");
					combo4.removeItem("bleu");
					combo1.removeItem("bleu");
				}
			}
			if (newVal.equals("rouge")){
				if(!(coul5.equals("------"))){
					combo2.addItem(coul5);	
					combo3.addItem(coul5);
					combo4.addItem(coul5);
					combo1.addItem(coul5);
					coul5="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo1.removeItem("rouge");
				}else{
					coul5="rouge";
					combo2.removeItem("rouge");
					combo3.removeItem("rouge");
					combo4.removeItem("rouge");
					combo1.removeItem("rouge");
				}
			}
			if (newVal.equals("blanc")){
				if(!(coul5.equals("------"))){
					combo2.addItem(coul5);	
					combo3.addItem(coul5);
					combo4.addItem(coul5);
					combo1.addItem(coul5);
					coul1="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo1.removeItem("blanc");
				}else{
					coul5="blanc";
					combo2.removeItem("blanc");
					combo3.removeItem("blanc");
					combo4.removeItem("blanc");
					combo1.removeItem("blanc");
				}
			}
		}
	}
}
