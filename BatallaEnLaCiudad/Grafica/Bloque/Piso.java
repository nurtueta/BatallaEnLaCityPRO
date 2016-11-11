package Grafica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

<<<<<<< HEAD
import Grafica.ComponenteGrafico;
=======
import Logica.Logica;
>>>>>>> origin/master

public class Piso extends Bloque{

	public Piso(int x,int y,Logica l) {
		super(x,y,l);
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
