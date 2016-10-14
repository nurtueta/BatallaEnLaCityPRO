package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/acero.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}
	
	public boolean movimientoPosible() {
		return false;
	}

	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}

	public boolean mover() {
		return false;
	}

	public boolean movimientoPosibleDisparo() {
		return false;
	}

}
