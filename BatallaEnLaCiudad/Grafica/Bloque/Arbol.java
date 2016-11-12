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
		ImageIcon fot = new ImageIcon(getClass().getResource("/Imagenes/arboles.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.setIcon(icono);
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

	public ComponenteGrafico mejorar() {
		return null;
	}

	public boolean puedoIngresarPowerUp(){
		return false;
	}
}
