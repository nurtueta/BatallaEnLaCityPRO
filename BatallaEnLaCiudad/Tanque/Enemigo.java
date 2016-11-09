package Tanque;

import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.Movimiento;
import Logica.MovimientoBalas;

public abstract class Enemigo extends Tanque{
	

	/*Constructor*/
	public	Enemigo(int x,int y){
		super(x,y);
		disparosSimultaneos=1;
		deQuienEs=0;
	}
	
	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	public ComponenteGrafico crearDisparo(){
		ComponenteGrafico bala= new Disparo(0,0,direccion,logica,deQuienEs);
			boolean puedeCrear=true;
			switch(direccion){
				case 1:
					if(!logica.getComponente(miX+1, miY).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX+1);
					bala.setPosicionY(miY);
					break;
				case 2:
					if(!logica.getComponente(miX-1, miY).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX-1);
					bala.setPosicionY(miY);
					break;
				case 3:
					if(!logica.getComponente(miX, miY-1).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX);
					bala.setPosicionY(miY-1);
					break;
				case 4:
					if(!logica.getComponente(miX, miY+1).movimientoPosibleDisparo())
						puedeCrear=false;
					bala.setPosicionX(miX);
					bala.setPosicionY(miY+1);
					break;
			}
			if(!puedeCrear){
				logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),deQuienEs);
				bala=null;
			}
		
		return bala;
	}
}
