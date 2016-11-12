package Grafica.Tanque;


import Grafica.ComponenteGrafico;
import Logica.Logica;
import Logica.Hilo.Movimiento.*;

public abstract class Tanque extends ComponenteGrafico {
	/*Constructor*/
	
	protected int disparosSimultaneos;
	protected int velMovimiento;
	protected int velDisparo;

	protected int deQuienEs;

	protected Logica logica;

	protected boolean puedeMover;
	protected int ultimoDisparo;
	
	protected Movimiento hiloFluido;
	
	
	public	Tanque(int x,int y){
		super(x,y);		
		puedeMover=true;;
		ultimoDisparo=1;
	}
	
	public void mover(int direccion) {
		if(puedeMover){
			hiloFluido=new MovimientoFluidoTanque(this, direccion,logica);
			puedeMover=false;
			hiloFluido.start();
		}
	}	
	
	public int getVelMovimiento(){
		return velMovimiento;
	}
	
	public ComponenteGrafico crearDisparo(){
		boolean seMovio=true;
		boolean seCreo=true;
		ComponenteGrafico bala= new Disparo(0,0,direccion,logica);
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
		if(!seMovio && seCreo){
			logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),bala.getDeQuienEsElDisparo());
			bala=null;
		}
		if(!seCreo)
			bala=null;
		return bala;
	}
	
	public boolean movimientoPosible() {
		return false;
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
	
	public boolean getPuedeMover(){
		return puedeMover;
	}
}
