package Logica.Bloque;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		//this.setImagenEnPos(new ImageIcon(getClass().getResource("/BatallaEnLaCiudad/Imagenes/acero.png")), 4);
		this.setImagenEnPos(new ImageIcon("acero.png"), 4);
		this.setImagenActual(4);
	}
	
	public boolean movimientoPosible() {

		return false;
	}

}
