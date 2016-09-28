package Logica.Bloque;

import javax.swing.ImageIcon;

public class Agua extends Celda {

	
	public Agua(int x,int y) {
		super(x,y);
		this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/agua.png")), 4);
		this.setImagenActual(4);
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/agua.png")), 2);	}
	}
	
	public boolean movimientoPosible() {
		return false;
	}

}
