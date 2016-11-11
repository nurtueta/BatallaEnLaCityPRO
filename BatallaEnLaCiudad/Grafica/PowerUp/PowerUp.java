package Grafica.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public abstract class PowerUp extends ComponenteGrafico{
	
	protected int codigo;
	
	public PowerUp(int x, int y,int codigo,Logica l){
		super(x,y);
		logica=l;
		profundidad=5;
	}

	public boolean movimientoPosible() {
		return false;
	}
	
	public void posicionImagen(int i) {
		
	}

	public boolean mover(int direcion) {
		return false;
	}
	
	public void recibirDisparo() {
		
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}
	
	public int getCodigo(){
		return codigo;
	}

}
