package PowerUp;

import Grafica.ComponenteGrafico;

public class PowerUp extends ComponenteGrafico{
	
	public PowerUp(int x, int y){
		super(x,y);
	}

	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return true;
	}

	public void colicion(int deQuienEs) {
		
	}

}
