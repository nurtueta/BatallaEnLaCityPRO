package Logica.Bloque;

import javax.swing.ImageIcon;

public class Agua extends Celda {

	
	public Agua(int x,int y) {
		super(x,y);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/agua.png")), 2);	}
	
	
	public boolean movimientoPosible() {
		return false;
	}

}
