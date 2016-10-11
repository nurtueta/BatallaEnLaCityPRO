package Logica;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Bloque.Celda;

public class Disparo extends Celda{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int direccion;
	
	public Disparo(int d, int x, int y)
	{	
		super(x,y);
		direccion = d;
		ImageIcon fot = new ImageIcon();
		switch (d){
			case 1:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaDer.png"));
				break;
			case 2:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaIzq.png"));
				break;
			case 3:
				fot =new ImageIcon(getClass().getResource("/Imagenes/balaArriba.png"));
				break;
			case 4:
				fot= new ImageIcon(getClass().getResource("/Imagenes/balaAbajo.png"));
				break;
		}
		
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ladrillo.png")));
		//this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
	}

	@Override
	public boolean movimientoPosible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recibirDisparo() {
		
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
