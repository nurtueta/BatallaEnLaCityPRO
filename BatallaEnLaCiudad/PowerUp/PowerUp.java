package PowerUp;

import Grafica.ComponenteGrafico;

public abstract class PowerUp extends ComponenteGrafico{
	
	protected int codigo;
	
	public PowerUp(int x, int y,int codigo){
		super(x,y);
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
		return movimientoPosibleDisparo;
	}
	
	public int getCodigo(){
		return codigo;
	}

}
