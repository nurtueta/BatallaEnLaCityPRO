package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Arbol extends Celda{

	public Arbol(int x,int y) {
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/arboles.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
	}
	
	public boolean movimientoPosible() {
		return true;
	}

	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}

	public boolean mover() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}

	public void colicion() {
		
	}

}
