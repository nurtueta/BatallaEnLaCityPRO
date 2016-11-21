package Grafica.Tanque.Enemigo;

import Grafica.ComponenteGrafico;
import Grafica.Tanque.Disparo;
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
	
	public ComponenteGrafico crearDisparo(){
		ComponenteGrafico bala=null;
		if(disparosAndando<1){
			boolean seMovio=true;
			boolean seCreo=true;
			bala= new Disparo(0,0,direccion,logica);
			switch (direccion) {
				case 1: 
					if(miX!=19){
						bala.setPosicionX(miX+1);
						bala.setPosicionY(miY);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())     
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 2: 
					if(miX!=0){
						bala.setPosicionX(miX-1);
						bala.setPosicionY(miY);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 3: 
					if(miY!=0){
						bala.setPosicionY(miY-1);
						bala.setPosicionX(miX);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())	
							seMovio=false;
					}else
						seCreo=false;
					break;
				case 4: 
					if(miY!=19){
						bala.setPosicionY(miY+1);
						bala.setPosicionX(miX);
						if(!logica.getComponente(bala.getPosicionX(), bala.getPosicionY()).movimientoPosibleDisparo())
							seMovio=false;
					}else
						seCreo=false;
					break;
			}
			if(seMovio){
				bala.setEjecutor(this);
				disparosAndando++;
			}
			if(!seMovio && seCreo){
				bala.setEjecutor(this);
				logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),this);
				bala=null;
			}
			if(!seCreo)
				bala=null;
		}
		return bala;
	}
	

}
