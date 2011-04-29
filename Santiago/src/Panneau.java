import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Panneau extends JPanel {
 
	// GENERATEUR DE PANNEAUX 
	// x : longeur
	// y : largeur
	//x2 = positionnement horizontal
	//y2 : positionnement vertical
	
	private String chemin;
	private int x;
	private int y; 
	private int x2;
	private int y2; 
	private int coorx;
	private int coory;
	public Panneau(String chemin,int x, int y, int x2, int y2, int coorx, int coory) {
		this.chemin = chemin;
		this.x= x; 
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.coorx = coorx;
		this.coory = coory;
	}
	
	public int getcoorX () {
		return this.coorx;
	}
	
	public int getcoorY () {
		return this.coory;
	}
        public void paintComponent(Graphics g){
                try {
                        Image img = ImageIO.read(new File(chemin));
                        g.drawImage(img,0, 0, this);
                        this.setSize(x,y);
                        this.setLocation(x2, y2);
                } catch (IOException e) {
                       
                        e.printStackTrace();
                }
                
        }               
}