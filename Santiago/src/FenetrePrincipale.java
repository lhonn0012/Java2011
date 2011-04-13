
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	//DIEU QUE J'EN AI CHIE POUR CETTE PUTIN DE FENETRE
	
		public FenetrePrincipale(int x, int y) {
			
			super();  
			
			Font font = new Font("Courier", Font.BOLD, 12);
            
			/*d�claration des layout*/
	        FlowLayout mapg = new FlowLayout();
			gauche.setLayout(mapg);
	       
			FlowLayout mapD = new FlowLayout();
			droite.setLayout(mapD);
			
			/*d�claration de l'image et ajout au panel*/
			JLabel image = new JLabel(new ImageIcon("./images/Santiago.jpg"));
			gauche.add(image);
			image.setBounds(0, 150, 200, 200);
			
			/*d�claration du combobox et label associ�*/
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
	        	/*action r�alis� au changement du nombre de joueur dans la combo*/
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

	        JButton go = new JButton("Go Negro !");
	        go.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FenetrePrincipale fen = new FenetrePrincipale();
				}
			});
			droite.add(go); 
			go.setBounds(50,170,70,10);
			
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

			// init. du tableau des JLabel et JTextField affich� suite au comboBox
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
			this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        

		}
		
		public FenetrePrincipale () {
			// Fenetre principale
			
			 this.setTitle("Hisse et ho, Santiago!");
	         this.setSize(1024,728);
	         this.setLocationRelativeTo(null);
	         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	         this.setResizable(true);
	         this.setAlwaysOnTop(true);
	         JPanel panneauPrinc = new JPanel();
	         Color col = new Color(100,149,237);
	         panneauPrinc.setBackground(col); 
	         this.setContentPane(panneauPrinc);
	         
	         //Plateau 
	         Panneau plateau = new Panneau("./images/plateau.jpg", 801,600,111,54,0,0);
	         panneauPrinc.add(plateau);
	
	         //rang1
	         Panneau carte1 = new Panneau ("./images/friche.jpg", 90,90,23,17,0,0);
	         plateau.add(carte1);
	         Panneau carte2 = new Panneau ("./images/friche.jpg", 90,90,114,17,0,0);
	         plateau.add(carte2);
	         Panneau carte3 = new Panneau ("./images/friche.jpg", 90,90,215,17,0,0);
	         plateau.add(carte3);
	         Panneau carte4 = new Panneau ("./images/friche.jpg", 90,90,306,17,0,0);
	         plateau.add(carte4);
	         Panneau carte5 = new Panneau ("./images/friche.jpg", 90,90,407,17,0,0);
	         plateau.add(carte5);
	         Panneau carte6 = new Panneau ("./images/friche.jpg", 90,90,498,17,0,0);
	         plateau.add(carte6);
	         Panneau carte7 = new Panneau ("./images/friche.jpg", 90,90,599,17,0,0);
	         plateau.add(carte7);
	         Panneau carte8 = new Panneau ("./images/friche.jpg", 90,90,690,17,0,0);
	         plateau.add(carte8);
	         //rang2
	         Panneau carte9 = new Panneau ("./images/friche.jpg", 90,90,23,108,0,0);
	         plateau.add(carte9);
	         Panneau carte10 = new Panneau ("./images/friche.jpg", 90,90,114,108,0,0);
	         plateau.add(carte10);
	         Panneau carte11 = new Panneau ("./images/friche.jpg", 90,90,215,108,0,0);
	         plateau.add(carte11);
	         Panneau carte12 = new Panneau ("./images/friche.jpg", 90,90,306,108,0,0);
	         plateau.add(carte12);
	         Panneau carte13 = new Panneau ("./images/friche.jpg", 90,90,407,108,0,0);
	         plateau.add(carte13);
	         Panneau carte14 = new Panneau ("./images/friche.jpg", 90,90,498,108,0,0);
	         plateau.add(carte14);
	         Panneau carte15 = new Panneau ("./images/friche.jpg", 90,90,599,108,0,0);
	         plateau.add(carte15);
	         Panneau carte16 = new Panneau ("./images/friche.jpg", 90,90,690,108,0,0);
	         plateau.add(carte16);
	         //rang3
	         Panneau carte17 = new Panneau ("./images/friche.jpg", 90,90,23,208,0,0);
	         plateau.add(carte17);
	         Panneau carte18 = new Panneau ("./images/friche.jpg", 90,90,114,208,0,0);
	         plateau.add(carte18);
	         Panneau carte19 = new Panneau ("./images/friche.jpg", 90,90,215,208,0,0);
	         plateau.add(carte19);
	         Panneau carte20 = new Panneau ("./images/friche.jpg", 90,90,306,208,0,0);
	         plateau.add(carte20);
	         Panneau carte21 = new Panneau ("./images/friche.jpg", 90,90,407,208,0,0);
	         plateau.add(carte21);
	         Panneau carte22 = new Panneau ("./images/friche.jpg", 90,90,498,208,0,0);
	         plateau.add(carte22);
	         Panneau carte23 = new Panneau ("./images/friche.jpg", 90,90,599,208,0,0);
	         plateau.add(carte23);
	         Panneau carte24 = new Panneau ("./images/friche.jpg", 90,90,690,208,0,0);
	         plateau.add(carte24);
	         //rang4
	         Panneau carte25 = new Panneau ("./images/friche.jpg", 90,90,23,299,0,0);
	         plateau.add(carte25);
	         Panneau carte26 = new Panneau ("./images/friche.jpg", 90,90,114,299,0,0);
	         plateau.add(carte26);
	         Panneau carte27 = new Panneau ("./images/friche.jpg", 90,90,215,299,0,0);
	         plateau.add(carte27);
	         Panneau carte28 = new Panneau ("./images/friche.jpg", 90,90,306,299,0,0);
	         plateau.add(carte28);
	         Panneau carte29 = new Panneau ("./images/friche.jpg", 90,90,407,299,0,0);
	         plateau.add(carte29);
	         Panneau carte30 = new Panneau ("./images/friche.jpg", 90,90,498,299,0,0);
	         plateau.add(carte30);
	         Panneau carte31 = new Panneau ("./images/friche.jpg", 90,90,599,299,0,0);
	         plateau.add(carte31);
	         Panneau carte32 = new Panneau ("./images/friche.jpg", 90,90,690,299,0,0);
	         plateau.add(carte32);
	       //rang5
	         Panneau carte33 = new Panneau ("./images/friche.jpg", 90,90,23,399,0,0);
	         plateau.add(carte33);
	         Panneau carte34 = new Panneau ("./images/friche.jpg", 90,90,114,399,0,0);
	         plateau.add(carte34);
	         Panneau carte35 = new Panneau ("./images/friche.jpg", 90,90,215,399,0,0);
	         plateau.add(carte35);
	         Panneau carte36 = new Panneau ("./images/friche.jpg", 90,90,306,399,0,0);
	         plateau.add(carte36);
	         Panneau carte37 = new Panneau ("./images/friche.jpg", 90,90,407,399,0,0);
	         plateau.add(carte37);
	         Panneau carte38 = new Panneau ("./images/friche.jpg", 90,90,498,399,0,0);
	         plateau.add(carte38);
	         Panneau carte39 = new Panneau ("./images/friche.jpg", 90,90,599,399,0,0);
	         plateau.add(carte39);
	         Panneau carte40 = new Panneau ("./images/friche.jpg", 90,90,690,399,0,0);
	         plateau.add(carte40);
		       //rang6
	         Panneau carte41 = new Panneau ("./images/friche.jpg", 90,90,23,490,0,0);
	         plateau.add(carte41);
	         Panneau carte42 = new Panneau ("./images/friche.jpg", 90,90,114,490,0,0);
	         plateau.add(carte42);
	         Panneau carte43 = new Panneau ("./images/friche.jpg", 90,90,215,490,0,0);
	         plateau.add(carte43);
	         Panneau carte44 = new Panneau ("./images/friche.jpg", 90,90,306,490,0,0);
	         plateau.add(carte44);
	         Panneau carte45 = new Panneau ("./images/friche.jpg", 90,90,407,490,0,0);
	         plateau.add(carte45);
	         Panneau carte46 = new Panneau ("./images/friche.jpg", 90,90,498,490,0,0);
	         plateau.add(carte46);
	         Panneau carte47 = new Panneau ("./images/friche.jpg", 90,90,599,490,0,0);
	         plateau.add(carte47);
	         Panneau carte48 = new Panneau ("./images/friche.jpg", 90,90,690,490,0,0);
	         plateau.add(carte48);
	         
	         this.setVisible(true);
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
