package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Ladrillo extends Celda{
	
	public Ladrillo(int x,int y) {
		super(x,y);
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png")));
	
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png"));
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		
	}
	
	public boolean movimientoPosible() {
		return false;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posicionImagen(int i) {
		// TODO Auto-generated method stub
		
	}

}
