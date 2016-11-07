package Logica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Aguila extends Celda {
	
	public Aguila(int x, int y){
		
		super(x,y);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/EmblemaRepublica.jpg"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=25;
	}

	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean movimientoPosibleDisparo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recibirDisparo() {
		vida=0;
		System.exit(0);
		
	}

	@Override
	public void posicionImagen(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void colicion(int deQuienEs) {
		// TODO Auto-generated method stub
		
	}

}
