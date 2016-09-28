package Logica.Bloque;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
<<<<<<< HEAD
		this.setIcon(new ImageIcon(getClass().getResource("Imagenes/acero.png")));
		//this.setImagenEnPos(new ImageIcon("acero.png"), 4);
=======
		this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/acero.png")), 4);
>>>>>>> 5d6627cc3131ba7f0b1e5518550564928d87a0d9
		this.setImagenActual(4);
	}
	
	public boolean movimientoPosible() {

		return false;
	}

}
