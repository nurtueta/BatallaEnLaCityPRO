package Logica.Bloque;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/acero.png")));
<<<<<<< HEAD
		//this.setImagenEnPos(new ImageIcon("acero.png"), 4);
		//this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/acero.png")), 4);
=======
		
		//this.setImagenEnPos(new ImageIcon("acero.png"), 4);
	//	this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/acero.png")), 4);
>>>>>>> 023d52740c4bf3384e843ad9ab0abcdc1d6bf5c2
		//this.setImagenActual(4);
	}
	
	public boolean movimientoPosible() {

		return false;
	}

}
