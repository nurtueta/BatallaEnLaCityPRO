package Logica.Bloque;

import javax.swing.ImageIcon;

public class Acero extends Celda{

	public Acero(int x,int y) {
		super(x,y);
		this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/acero.png")));
	}
	
	public boolean movimientoPosible() {

		return false;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

}
