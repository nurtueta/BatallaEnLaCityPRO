package Logica.Bloque;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Ladrillo extends Celda{
	
	public Ladrillo() {
		
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/fondo.png")), 0);
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/ladrillo.png")), 1);
	}
	
	@Override
	public boolean movimientoPosible() {
		return false;
	}

}
