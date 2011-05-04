
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
	private Icon chemin;
	private Icon chemin2;
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
	
	Icon bleucol = new ImageIcon("./images/bleucol.jpg");
	Icon vertcol = new ImageIcon("./images/vertcol.jpg");
	Icon blanccol = new ImageIcon("./images/blanccol.jpg");
	Icon rougecol = new ImageIcon("./images/rougecol.jpg");
	Icon jaunecol = new ImageIcon("./images/jaunecol.jpg");
	private JPanel c1 = new JPanel();

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
									part.setalamain(j1);
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
									part.setalamain(j2);
								}	
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
									part.setalamain(j3);
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
									part.setalamain(j1);
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
									part.setalamain(j2);
								}
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
									part.setalamain(j3);
								}
								if (j4.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j4);
									j4.setEstConstruc();
									part.setalamain(j4);
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
									part.setalamain(j1);
								}
								if (j2.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j2);
									j2.setEstConstruc();
									part.setalamain(j2);
								}
								if (j3.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j3);
									j3.setEstConstruc();
									part.setalamain(j3);
								}
								if (j4.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j4);
									j4.setEstConstruc();
									part.setalamain(j4);
								}
								if (j5.getNom().matches((String) comboConstruc.getSelectedItem())) {
									part.setContr(j5);
									j5.setEstConstruc();
									part.setalamain(j5);
								}
								FenetrePrincipale fen = new FenetrePrincipale(part);
							}
						}
				}}); 
				p2.add(launcher);
				p2.add(cancel);
				construc.add(p2);
				construc.pack();
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

	public FenetrePrincipale (final Partie p) {
		// Fenetre principale

		this.setTitle("Hisse et ho, Santiago!");
		this.setSize(1260,740);
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


		// Icone de friche
		final Icon friche = new ImageIcon("./images/friche.jpg");
		Icon fricheCol = new ImageIcon("./images/colonneFriche.jpg");
		Icon fricheLig = new ImageIcon("./images/LigneFriche.jpg");
		Icon ficheInter = new ImageIcon("./images/InterFriche.jpg");
		Icon sourceImage = new ImageIcon("./images/source.jpg");
		final Icon eaucol = new ImageIcon("./images/eaucol.jpg");
		final Icon eaulig = new ImageIcon("./images/eaulig.jpg");
		final Icon constructeurImage = new ImageIcon("./images/construc.jpg");
		Icon travailleurBleu = new ImageIcon("./images/construcBleu.jpg");
		Icon travailleurJaune = new ImageIcon("./images/construcJaune.jpg");
		Icon travailleurRouge = new ImageIcon("./images/construcRouge.jpg");
		Icon travailleurVert = new ImageIcon("./images/construcVert.jpg");
		Icon travailleurBlanc = new ImageIcon("./images/construcBlanc.jpg");
		final JButton travailleurBleuBouton = new JButton(travailleurBleu);
		//Plateau 
		
		// Affichage des piles
		
		final JButton pile1 = p.p1.getHeap().getCarte();
		pile1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = pile1.getIcon();
				pile1.setEnabled(false);
			}
		});
		pile1.setBounds(306,5, 90, 90);
		panneauPrinc.add(pile1);

		final JButton pile2 = p.p2.getHeap().getCarte();
		pile2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = pile2.getIcon();
				pile2.setEnabled(false);
			}
		});
		pile2.setBounds(406,5, 90, 90);
		panneauPrinc.add(pile2);
		
		final JButton pile3 = p.p3.getHeap().getCarte();
		pile3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = pile3.getIcon();
				pile3.setEnabled(false);
			}
		});
		pile3.setBounds(506,5, 90, 90);
		panneauPrinc.add(pile3);
		
		final JButton pile4 = p.p4.getHeap().getCarte();
		pile4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = pile4.getIcon();
				pile4.setEnabled(false);
			}
		});
		pile4.setBounds(606,5, 90, 90);
		panneauPrinc.add(pile4);
		
		//
		Tuile friche1 = new Tuile("Friche",0,friche);
		//
		//Rang 1
		final JLabel travailleur = new JLabel(p.couleurTrav());
		final JLabel travailleur2 = new JLabel(p.couleurTrav());
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(23, 17, 801,600);
		
		final JButton carte1 = new JButton(friche);
		carte1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte1.setIcon(chemin);
				carte1.removeMouseListener(this);
			}
		});
		carte1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte1.getIcon().equals(friche)){
					String cheminIcone = carte1.getIcon().toString();
					travailleur.setBounds(12,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte1);
						layeredPane.validate();
				}
			}
		});
		carte1.setBounds(0, 0, 90, 90);
	   	layeredPane.add(carte1,-1);


		final JButton carte2 = new JButton(friche);
		carte2.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte2.setIcon(chemin);
				carte2.removeMouseListener(this);
			}
		});
		carte2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte2.getIcon().equals(friche)){
					String cheminIcone = carte2.getIcon().toString();
					travailleur.setBounds(102,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(120,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte2);
						layeredPane.validate();
				}
			}
		});
		carte2.setBounds(91, 0, 90, 90);
	   	layeredPane.add(carte2,-1);
		
		final JButton carte3 = new JButton(friche);
		carte3.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte3.setIcon(chemin);
				carte3.removeMouseListener(this);
			}
		});
		carte3.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte3.getIcon().equals(friche)){
					String cheminIcone = carte3.getIcon().toString();
					travailleur.setBounds(203,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(221,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte3);
						layeredPane.validate();
				}
			}
		});
		carte3.setBounds(192, 0, 90, 90);
	   	layeredPane.add(carte3,-1);

		final JButton carte4 = new JButton(friche);
		carte4.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte4.setIcon(chemin);
				carte4.removeMouseListener(this);
			}
		});
		carte4.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte4.getIcon().equals(friche)){
					String cheminIcone = carte4.getIcon().toString();
					travailleur.setBounds(295,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte4);
						layeredPane.validate();
				}
			}
		});
		carte4.setBounds(283, 0, 90, 90);
	   	layeredPane.add(carte4,-1);

		final JButton carte5 = new JButton(friche);
		carte5.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte5.setIcon(chemin);
				carte5.removeMouseListener(this);
			}
		});
		carte5.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte5.getIcon().equals(friche)){
					String cheminIcone = carte5.getIcon().toString();
					travailleur.setBounds(387,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(405,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte5);
						layeredPane.validate();
				}
			}
		});
		carte5.setBounds(384, 0, 90, 90);
	   	layeredPane.add(carte5,-1);

		final JButton carte6 = new JButton(friche);
		carte6.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte6.setIcon(chemin);
				carte6.removeMouseListener(this);
			}
		});
		carte6.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte6.getIcon().equals(friche)){
					String cheminIcone = carte6.getIcon().toString();
					travailleur.setBounds(479,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(497,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte6);
						layeredPane.validate();
				}
			}
		});
		carte6.setBounds(475, 0, 90, 90);
	   	layeredPane.add(carte6,-1);

		final JButton carte7 = new JButton(friche);
		carte7.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte7.setIcon(chemin);
				carte7.removeMouseListener(this);
			}
		});
		carte7.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte7.getIcon().equals(friche)){
					String cheminIcone = carte7.getIcon().toString();
					travailleur.setBounds(579,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(597,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte7);
						layeredPane.validate();
				}
			}
		});
		carte7.setBounds(576, 0, 90, 90);
	   	layeredPane.add(carte7,-1);

		final JButton carte8 = new JButton(friche);
		carte8.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte8.setIcon(chemin);
				carte8.removeMouseListener(this);
			}
		});
		carte8.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte8.getIcon().equals(friche)){
					String cheminIcone = carte8.getIcon().toString();
					travailleur.setBounds(671,12,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(689,12,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte8);
						layeredPane.validate();
				}
			}
		});
		carte8.setBounds(667, 0, 90, 90);
	   	layeredPane.add(carte8,-1);

		//Rang 2
		final JButton carte9 = new JButton(friche);
		carte9.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte9.setIcon(chemin);
				carte9.removeMouseListener(this);
			}
		});
		carte9.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte9.getIcon().equals(friche)){
					String cheminIcone = carte9.getIcon().toString();
					travailleur.setBounds(12,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte9);
						layeredPane.validate();
				}
			}
		});
		carte9.setBounds(0,91,90,90);
		layeredPane.add(carte9);
		

		final JButton carte10 = new JButton(friche);
		carte10.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte10.setIcon(chemin);
				carte10.removeMouseListener(this);
			}
		});
		carte10.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte10.getIcon().equals(friche)){
					String cheminIcone = carte10.getIcon().toString();
					travailleur.setBounds(103,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(121,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte10);
						layeredPane.validate();
				}
			}
		});
		carte10.setBounds(91,91,90,90);
		layeredPane.add(carte10);

		final JButton carte11 = new JButton(friche);
		carte11.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte11.setIcon(chemin);
				carte11.removeMouseListener(this);
			}
		});
		carte11.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte11.getIcon().equals(friche)){
					String cheminIcone = carte11.getIcon().toString();
					travailleur.setBounds(204,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(222,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte11);
						layeredPane.validate();
				}
			}
		});
		carte11.setBounds(192,91,90,90);
		layeredPane.add(carte11);

		final JButton carte12 = new JButton(friche);
		carte12.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte12.setIcon(chemin);
				carte12.removeMouseListener(this);
			}
		});
		carte12.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte12.getIcon().equals(friche)){
					String cheminIcone = carte12.getIcon().toString();
					travailleur.setBounds(295,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte12);
						layeredPane.validate();
				}
			}
		});
		carte12.setBounds(283,91,90,90);
		layeredPane.add(carte12);

		final JButton carte13 = new JButton(friche);
		carte13.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte13.setIcon(chemin);
				carte13.removeMouseListener(this);
			}
		});
		carte13.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte13.getIcon().equals(friche)){
					String cheminIcone = carte13.getIcon().toString();
					travailleur.setBounds(396,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(414,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte13);
						layeredPane.validate();
				}
			}
		});
		carte13.setBounds(384,91,90,90);
		layeredPane.add(carte13);
		
		final JButton carte14 = new JButton(friche);
		carte14.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte14.setIcon(chemin);
				carte14.removeMouseListener(this);
			}
		});
		carte14.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte14.getIcon().equals(friche)){
					String cheminIcone = carte14.getIcon().toString();
					travailleur.setBounds(487,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(505,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte14);
						layeredPane.validate();
				}
			}
		});
		carte14.setBounds(475,91,90,90);
		layeredPane.add(carte14);

		final JButton carte15 = new JButton(friche);
		carte15.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte15.setIcon(chemin);
				carte15.removeMouseListener(this);
			}
		});
		carte15.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte15.getIcon().equals(friche)){
					String cheminIcone = carte15.getIcon().toString();
					travailleur.setBounds(588,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(606,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte15);
						layeredPane.validate();
				}
			}
		});
		carte15.setBounds(576,91,90,90);
		layeredPane.add(carte15);

		final JButton carte16 = new JButton(friche);
		carte16.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte16.setIcon(chemin);
				carte16.removeMouseListener(this);
			}
		});
		carte16.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte16.getIcon().equals(friche)){
					String cheminIcone = carte16.getIcon().toString();
					travailleur.setBounds(679,102,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(697,102,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte16);
						layeredPane.validate();
				}
			}
		});
		carte16.setBounds(667,91,90,90);
		layeredPane.add(carte16);

		//rang 3
		final JButton carte17 = new JButton(friche);
		carte17.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte17.setIcon(chemin);
				carte17.removeMouseListener(this);
			}
		});
		carte17.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte17.getIcon().equals(friche)){
					String cheminIcone = carte17.getIcon().toString();
					travailleur.setBounds(12,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte17);
						layeredPane.validate();
				}
			}
		});
		carte17.setBounds(0,191,90,90);
		layeredPane.add(carte17);

		final JButton carte18 = new JButton(friche);
		carte18.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte18.setIcon(chemin);
				carte18.removeMouseListener(this);
			}
		});
		carte18.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte18.getIcon().equals(friche)){
					String cheminIcone = carte18.getIcon().toString();
					travailleur.setBounds(103,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(121,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte18);
						layeredPane.validate();
				}
			}
		});
		carte18.setBounds(91,191,90,90);
		layeredPane.add(carte18);

		final JButton carte19 = new JButton(friche);
		carte19.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte19.setIcon(chemin);
				carte19.removeMouseListener(this);
			}
		});
		carte19.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte19.getIcon().equals(friche)){
					String cheminIcone = carte19.getIcon().toString();
					travailleur.setBounds(204,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(222,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte19);
						layeredPane.validate();
				}
			}
		});
		carte19.setBounds(192,191,90,90);
		layeredPane.add(carte19);

		final JButton carte20 = new JButton(friche);
		carte20.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte20.setIcon(chemin);
				carte20.removeMouseListener(this);
			}
		});
		carte20.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte20.getIcon().equals(friche)){
					String cheminIcone = carte20.getIcon().toString();
					travailleur.setBounds(295,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte20);
						layeredPane.validate();
				}
			}
		});
		carte20.setBounds(283,191,90,90);
		layeredPane.add(carte20);

		final JButton carte21 = new JButton(friche);
		carte21.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte21.setIcon(chemin);
				carte21.removeMouseListener(this);
			}
		});
		carte21.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte21.getIcon().equals(friche)){
					String cheminIcone = carte21.getIcon().toString();
					travailleur.setBounds(396,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(414,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte21);
						layeredPane.validate();
				}
			}
		});
		carte21.setBounds(384,191,90,90);
		layeredPane.add(carte21);

		final JButton carte22 = new JButton(friche);
		carte22.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte22.setIcon(chemin);
				carte22.removeMouseListener(this);
			}
		});
		carte22.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte22.getIcon().equals(friche)){
					String cheminIcone = carte22.getIcon().toString();
					travailleur.setBounds(487,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(505,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte22);
						layeredPane.validate();
				}
			}
		});
		carte22.setBounds(475,191,90,90);
		layeredPane.add(carte22);

		final JButton carte23 = new JButton(friche);
		carte23.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte23.setIcon(chemin);
				carte23.removeMouseListener(this);
			}
		});
		carte23.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte23.getIcon().equals(friche)){
					String cheminIcone = carte23.getIcon().toString();
					travailleur.setBounds(588,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(606,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte23);
						layeredPane.validate();
				}
			}
		});
		carte23.setBounds(576,191,90,90);
		layeredPane.add(carte23);

		final JButton carte24 = new JButton(friche);
		carte24.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte24.setIcon(chemin);
				carte24.removeMouseListener(this);
			}
		});
		carte24.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte24.getIcon().equals(friche)){
					String cheminIcone = carte24.getIcon().toString();
					travailleur.setBounds(679,202,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(697,202,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte24);
						layeredPane.validate();
				}
			}
		});
		carte24.setBounds(667,191,90,90);
		layeredPane.add(carte24);

		// rang 4
		final JButton carte25= new JButton(friche);
		carte25.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte25.setIcon(chemin);
				carte25.removeMouseListener(this);
			}
		});
		carte25.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte25.getIcon().equals(friche)){
					String cheminIcone = carte25.getIcon().toString();
					travailleur.setBounds(12,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte25);
						layeredPane.validate();
				}
			}
		});
		carte25.setBounds(0,282,90,90);
		layeredPane.add(carte25);


		final JButton carte26 = new JButton(friche);
		carte26.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte26.setIcon(chemin);
				carte26.removeMouseListener(this);
			}
		});
		carte26.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte26.getIcon().equals(friche)){
					String cheminIcone = carte26.getIcon().toString();
					travailleur.setBounds(103,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(121,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte26);
						layeredPane.validate();
				}
			}
		});
		carte26.setBounds(91,282,90,90);
		layeredPane.add(carte26);

		final JButton carte27 = new JButton(friche);
		carte27.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte27.setIcon(chemin);
				carte27.removeMouseListener(this);
			}
		});
		carte27.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte27.getIcon().equals(friche)){
					String cheminIcone = carte27.getIcon().toString();
					travailleur.setBounds(204,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(222,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte27);
						layeredPane.validate();
				}
			}
		});
		carte27.setBounds(192,282,90,90);
		layeredPane.add(carte27);

		final JButton carte28 = new JButton(friche);
		carte28.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte28.setIcon(chemin);
				carte28.removeMouseListener(this);
			}
		});
		carte28.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte28.getIcon().equals(friche)){
					String cheminIcone = carte28.getIcon().toString();
					travailleur.setBounds(295,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte28);
						layeredPane.validate();
				}
			}
		});
		carte28.setBounds(283,282,90,90);
		layeredPane.add(carte28);

		final JButton carte29 = new JButton(friche);
		carte29.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte29.setIcon(chemin);
				carte29.removeMouseListener(this);
			}
		});
		carte29.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte29.getIcon().equals(friche)){
					String cheminIcone = carte29.getIcon().toString();
					travailleur.setBounds(396,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(414,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte29);
						layeredPane.validate();
				}
			}
		});
		carte29.setBounds(384,282,90,90);
		layeredPane.add(carte29);

		final JButton carte30 = new JButton(friche);
		carte30.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte30.setIcon(chemin);
				carte30.removeMouseListener(this);
			}
		});
		carte30.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte30.getIcon().equals(friche)){
					String cheminIcone = carte30.getIcon().toString();
					travailleur.setBounds(487,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(505,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte30);
						layeredPane.validate();
				}
			}
		});
		carte30.setBounds(475,282,90,90);
		layeredPane.add(carte30);

		final JButton carte31 = new JButton(friche);
		carte31.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte31.setIcon(chemin);
				carte31.removeMouseListener(this);
			}
		});
		carte31.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte31.getIcon().equals(friche)){
					String cheminIcone = carte31.getIcon().toString();
					travailleur.setBounds(588,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(606,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte31);
						layeredPane.validate();
				}
			}
		});
		carte31.setBounds(576,282,90,90);
		layeredPane.add(carte31);

		final JButton carte32 = new JButton(friche);
		carte32.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte32.setIcon(chemin);
				carte32.removeMouseListener(this);
			}
		});
		carte32.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte32.getIcon().equals(friche)){
					String cheminIcone = carte32.getIcon().toString();
					travailleur.setBounds(679,293,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(697,293,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte32);
						layeredPane.validate();
				}
			}
		});
		carte32.setBounds(667,282,90,90);
		layeredPane.add(carte32);
		
		
		//rang 4
		final JButton carte33 = new JButton(friche);
		carte33.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte33.setIcon(chemin);
				carte33.removeMouseListener(this);
			}
		});
		carte33.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte33.getIcon().equals(friche)){
					String cheminIcone = carte33.getIcon().toString();
					travailleur.setBounds(12,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte33);
						layeredPane.validate();
				}
			}
		});
		carte33.setBounds(0,382,90,90);
		layeredPane.add(carte33);

		final JButton carte34 = new JButton(friche);
		carte34.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte34.setIcon(chemin);
				carte34.removeMouseListener(this);
			}
		});
		carte34.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte34.getIcon().equals(friche)){
					String cheminIcone = carte34.getIcon().toString();
					travailleur.setBounds(103,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(121,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte34);
						layeredPane.validate();
				}
			}
		});
		carte34.setBounds(91,382,90,90);
		layeredPane.add(carte34);

		final JButton carte35 = new JButton(friche);
		carte35.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte35.setIcon(chemin);
				carte35.removeMouseListener(this);
			}
		});
		carte35.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte35.getIcon().equals(friche)){
					String cheminIcone = carte35.getIcon().toString();
					travailleur.setBounds(204,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(222,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte35);
						layeredPane.validate();
				}
			}
		});
		carte35.setBounds(192,382,90,90);
		layeredPane.add(carte35);

		final JButton carte36 = new JButton(friche);
		carte36.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte36.setIcon(chemin);
				carte36.removeMouseListener(this);
			}
		});
		carte36.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte36.getIcon().equals(friche)){
					String cheminIcone = carte36.getIcon().toString();
					travailleur.setBounds(295,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte36);
						layeredPane.validate();
				}
			}
		});
		carte36.setBounds(283,382,90,90);
		layeredPane.add(carte36);

		final JButton carte37 = new JButton(friche);
		carte37.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte37.setIcon(chemin);
				carte37.removeMouseListener(this);
			}
		});
		carte37.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte37.getIcon().equals(friche)){
					String cheminIcone = carte37.getIcon().toString();
					travailleur.setBounds(396,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(414,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte37);
						layeredPane.validate();
				}
			}
		});
		carte37.setBounds(384,382,90,90);
		layeredPane.add(carte37);

		final JButton carte38 = new JButton(friche);
		carte38.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte38.setIcon(chemin);
				carte38.removeMouseListener(this);
			}
		});
		carte38.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte38.getIcon().equals(friche)){
					String cheminIcone = carte38.getIcon().toString();
					travailleur.setBounds(487,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(505,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte38);
						layeredPane.validate();
				}
			}
		});
		carte38.setBounds(475,382,90,90);
		layeredPane.add(carte38);

		final JButton carte39 = new JButton(friche);
		carte39.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte39.setIcon(chemin);
				carte39.removeMouseListener(this);
			}
		});
		carte39.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte39.getIcon().equals(friche)){
					String cheminIcone = carte39.getIcon().toString();
					travailleur.setBounds(588,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(606,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte39);
						layeredPane.validate();
				}
			}
		});
		carte39.setBounds(576,382,90,90);
		layeredPane.add(carte39);

		final JButton carte40 = new JButton(friche);
		carte40.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte40.setIcon(chemin);
				carte40.removeMouseListener(this);
			}
		});
		carte40.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte40.getIcon().equals(friche)){
					String cheminIcone = carte40.getIcon().toString();
					travailleur.setBounds(679,393,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(697,393,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte40);
						layeredPane.validate();
				}
			}
		});
		carte40.setBounds(667,382,90,90);
		layeredPane.add(carte40);

		// rang 4
		final JButton carte41= new JButton(friche);
		carte41.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte41.setIcon(chemin);
				carte41.removeMouseListener(this);
			}
		});
		carte41.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte41.getIcon().equals(friche)){
					String cheminIcone = carte41.getIcon().toString();
					travailleur.setBounds(12,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(30,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte41);
						layeredPane.validate();
				}
			}
		});
		carte41.setBounds(0,473,90,90);
		layeredPane.add(carte41);

		final JButton carte42 = new JButton(friche);
		carte42.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte42.setIcon(chemin);
				carte42.removeMouseListener(this);
			}
		});
		carte42.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte42.getIcon().equals(friche)){
					String cheminIcone = carte42.getIcon().toString();
					travailleur.setBounds(103,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(121,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte42);
						layeredPane.validate();
				}
			}
		});
		carte42.setBounds(91,473,90,90);
		layeredPane.add(carte42);

		final JButton carte43 = new JButton(friche);
		carte43.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte43.setIcon(chemin);
				carte43.removeMouseListener(this);
			}
		});
		carte43.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte43.getIcon().equals(friche)){
					String cheminIcone = carte43.getIcon().toString();
					travailleur.setBounds(204,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(222,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte43);
						layeredPane.validate();
				}
			}
		});
		carte43.setBounds(192,473,90,90);
		layeredPane.add(carte43);

		final JButton carte44 = new JButton(friche);
		carte44.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte44.setIcon(chemin);
				carte44.removeMouseListener(this);
			}
		});
		carte44.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte44.getIcon().equals(friche)){
					String cheminIcone = carte44.getIcon().toString();
					travailleur.setBounds(295,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(313,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte44);
						layeredPane.validate();
				}
			}
		});
		carte44.setBounds(283,473,90,90);
		layeredPane.add(carte44);

		final JButton carte45 = new JButton(friche);
		carte45.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte45.setIcon(chemin);
				carte45.removeMouseListener(this);
			}
		});
		carte45.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte45.getIcon().equals(friche)){
					String cheminIcone = carte45.getIcon().toString();
					travailleur.setBounds(396,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(414,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte45);
						layeredPane.validate();
				}
			}
		});
		carte45.setBounds(384,473,90,90);
		layeredPane.add(carte45);

		final JButton carte46 = new JButton(friche);
		carte46.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte46.setIcon(chemin);
				carte46.removeMouseListener(this);
			}
		});
		carte46.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte46.getIcon().equals(friche)){
					String cheminIcone = carte46.getIcon().toString();
					travailleur.setBounds(487,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(505,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte46);
						layeredPane.validate();
				}
			}
		});
		carte46.setBounds(475,473,90,90);
		layeredPane.add(carte46);

		final JButton carte47 = new JButton(friche);
		carte47.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte47.setIcon(chemin);
				carte47.removeMouseListener(this);
			}
		});
		carte47.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte47.getIcon().equals(friche)){
					String cheminIcone = carte47.getIcon().toString();
					travailleur.setBounds(588,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(606,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte47);
						layeredPane.validate();
				}
			}
		});
		carte47.setBounds(576,473,90,90);
		layeredPane.add(carte47);

		final JButton carte48 = new JButton(friche);
		carte48.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				carte48.setIcon(chemin);
				carte48.removeMouseListener(this);
			}
		});
		carte48.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				if(!carte48.getIcon().equals(friche)){
					String cheminIcone = carte48.getIcon().toString();
					travailleur.setBounds(679,484,10,10);
					layeredPane.add(travailleur, 0);
					if(cheminIcone.matches(banane2.toString()) || cheminIcone.matches(poivron2.toString()) || cheminIcone.matches(canne2.toString()) || cheminIcone.matches(haricot2.toString()) || cheminIcone.matches(patate2.toString())){
						travailleur2.setBounds(697,484,10,10);
						layeredPane.add(travailleur2, 0);
						layeredPane.moveToFront(travailleur2);
					}
						layeredPane.moveToFront(travailleur);
						layeredPane.moveToBack(carte48);
						layeredPane.validate();
				}
			}
		});
		carte48.setBounds(667,473,90,90);
		layeredPane.add(carte48);
		
		plateau.add(layeredPane);

		//Colonne de friche

		final JButton col1 = new JButton(fricheCol);
		col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col1.setIcon(chemin2);
			}
		});

		col1.setBounds(204,17,12,181);
		plateau.add(col1);

		final JButton col2 = new JButton(fricheCol);
		col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col2.setIcon(chemin2);
			}
		});
		col2.setBounds(14,17,10,181);
		plateau.add(col2);

		final JButton col3 = new JButton(fricheCol);
		col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col3.setIcon(chemin2);
			}
		});
		col3.setBounds(396,17,12,181);
		plateau.add(col3);

		final JButton col4 = new JButton(fricheCol);
		col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col4.setIcon(chemin2);
			}
		});
		col4.setBounds(588,17,12,181);
		plateau.add(col4);

		final JButton col5 = new JButton(fricheCol);
		col5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col5.setIcon(chemin2);
			}
		});
		col5.setBounds(780,17,7,181);
		plateau.add(col5);

		final JButton col6 = new JButton(fricheCol);
		col6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col6.setIcon(chemin2);
			}
		});
		col6.setBounds(204,208,12,181);
		plateau.add(col6);

		final JButton col7 = new JButton(fricheCol);
		col7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col7.setIcon(chemin2);
			}
		});
		col7.setBounds(14,208,10,181);
		plateau.add(col7);

		final JButton col8 = new JButton(fricheCol);
		col8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col8.setIcon(chemin2);
			}
		});
		col8.setBounds(396,208,12,181);
		plateau.add(col8);

		final JButton col9 = new JButton(fricheCol);
		col9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col9.setIcon(chemin2);
			}
		});
		col9.setBounds(588,208,12,181);
		plateau.add(col9);

		final JButton col10 = new JButton(fricheCol);
		col10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col10.setIcon(chemin2);
			}
		});
		col10.setBounds(780,208,7,181);
		plateau.add(col10);

		final JButton col11 = new JButton(fricheCol);
		col11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col11.setIcon(chemin2);
			}
		});
		col11.setBounds(204,399,12,181);
		plateau.add(col11);

		final JButton col12 = new JButton(fricheCol);
		col12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col12.setIcon(chemin2);
			}
		});
		col12.setBounds(14,399,10,181);
		plateau.add(col12);

		final JButton col13 = new JButton(fricheCol);
		col13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col13.setIcon(chemin2);
			}
		});
		col13.setBounds(396,399,12,181);
		plateau.add(col13);

		final JButton col14 = new JButton(fricheCol);
		col14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col14.setIcon(chemin2);
			}
		});
		col14.setBounds(588,399,12,181);
		plateau.add(col14);

		final JButton col15 = new JButton(fricheCol);
		col15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				col15.setIcon(chemin2);
			}
		});
		col15.setBounds(780,399,7,181);
		plateau.add(col15);

		//Lignes de friche

		final JButton lig1 = new JButton(fricheLig);
		lig1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(chemin);
				lig1.setIcon(chemin);
			}
		});
		lig1.setBounds(23,7,181,10);
		plateau.add(lig1);

		final JButton lig2 = new JButton(fricheLig);
		lig2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig2.setIcon(chemin);
			}
		});
		lig2.setBounds(215,7,181,10);
		plateau.add(lig2);

		final JButton lig3 = new JButton(fricheLig);
		lig3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig3.setIcon(chemin);
			}
		});
		lig3.setBounds(407,7,181,10);
		plateau.add(lig3);

		final JButton lig4 = new JButton(fricheLig);
		lig4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig4.setIcon(chemin);
			}
		});
		lig4.setBounds(599,7,181,10);
		plateau.add(lig4);

		final JButton lig5 = new JButton(fricheLig);
		lig5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig5.setIcon(chemin);
			}
		});
		lig5.setBounds(23,198,181,10);
		plateau.add(lig5);

		final JButton lig6 = new JButton(fricheLig);
		lig6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig6.setIcon(chemin);
			}
		});
		lig6.setBounds(407,198,181,10);
		plateau.add(lig6);

		final JButton lig7 = new JButton(fricheLig);
		lig7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig7.setIcon(chemin);
			}
		});
		lig7.setBounds(599,198,181,10);
		plateau.add(lig7);

		final JButton lig8 = new JButton(fricheLig);
		lig8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig8.setIcon(chemin);
			}
		});
		lig8.setBounds(215,198,181,10);
		plateau.add(lig8);
		this.setVisible(true);

		final JButton lig9 = new JButton(fricheLig);
		lig9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig9.setIcon(chemin);
			}
		});
		lig9.setBounds(23,389,181,10);
		plateau.add(lig9);

		final JButton lig10 = new JButton(fricheLig);
		lig10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig10.setIcon(chemin);
			}
		});
		lig10.setBounds(407,389,181,10);
		plateau.add(lig10);

		final JButton lig11 = new JButton(fricheLig);
		lig11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig11.setIcon(chemin);
			}
		});
		lig11.setBounds(599,389,181,10);
		plateau.add(lig11);

		final JButton lig12 = new JButton(fricheLig);
		lig12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig12.setIcon(chemin);
			}
		});
		lig12.setBounds(215,389,181,10);
		plateau.add(lig12);
		this.setVisible(true);

		final JButton lig13 = new JButton(fricheLig);
		lig13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig13.setIcon(chemin);
			}
		});
		lig13.setBounds(23,579,181,13);
		plateau.add(lig13);

		final JButton lig14 = new JButton(fricheLig);
		lig14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig14.setIcon(chemin);
			}
		});
		lig14.setBounds(407,579,181,13);
		plateau.add(lig14);

		final JButton lig15 = new JButton(fricheLig);
		lig15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig15.setIcon(chemin);
			}
		});
		lig15.setBounds(599,579,181,13);
		plateau.add(lig15);

		final JButton lig16 = new JButton(fricheLig);
		lig16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lig16.setIcon(chemin);
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
		sortie.setBounds(1110, 10, 120, 40);
		panneauPrinc.add(sortie);

		//Gestion des cartes
		JButton carteretire = new JButton();
		if (p.nbP != 5) {
			if (p.getTuile().getType().matches("Banane") && p.getTuile().getNbTrav() == 1) {
				carteretire.setIcon(banane);
			}

			if (p.getTuile().getType().matches("Banane") && p.getTuile().getNbTrav() == 2) {
				carteretire.setIcon(banane2);
			}

			if (p.getTuile().getType().matches("Poivron") && p.getTuile().getNbTrav() == 1) {
				carteretire.setIcon(poivron);
			}

			if (p.getTuile().getType().matches("Poivron") && p.getTuile().getNbTrav() == 2) {
				
				carteretire.setIcon(poivron2);
			}

			if (p.getTuile().getType().matches("Canne a sucre") && p.getTuile().getNbTrav() == 1) {
			
				carteretire.setIcon(canne);
			}

			if (p.getTuile().getType().matches("Canne a sucre") && p.getTuile().getNbTrav() == 2) {
				
				carteretire.setIcon(canne2);
			}

			if (p.getTuile().getType().matches("Haricot") && p.getTuile().getNbTrav() == 1) {
				
				carteretire.setIcon(haricot);
			}

			if (p.getTuile().getType().matches("Haricot") && p.getTuile().getNbTrav() == 2) {
				
				carteretire.setIcon(haricot2);
			}

			if (p.getTuile().getType().matches("Pomme de terre") && p.getTuile().getNbTrav() == 1) {
				
				carteretire.setIcon(patate);
			}

			if (p.getTuile().getType().matches("Pomme de terre") && p.getTuile().getNbTrav() == 2) {
				
				carteretire.setIcon(patate2);
			}
		}
		// Gestion des joueurs.

		//Icon portemonnaie = new ImageIcon("./images/portemonnaie.jpg");
		Icon pion = new ImageIcon("./images/pionChapeau.jpg");
		Icon canbleu = new ImageIcon("./images/eaulig.jpg");

		//J1
		//image du joueur
		JButton j1 = new JButton(pion);
		j1.setBorderPainted(false);
		j1.setBounds(985,191, 70, 70);
		panneauPrinc.add(j1);
		//nom du joueur
		JLabel nom1 = new JLabel();
		nom1.setText(p.j1.getNom());
		nom1.setForeground(Color.white);
		nom1.setBounds(1065, 190, 150, 15);
		panneauPrinc.add(nom1);
		//Affichage des canaux
		JLabel canaux1 = new JLabel();
		canaux1.setText("Canaux : ");
		canaux1.setForeground(Color.white);
		canaux1.setBounds(1065, 210, 65, 10);
		panneauPrinc.add(canaux1);
		//affichage du canal bleu
		JButton canalB1 = new JButton(canbleu);
		canalB1.setBounds(1140,210,45,12);
		panneauPrinc.add(canalB1);
		//Affichage du canal de la couleur du joueur
		String nomIcone1 = "./images/"+p.j1.getCouleur()+"lig.jpg";
		Icon couleurJ1 = new ImageIcon(nomIcone1);
		final JButton canalJoueur1 = new JButton(couleurJ1);
		canalJoueur1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = canalJoueur1.getIcon();
				if (chemin.toString().indexOf("bleu")!=-1){
					chemin2 = bleucol;
				} else if (chemin.toString().indexOf("rouge")!=-1){
					chemin2 = rougecol;
				}else 
				if (chemin.toString().indexOf("vert")!=-1){
					chemin2 = vertcol;
				} else if (chemin.toString().indexOf("blanc")!=-1){
					chemin2 = blanccol;
				} else 	if (chemin.toString().indexOf("jaune")!=-1){
					chemin2 = jaunecol;
				} 
				System.out.println(chemin2);
			}
		});
		canalJoueur1.setBounds(1190,210,45,12);
		panneauPrinc.add(canalJoueur1);
		//label affichant l argent detenu
		JLabel argentj1 = new JLabel();
		argentj1.setText(""+p.j1.getmoney()+" Escudos");
		argentj1.setForeground(Color.white);
		argentj1.setBounds(1065, 230, 100, 10);
		panneauPrinc.add(argentj1);
		//label affichant les constructeurs restant au joueur 
		JLabel rendement1 = new JLabel();
		rendement1.setText(p.j1.getNbTrav()+" constructeur(s)");
		rendement1.setForeground(Color.white);
		rendement1.setBounds(1065, 250, 150, 10);
		panneauPrinc.add(rendement1);

		//liseret entre les joueurs
		JLabel liseret1 = new JLabel();
		liseret1.setText("-------------------------------");
		liseret1.setBounds(1028, 264, 400, 5);
		liseret1.setForeground(Color.white);
		panneauPrinc.add(liseret1);

		//J2
		//image du joueur
		JButton j2 = new JButton(pion);
		j2.setBorderPainted(false);
		j2.setBounds(985,271, 70, 70);
		panneauPrinc.add(j2);
		//nom du joueur
		JLabel nom2 = new JLabel();
		nom2.setText(p.j2.getNom());
		nom2.setForeground(Color.white);
		nom2.setBounds(1065, 270, 150, 15);
		panneauPrinc.add(nom2);
		//Affichage des canaux
		JLabel canaux2 = new JLabel();
		canaux2.setText("Canaux : ");
		canaux2.setForeground(Color.white);
		canaux2.setBounds(1065, 290, 65, 10);
		panneauPrinc.add(canaux2);
		//affichage du canal bleu
		JButton canalB2 = new JButton(canbleu);
		canalB2.setBounds(1140,290,45,12);
		panneauPrinc.add(canalB2);
		//Affichage du canal de la couleur du joueur
		String nomIcone2 = "./images/"+p.j2.getCouleur()+"lig.jpg";
		Icon couleurJ2 = new ImageIcon(nomIcone2);
		final JButton canalJoueur2 = new JButton(couleurJ2);
		canalJoueur2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = canalJoueur2.getIcon();
				if (chemin.toString().indexOf("bleu")!=-1){
					chemin2 = bleucol;
				} else if (chemin.toString().indexOf("rouge")!=-1){
					chemin2 = rougecol;
				}else 
				if (chemin.toString().indexOf("vert")!=-1){
					chemin2 = vertcol;
				} else if (chemin.toString().indexOf("blanc")!=-1){
					chemin2 = blanccol;
				} else 	if (chemin.toString().indexOf("jaune")!=-1){
					chemin2 = jaunecol;
				} 
			}
		});
		canalJoueur2.setBounds(1190,290,45,12);
		panneauPrinc.add(canalJoueur2);
		//label affichant l argent detenu
		JLabel argentj2 = new JLabel();
		argentj2.setText(""+p.j2.getmoney()+" Escudos");
		argentj2.setForeground(Color.white);
		argentj2.setBounds(1065, 310, 100, 10);
		panneauPrinc.add(argentj2);
		//label affichant les constructeurs restant au joueur 
		JLabel rendement2 = new JLabel();
		rendement2.setText(p.j2.getNbTrav()+" constructeur(s)");
		rendement2.setForeground(Color.white);
		rendement2.setBounds(1065, 330, 150, 10);
		panneauPrinc.add(rendement2);

		//liseret entre les joueurs
		JLabel liseret2 = new JLabel();
		liseret2.setText("-------------------------------");
		liseret2.setBounds(1028, 344, 400, 5);
		liseret2.setForeground(Color.white);
		panneauPrinc.add(liseret2);

		//J3
		//image du joueur
		JButton j3 = new JButton(pion);
		j3.setBorderPainted(false);
		j3.setBounds(985,351, 70, 70);
		panneauPrinc.add(j3);
		//nom du joueur
		JLabel nom3 = new JLabel();
		nom3.setText(p.j3.getNom());
		nom3.setForeground(Color.white);
		nom3.setBounds(1065, 350, 150, 15);
		panneauPrinc.add(nom3);
		//Affichage des canaux
		JLabel canaux3 = new JLabel();
		canaux3.setText("Canaux : ");
		canaux3.setForeground(Color.white);
		canaux3.setBounds(1065, 370, 65, 10);
		panneauPrinc.add(canaux3);
		//affichage du canal bleu
		JButton canalB3 = new JButton(canbleu);
		canalB3.setBounds(1140,370,45,12);
		panneauPrinc.add(canalB3);
		//Affichage du canal de la couleur du joueur
		String nomIcone3 = "./images/"+p.j3.getCouleur()+"lig.jpg";
		Icon couleurJ3 = new ImageIcon(nomIcone3);
		final JButton canalJoueur3 = new JButton(couleurJ3);
		canalJoueur3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chemin = canalJoueur3.getIcon();
				if (chemin.toString().indexOf("bleu")!=-1){
					chemin2 = bleucol;
				} else if (chemin.toString().indexOf("rouge")!=-1){
					chemin2 = rougecol;
				}else 
				if (chemin.toString().indexOf("vert")!=-1){
					chemin2 = vertcol;
				} else if (chemin.toString().indexOf("blanc")!=-1){
					chemin2 = blanccol;
				} else 	if (chemin.toString().indexOf("jaune")!=-1){
					chemin2 = jaunecol;
				} 
			}
		});
		canalJoueur3.setBounds(1190,370,45,12);
		panneauPrinc.add(canalJoueur3);
		//label affichant l argent detenu
		JLabel argentj3 = new JLabel();
		argentj3.setText(""+p.j3.getmoney()+" Escudos");
		argentj3.setForeground(Color.white);
		argentj3.setBounds(1065, 390, 100, 10);
		panneauPrinc.add(argentj3);
		//label affichant les constructeurs restant au joueur 
		JLabel rendement3 = new JLabel();
		rendement3.setText(p.j3.getNbTrav()+" constructeur(s)");
		rendement3.setForeground(Color.white);
		rendement3.setBounds(1065, 410, 150, 10);
		panneauPrinc.add(rendement3);

		if (p.nbP == 3 || p.nbP== 4) {
			JLabel carteRemoved = new JLabel();
			carteRemoved.setText("On a retire: ");
			carteRemoved.setForeground(Color.white);
			carteRemoved.setBounds(900,600, 100, 20);
			panneauPrinc.add(carteRemoved);
			carteretire.setBounds(1000,600, 90, 90);
			panneauPrinc.add(carteretire);
		}

		if (p.nbP > 3) {

			//liseret entre les joueurs
			JLabel liseret3 = new JLabel();
			liseret3.setText("-------------------------------");
			liseret3.setBounds(1028, 424, 400, 5);
			liseret3.setForeground(Color.white);
			panneauPrinc.add(liseret3);

			//J4
			//image du joueur
			JButton j4 = new JButton(pion);
			j4.setBorderPainted(false);
			j4.setBounds(985,431, 70, 70);
			panneauPrinc.add(j4);
			//nom du joueur
			JLabel nom4 = new JLabel();
			nom4.setText(p.j4.getNom());
			nom4.setForeground(Color.white);
			nom4.setBounds(1065, 430, 150, 15);
			panneauPrinc.add(nom4);
			//Affichage des canaux
			JLabel canaux4 = new JLabel();
			canaux4.setText("Canaux : ");
			canaux4.setForeground(Color.white);
			canaux4.setBounds(1065, 450, 65, 10);
			panneauPrinc.add(canaux4);
			//affichage du canal bleu
			JButton canalB4 = new JButton(canbleu);
			canalB4.setBounds(1140,450,45,12);
			panneauPrinc.add(canalB4);
			//Affichage du canal de la couleur du joueur
			String nomIcone4 = "./images/"+p.j4.getCouleur()+"lig.jpg";
			Icon couleurJ4 = new ImageIcon(nomIcone4);
			final JButton canalJoueur4 = new JButton(couleurJ4);
			canalJoueur4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chemin = canalJoueur4.getIcon();
					if (chemin.toString().indexOf("bleu")!=-1){
						chemin2 = bleucol;
					} else if (chemin.toString().indexOf("rouge")!=-1){
						chemin2 = rougecol;
					}else 
					if (chemin.toString().indexOf("vert")!=-1){
						chemin2 = vertcol;
					} else if (chemin.toString().indexOf("blanc")!=-1){
						chemin2 = blanccol;
					} else 	if (chemin.toString().indexOf("jaune")!=-1){
						chemin2 = jaunecol;
					} 
				}
			});
			canalJoueur4.setBounds(1190,450,45,12);
			panneauPrinc.add(canalJoueur4);
			//label affichant l argent detenu
			JLabel argentj4 = new JLabel();
			argentj4.setText(""+p.j4.getmoney()+" Escudos");
			argentj4.setForeground(Color.white);
			argentj4.setBounds(1065, 470, 100, 10);
			panneauPrinc.add(argentj4);
			//label affichant les constructeurs restant au joueur 
			JLabel rendement4 = new JLabel();
			rendement4.setText(p.j4.getNbTrav()+" constructeur(s)");
			rendement4.setForeground(Color.white);
			rendement4.setBounds(1065, 490, 150, 10);
			panneauPrinc.add(rendement4);

			if (p.nbP == 5) {

				//liseret entre les joueurs
				JLabel liseret4 = new JLabel();
				liseret4.setText("-------------------------------");
				liseret4.setBounds(1028, 504, 400, 5);
				liseret4.setForeground(Color.white);
				panneauPrinc.add(liseret4);

				//J5
				//image du joueur
				JButton j5 = new JButton(pion);
				j5.setBorderPainted(false);
				j5.setBounds(985,511, 70, 70);
				panneauPrinc.add(j5);
				//nom du joueur
				JLabel nom5 = new JLabel();
				nom5.setText(p.j5.getNom());
				nom5.setForeground(Color.white);
				nom5.setBounds(1065, 510, 150, 15);
				panneauPrinc.add(nom5);
				//Affichage des canaux
				JLabel canaux5 = new JLabel();
				canaux5.setText("Canaux : ");
				canaux5.setForeground(Color.white);
				canaux5.setBounds(1065, 530, 65, 10);
				panneauPrinc.add(canaux5);
				//affichage du canal bleu
				JButton canalB5 = new JButton(canbleu);
				canalB5.setBounds(1140,530,45,12);
				panneauPrinc.add(canalB5);
				//Affichage du canal de la couleur du joueur
				String nomIcone5 = "./images/"+p.j5.getCouleur()+"lig.jpg";
				Icon couleurJ5 = new ImageIcon(nomIcone5);
				final JButton canalJoueur5 = new JButton(couleurJ5);
				canalJoueur5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chemin = canalJoueur5.getIcon();
						if (chemin.toString().indexOf("bleu")!=-1){
							chemin2 = bleucol;
						} else if (chemin.toString().indexOf("rouge")!=-1){
							chemin2 = rougecol;
						}else 
						if (chemin.toString().indexOf("vert")!=-1){
							chemin2 = vertcol;
						} else if (chemin.toString().indexOf("blanc")!=-1){
							chemin2 = blanccol;
						} else 	if (chemin.toString().indexOf("jaune")!=-1){
							chemin2 = jaunecol;
						} 
						
					}
				});
				canalJoueur5.setBounds(1190,530,45,12);
				panneauPrinc.add(canalJoueur5);
				//label affichant l argent detenu
				JLabel argentj5 = new JLabel();
				argentj5.setText(""+p.j5.getmoney()+" Escudos");
				argentj5.setForeground(Color.white);
				argentj5.setBounds(1065, 550, 100, 10);
				panneauPrinc.add(argentj5);
				//label affichant les constructeurs restant au joueur 
				JLabel rendement5 = new JLabel();
				rendement5.setText(p.j5.getNbTrav()+" constructeur(s)");
				rendement5.setForeground(Color.white);
				rendement5.setBounds(1065, 570, 150, 10);
				panneauPrinc.add(rendement5);

			}	
		}

		if (p.getNbp() == 5) {
			final JButton pile5 = p.p5.getHeap().getCarte();
			pile5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chemin = pile5.getIcon();
					pile5.setEnabled(false);
				}
			});
			pile5.setBounds(706,5, 90, 90);
			panneauPrinc.add(pile5);
		}

		p.majConstruct(panneauPrinc, p, constructeurImage);
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
		
		Joueur[] tab = p.mise(panneauPrinc,p);
		
		
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
