package PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public abstract class PowerUp extends ComponenteGrafico{
	
	protected int codigo;
	protected Logica miLogica;
	
	public PowerUp(int x, int y,int codigo,Logica l){
		super(x,y);
		miLogica = l;
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
		return movimientoPosibleDisparo;
	}
	
	public int getCodigo(){
		return codigo;
	}

}
