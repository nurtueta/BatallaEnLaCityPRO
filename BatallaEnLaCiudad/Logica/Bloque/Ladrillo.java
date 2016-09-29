package Logica.Bloque;

import javax.swing.ImageIcon;

public class Ladrillo extends Celda{
	
	public Ladrillo(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png")));
	}
	
	public boolean movimientoPosible() {
		return false;
	}

}
