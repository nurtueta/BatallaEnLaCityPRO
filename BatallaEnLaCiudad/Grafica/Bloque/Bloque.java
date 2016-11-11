package Grafica.Bloque;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public abstract class Bloque extends ComponenteGrafico
{	
	public Bloque(int x,int y,Logica l){	
		super(x,y);	
		logica=l;
	}
}
