package Logica.Bloque;

import javax.swing.ImageIcon;

public class Arbol extends Celda{

	public Arbol(int x,int y) {
		super(x,y);
		this.setImagenEnPos(new ImageIcon(getClass().getResource("/Imagenes/arboles.png")), 4);
		this.setImagenActual(4);
		//this.setImagenEnPos(new ImageIcon(this.getClass().getResource("/BatallaEnLaCiudad/Recursos/arboles.png")), 3);	}
	}
	
	public boolean movimientoPosible() {
		return true;
	}

}
