package Grafica.Bloque;

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
