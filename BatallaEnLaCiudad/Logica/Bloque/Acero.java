package Logica.Bloque;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("Imagenes/acero.png")));
		//this.setImagenEnPos(new ImageIcon("acero.png"), 4);
		this.setImagenActual(4);
	}
	
	public boolean movimientoPosible() {

		return false;
	}

}
