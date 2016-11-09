package Logica.Bloque;

import Grafica.ComponenteGrafico;

public abstract class Celda extends ComponenteGrafico
{	
	public Celda(int x,int y){	
		super(x,y);	
	}
	
	public boolean movimientoPosible() {
		return false;
	}

	public boolean movimientoPosibleDisparo() {
		return false;
	}
}
