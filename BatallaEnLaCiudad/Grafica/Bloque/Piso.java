package Grafica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;

public class Piso extends Bloque{

	public Piso(int x,int y) {
		super(x,y);
		profundidad=2;
		
		vida=1;
	
	}
	
	public boolean movimientoPosible() {
		return movimientoPosible;
	}
	
	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}

	public boolean mover(int direcion) {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return movimientoPosibleDisparo;
	}

	public void colicion(int deQuienEs) {
		
	}

	@Override
	public ComponenteGrafico mejorar() {
		// TODO Auto-generated method stub
		return null;
	}
}