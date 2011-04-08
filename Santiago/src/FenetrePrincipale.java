
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

public class FenetrePrincipale extends JFrame{

	public int x;
	public int y;
	private JPanel accueil = new JPanel();
	private JPanel droite = new JPanel();
	private JPanel gauche = new JPanel();
	private JComboBox combo = new JComboBox();
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
	        
			JLabel label = new JLabel("Nombre de Joueur : ");
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
			        	}
			        	for (int i=4; i<nbJ; i++){
			        		tabLabel[i-1].setVisible(true);
			        		textField[i-1].setVisible(true);
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
			
			// init. du tableau des JLabel et JTextField affich� suite au comboBox
			int ordonnee = 240;
			for (int i=0; i<nomLabel.length; i++){
				tabLabel[i] = new JLabel(nomLabel[i]);
				tabLabel[i].setFont(font);
				//tabLabel[i].setColor(Color.green);
				tabLabel[i].setVisible(false);
				droite.add(tabLabel[i]);
				textField[i] = new JTextField(16);
				textField[i].setVisible(false);
				droite.add(textField[i]);
				ordonnee += 10;
				if ( i == 0 || i == 1 || i == 2){
					tabLabel[i].setVisible(true);
					textField[i].setVisible(true);
				}
			}

			/*ajout des panel gauche et droite au panel de fond et placement*/
			accueil.setBackground(Color.black);
			gauche.setBackground(Color.black);
			droite.setBackground(Color.black);
	        accueil.add(gauche);
	        gauche.setBounds(20, 20, 320, 450);
	        accueil.add(droite);
	        droite.setBounds(350, 100, 350, 500);
	        
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
	         Panneau plateau = new Panneau("./images/plateau.jpg", 800,600,112,54,0,0);
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
		
}
