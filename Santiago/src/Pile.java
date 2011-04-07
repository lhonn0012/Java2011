import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Pile {

	protected String nom ; 
	protected List content;
	
	public Pile (String nom) {
		//Nom de la pile (p1, p2...)
		this.nom = nom;
		//Contient les cartes dans la pile
		this.content= new ArrayList();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void addCard (Tuile t) {
		this.content.add(t);
	}
	
	
}
