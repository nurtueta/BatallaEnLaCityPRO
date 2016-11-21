package Grafica.Tanque.Enemigo;

import Grafica.Tanque.Tanque;
import Logica.Hilo.Movimiento.MovimientoFluidoTanque;
import Logica.Hilo.Movimiento.MovimientoFluidoTanqueEnemigo;

public abstract class Enemigo extends Tanque{
	

	/*Constructor*/
	public	Enemigo(int x,int y){
		super(x,y);
		disparosSimultaneos=1;
	}	
	
	public void puedeMover(){
		puedeMover=true;
	}
	
	public int getNivel(){
		return 0;
	}
	
	/**
	 * Mueve el tanque y lo desabilita hasta que termina de moverse
	 */
	public void mover(int direccion) {
		if(puedeMover){
			hiloFluido=new MovimientoFluidoTanqueEnemigo(this, direccion,logica);
			puedeMover=false;
			hiloFluido.start();
		}
	}	
	

}
