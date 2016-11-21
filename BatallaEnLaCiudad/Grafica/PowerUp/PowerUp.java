package Grafica.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public abstract class PowerUp extends ComponenteGrafico{
	
	public PowerUp(int x, int y,Logica l){
		super(x,y);
		logica=l;
		profundidad=5;
		vida=1;
	}

	public boolean movimientoPosibleEnemigo() {
		return movimientoPosible;
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}
	
	public boolean mejorar() {
		return false;
	}
	
	public void colicion(ComponenteGrafico x){
		
	}
}
