package Grafica.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public abstract class PowerUp extends ComponenteGrafico{
	
	protected int codigo;
	protected Logica logica;
	
	public PowerUp(int x, int y,int codigo){
		super(x,y);
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
