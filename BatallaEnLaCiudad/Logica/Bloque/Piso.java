package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Piso extends Celda{

	public Piso(int x,int y) {
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/fondo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
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

	@Override
	public void colicion() {
		// TODO Auto-generated method stub
		
	}
}
