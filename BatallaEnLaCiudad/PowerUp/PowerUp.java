package PowerUp;

import Grafica.ComponenteGrafico;

public class PowerUp extends ComponenteGrafico{
	
	public PowerUp(int x, int y){
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
		return true;
	}

	@Override
	public void colicion(int deQuienEs) {
		// TODO Auto-generated method stub
		
	}

}
