package Logica.Bloque;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/acero.png")));
<<<<<<< HEAD
=======
		//this.setImagenEnPos(new ImageIcon("acero.png"), 4);
		this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/acero.png")), 4);
		this.setImagenActual(4);
>>>>>>> 5b8e44e42a3ffa3d96395b62bf4bfb5c43f1cb90
	}
	
	public boolean movimientoPosible() {

		return false;
	}

}
