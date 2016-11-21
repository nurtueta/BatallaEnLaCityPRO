package Grafica.Bloque;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class Arbol extends Bloque{
	
	public Arbol(int x,int y,Logica l) {
		super(x,y,l);
		profundidad=4;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/nebula.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
		movimientoPosible=true;
	}
	
	public boolean movimientoPosible() {
		return movimientoPosible;
	}
	
	public boolean movimientoPosibleEnemigo(){
		return movimientoPosible;
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}

	public void colicion(ComponenteGrafico x) {
		
	}

	public boolean mejorar() {
		return false;
	}
}
