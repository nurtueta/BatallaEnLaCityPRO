package Logica.Bloque;

import javax.swing.ImageIcon;

public class Arbol extends Celda{

	public Arbol() {
		this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/arboles.png")), 3);	}

	public boolean movimientoPosible() {
		return true;
	}

}
