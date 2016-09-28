package Logica.Bloque;

import javax.swing.ImageIcon;

public class Piso extends Celda{

	public Piso(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/fondo.png")), 0);
	}
	
	public boolean movimientoPosible() {
		return true;
	}

}
