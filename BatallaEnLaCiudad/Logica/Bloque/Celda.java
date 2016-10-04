package Logica.Bloque;

import Grafica.ComponenteGrafico;

public abstract class Celda extends ComponenteGrafico
{	
	public Celda(int x,int y){	
		super(x,y);	
	}
	/**
	 * Define si la celda permite la circulacion de otros objetos.
	 * @return TRUE si el movimiento es posible, FALSE caso contrario
	 */
	public abstract boolean movimientoPosible();
	
	
}
