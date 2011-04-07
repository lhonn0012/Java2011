import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Random rnd = new Random();
		int x = rnd.nextInt(5);
		int y = rnd.nextInt(4);
		int[] abscisse = {0,2,4,6,8};
		int[] ordonne = {0,2,4,6};
		Plateau p = new Plateau (abscisse[x],ordonne[y]);
		Partie part = new Partie();
		
		//FenetrePrincipale accueil = new FenetrePrincipale (700,300);
		
		FenetrePrincipale fen = new FenetrePrincipale();
	
		//System.out.println(p.getXsource());
		//System.out.println(p.getYsource());
		
		//Initialisation du jeu et des joueurs
		int nbPlayer = 7;
		int nbTour ;
		Scanner sc = new Scanner(System.in);
		while (nbPlayer > 5 || nbPlayer < 3) {
		System.out.println ("Combien de joueur pour cette partie ? (3,4 ou 5)");
		nbPlayer = sc.nextInt();
		}
		
		if (nbPlayer == 5) {
			
				nbTour = 9;
				p.ChangeCanalBleu(5);
				p.ChangeTrav(100);
				
				// Creation des 5 joueurs
				System.out.println ("Nom joueur 1 ? ");
				String nom = sc.next();
				System.out.println ("Couleur joueur 1 ? ");
				String couleur = sc.next();
				Joueur j1 = new Joueur (nom,couleur,"j1");
				
				System.out.println ("Nom joueur 2 ? ");
				String nom2 = sc.next();
				System.out.println ("Couleur joueur 2 ? ");
				String couleur2 = sc.next();
				Joueur j2 = new Joueur (nom2,couleur2,"j2");
				
				System.out.println ("Nom joueur 3 ? ");
				String nom3 = sc.next();
				System.out.println ("Couleur joueur 3 ? ");
				String couleur3 = sc.next();
				Joueur j3 = new Joueur (nom3,couleur3,"j3");
				
				System.out.println ("Nom joueur 4 ? ");
				String nom4 = sc.next();
				System.out.println ("Couleur joueur 4 ? ");
				String couleur4 = sc.next();
				Joueur j4 = new Joueur (nom4,couleur4,"j4");
				
				System.out.println ("Nom joueur 5 ? ");
				String nom5 = sc.next();
				System.out.println ("Couleur joueur 5 ? ");
				String couleur5 = sc.next();
				Joueur j5 = new Joueur (nom5,couleur5,"j5");
				
				Pile p1 = new Pile("p1");
				Pile p2 = new Pile("p2");
				Pile p3 = new Pile("p3");
				Pile p4 = new Pile("p4");
				Pile p5 = new Pile("p5");
				p.genererPile(5,p1,p2,p3,p4,p5);
			
				part = new Partie (p,j1,j2,j3,j4,j5,p1,p2,p3,p4,p5);
			
		}
		
		else {
			nbTour = 11;
			if (nbPlayer == 3 ) {
				p.ChangeCanalBleu(3);
				p.ChangeTrav(66);
				System.out.println ("Nom joueur 1 ? ");
				String nom = sc.next();
				System.out.println ("Couleur joueur 1 ? ");
				String couleur = sc.next();
				Joueur j1 = new Joueur (nom,couleur,"j1");
				
				
				System.out.println ("Nom joueur 2 ? ");
				String nom2 = sc.next();
				System.out.println ("Couleur joueur 2 ? ");
				String couleur2 = sc.next();
				Joueur j2 = new Joueur (nom2,couleur2,"j2");
				
				System.out.println ("Nom joueur 3 ? ");
				String nom3 = sc.next();
				System.out.println ("Couleur joueur 3 ? ");
				String couleur3 = sc.next();
				Joueur j3 = new Joueur (nom3,couleur3,"j3");
				
				Pile p1 = new Pile("p1");
				Pile p2 = new Pile("p2");
				Pile p3 = new Pile("p3");
				Pile p4 = new Pile("p4");
				Pile p5 = new Pile("p5");
				p.genererPile(3,p1,p2,p3,p4,p5);
				part = new Partie (p,j1,j2,j3,p1,p2,p3,p4);
				
			} else {
				
				p.ChangeCanalBleu(4);
				p.ChangeTrav(88);
				
				System.out.println ("Nom joueur 1 ? ");
				String nom = sc.next();
				System.out.println ("Couleur joueur 1 ? ");
				String couleur = sc.next();
				Joueur j1 = new Joueur (nom,couleur,"j1");
				
				System.out.println ("Nom joueur 2 ? ");
				String nom2 = sc.next();
				System.out.println ("Couleur joueur 2 ? ");
				String couleur2 = sc.next();
				Joueur j2 = new Joueur (nom2,couleur2,"j2");
				
				System.out.println ("Nom joueur 3 ? ");
				String nom3 = sc.next();
				System.out.println ("Couleur joueur 3 ? ");
				String couleur3 = sc.next();
				Joueur j3 = new Joueur (nom3,couleur3,"j3");
				
				System.out.println ("Nom joueur 4 ? ");
				String nom4 = sc.next();
				System.out.println ("Couleur joueur 4 ? ");
				String couleur4 = sc.next();
				Joueur j4 = new Joueur (nom4,couleur4,"j4");
				Pile p1 = new Pile("p1");
				Pile p2 = new Pile("p2");
				Pile p3 = new Pile("p3");
				Pile p4 = new Pile("p4");
				Pile p5 = new Pile("p5");
				p.genererPile(4,p1,p2,p3,p4,p5);
				p.afficherPile(p1);
				p.afficherPile(p2);
				part = new Partie (p,j1,j2,j3,j4,p1,p2,p3,p4);
				
			}
			// youpi tout les joueurs sont crés ! 
			//youpi la partie est crée ! 
		}
		part.contructeurCanal();
		
		//System.out.println(p.getNbCanalBleu());
		//System.out.println(p.getnbTravailleurdispo());
		//p.afficherPile(p1);
		//p.afficherPile(p2);
		//p.afficherPile(p3);
		//p.afficherPile(p4);
		//p.afficherPile(p5);

		System.out.println("********************************");
		System.out.println("*********Debut de partie********");
		System.out.println("********************************");
		
		System.out.println("********************************");
		System.out.println("*********Etape 1********");
		System.out.println("********************************");
		
		part.retournerPt();
		
		part.next();
		
		Joueur[] j = part.mise(part.getNbp());
		part.phase2(j).setEstConstruc();
		
		//part.tabDeJoueur();
		//System.out.println(part.getConstruc().getNom());
	
	}

}
