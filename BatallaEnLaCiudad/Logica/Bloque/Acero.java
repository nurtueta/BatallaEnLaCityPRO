package Logica.Bloque;

import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/acero.png")), 4);	}

	public boolean movimientoPosible() {

		return false;
	}

}
