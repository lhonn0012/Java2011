
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
            
			/*déclaration des layout*/
	        FlowLayout mapg = new FlowLayout();
			gauche.setLayout(mapg);
	       
			FlowLayout mapD = new FlowLayout();
			droite.setLayout(mapD);
			
			/*déclaration de l'image et ajout au panel*/
			JLabel image = new JLabel(new ImageIcon("./images/Santiago.jpg"));
			gauche.add(image);
			image.setBounds(0, 150, 200, 200);
			
			/*déclaration du combobox et label associé*/
			int nbJ = combo.getSelectedIndex();
	        
			JLabel label = new JLabel("Nombre de Joueur : ");
	        droite.add(label);
			label.setBounds(50,100,30,10);
			
			combo.setPreferredSize(new Dimension(40,20));
	        combo.addItem("3");
	        combo.addItem("4");
	        combo.addItem("5");
	        combo.addActionListener(new ActionListener() {
	        	/*action réalisé au changement du nombre de joueur dans la combo*/
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
			
			// init. du tableau des JLabel et JTextField affiché suite au comboBox
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
	         this.setResizable(false);
	         this.setAlwaysOnTop(true);
	         JPanel panneauPrinc = new JPanel();
	         Color col = new Color(100,149,237);
	         panneauPrinc.setBackground(col); 
	         this.setContentPane(panneauPrinc);
	         
	         //Plateau 
	         Panneau plateau = new Panneau("./images/plateau.jpg", 800,600,112,54,0,0);
	         panneauPrinc.add(plateau);
	         Panneau carte = new Panneau ("./images/friche.jpg", 90,90,27,20,1,1);
	         plateau.add(carte);
	         Panneau carte1 = new Panneau ("./images/friche.jpg", 90,90,119,20,1,1);
	         plateau.add(carte1);
	         Panneau carte2 = new Panneau ("./images/friche.jpg", 90,90,220,20,2,1);
	         plateau.add(carte2);
	         Panneau carte3 = new Panneau ("./images/friche.jpg", 90,90,311,20,3,1);
	         plateau.add(carte3);
	         Panneau carte4 = new Panneau ("./images/friche.jpg", 90,90,412,20,4,1);
	         plateau.add(carte4);
	         Panneau carte5 = new Panneau ("./images/friche.jpg", 90,90,503,20,5,1);
	         plateau.add(carte5);
	         Panneau carte6 = new Panneau ("./images/friche.jpg", 90,90,604,20,6,1);
	         plateau.add(carte6);
	         Panneau carte7 = new Panneau ("./images/friche.jpg", 90,90,695,20,7,1);
	         plateau.add(carte7);
	         Panneau carte8 = new Panneau ("./images/friche.jpg", 90,90,22,108,8,1);
	         plateau.add(carte8);
	         Panneau carte9 = new Panneau ("./images/friche.jpg", 90,90,22,213,1,1);
	         plateau.add(carte9);
	         Panneau carte10 = new Panneau ("./images/friche.jpg", 90,90,22,213,1,1);
	         plateau.add(carte10);
	         Panneau carte11 = new Panneau ("./images/friche.jpg", 90,90,22,299,1,1);
	         plateau.add(carte11);
	         Panneau carte12 = new Panneau ("../images/friche.jpg", 90,90,22,405,1,1);
	         plateau.add(carte12);
	         Panneau carte13 = new Panneau ("../images/friche.jpg", 90,90,22,491,1,1);
	         plateau.add(carte13);
	         Panneau carte14 = new Panneau ("../images/friche.jpg", 90,90,22,213,1,1);
	         plateau.add(carte14);
	         
	         this.setVisible(true);
		}
		
}
