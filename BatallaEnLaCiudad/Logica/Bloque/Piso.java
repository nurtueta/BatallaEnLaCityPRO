package Logica.Bloque;

import javax.swing.ImageIcon;

public class Piso extends Celda{

	public Piso(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
	}
	
	public boolean movimientoPosible() {
		return true;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

}
