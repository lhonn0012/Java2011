import javax.swing.Icon;
import javax.swing.JButton;


public class Tuile {

	public String type;
	private int nbTrav;
	private JButton carte ; 
	
	private Icon icon;
	public Tuile (String type, int nbTrav, Icon i) {
		this.type = type;
		this.nbTrav = nbTrav;
		this.carte = new JButton(i);
		this.icon = i;
	}
	
	public String getType() {
		return this.type;
	}
	public int getNbTrav() {
		return this.nbTrav;
	}
	public JButton getCarte() {
		return this.carte;
	}
	public Icon getIcon() {
		return icon;
	}
}
