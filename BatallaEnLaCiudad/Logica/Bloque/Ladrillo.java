package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Ladrillo extends Celda{
	
	public Ladrillo(int x,int y) {
		super(x,y);

		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=4;
		puntaje=50;
	}
	
	public boolean movimientoPosible() {
		return false;
	}

	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		setVisible(false);
	}

	public boolean mover(int direcion) {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}

	public void colicion(int deQuienEs) {
		vida--;
		
	}

}
