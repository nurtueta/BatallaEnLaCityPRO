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

	public boolean movimientoPosible() {
		return false;
	}
	
	public void posicionImagen(int i) {
		
	}

	public void recibirDisparo() {
		
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	
	public boolean puedoIngresarPowerUp(){
		return false;
	}

	public boolean mejorar() {
		return false;
	}
}
