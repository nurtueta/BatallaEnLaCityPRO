package Logica.Bloque;

import javax.swing.ImageIcon;

public class Arbol extends Celda{

	public Arbol(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/arboles.png")));
	}
	
	public boolean movimientoPosible() {
		return true;
	}

	
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
