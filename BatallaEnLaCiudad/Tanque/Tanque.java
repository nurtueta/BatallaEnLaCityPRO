package Tanque;


import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.Logica;
import Logica.Movimiento;
import Logica.MovimientoFluido;
import Logica.MovimientoBalas;
import Logica.Bloque.Celda;

public abstract class Tanque extends ComponenteGrafico {
	/*Constructor*/
	
	protected int disparosSimultaneos;
	protected int velMovimiento;
	protected int velDisparo;
	protected int deQuienEs;
	protected Logica logica;
	boolean puedeMover;
	
	protected Movimiento hiloFluido;
	
	
	public	Tanque(int x,int y){
		super(x,y);		
		profundidad=4;
		puedeMover=true;;
	}
	
	public boolean mover(int direccion) {
		if(puedeMover){
			hiloFluido=new MovimientoFluido(this, direccion,logica);
			puedeMover=false;
			hiloFluido.start();
		}
		return false;
	}	
	
	public int getVelMovimiento(){
		return velMovimiento;
	}
	
	public int getDisparosSimultaneos(){
		return disparosSimultaneos;
	}

	public void setPuedeMover(){
		puedeMover=true;
	}
	
	public ComponenteGrafico crearDisparo(){
		boolean seMovio=true;
		boolean seCreo=true;
		ComponenteGrafico bala= new Disparo(0,0,direccion,logica,deQuienEs);
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
			logica.eliminarColicion(bala.getPosicionX(),bala.getPosicionY(),deQuienEs);
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
}
