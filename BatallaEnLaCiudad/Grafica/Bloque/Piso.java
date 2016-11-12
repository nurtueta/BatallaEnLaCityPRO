package Grafica.Bloque;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;


import Grafica.ComponenteGrafico;

import Logica.Logica;


public class Piso extends Bloque{

	public Piso(int x,int y,Logica l) {
		super(x,y,l);
		profundidad=2;
		movimientoPosible=true;
		vida=1;
	
	}
	
	public boolean movimientoPosible() {
		return movimientoPosible;
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
		return true;
	}
}
