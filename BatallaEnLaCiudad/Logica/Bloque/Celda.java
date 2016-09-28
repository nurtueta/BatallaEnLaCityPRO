package Logica.Bloque;

import Grafica.CeldaGrafica;
import Grafica.ComponenteGrafico;
import Logica.GameObject;

public abstract class Celda extends ComponenteGrafico
{	
	public Celda(int x,int y){super(x,y);}
	public abstract boolean movimientoPosible();
	
}
