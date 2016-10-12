package Logica.Bloque;

import javax.swing.ImageIcon;

public class Agua extends Celda {

	public Agua(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/agua.png")));
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

	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

}
