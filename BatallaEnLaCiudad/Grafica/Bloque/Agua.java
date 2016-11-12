package Grafica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;

import Logica.Logica;


public class Agua extends Bloque {

	public Agua(int x,int y,Logica l) {
		super(x,y,l);
		profundidad=2;
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/agua.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
		vida=1;
	}
	
	public boolean movimientoPosible() {
		return false;
	}
	
	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}

	public boolean movimientoPosibleDisparo() {
		return true;
	}

	public void colicion(int deQuienEs) {
		
	}

	public boolean mejorar() {
		return false;
	}
	
	public boolean puedoIngresarPowerUp(){
		return false;
	}
}
