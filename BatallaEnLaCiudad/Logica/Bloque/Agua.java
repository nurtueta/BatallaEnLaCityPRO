package Logica.Bloque;

import javax.swing.ImageIcon;

public class Agua extends Celda {

	
	public Agua() {
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/agua.png")), 2);	}
	
	
	public boolean movimientoPosible() {
		return false;
	}

}
