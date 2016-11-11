package Grafica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;

public class Aguila extends Bloque {
	
	public Aguila(int x, int y){
		
		super(x,y);
		profundidad=2;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/emblemarepublica.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
	}

	public boolean movimientoPosible() {
		return false;
	}

	@Override
	public boolean movimientoPosibleDisparo() {
		return false;
	}

	public void recibirDisparo() {
		
	}

	public void posicionImagen(int i) {
		
	}

	public boolean mover(int direcion) {
		return false;
	}

	public void colicion(int deQuienEs) {
		vida=0;
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}

}
