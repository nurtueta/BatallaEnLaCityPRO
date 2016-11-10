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
		profundidad=3;
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
		ComponenteGrafico bala= new Disparo(0,0,direccion,logica,deQuienEs);
			switch(direccion){
				case 1:
					if(logica.getComponente(miX+1, miY)!=null){
						if(!logica.getComponente(miX+1, miY).movimientoPosibleDisparo()){
							bala=null;
							logica.eliminarColicion(miX+1,miY,deQuienEs);
						}else{
							bala.setPosicionX(miX+1);
							bala.setPosicionY(miY);
						}
					}else
						bala=null;
					break;
				case 2:
					if(logica.getComponente(miX-1, miY)!=null){
						if(!logica.getComponente(miX-1, miY).movimientoPosibleDisparo()){
							bala=null;
							logica.eliminarColicion(miX-1,miY,deQuienEs);
						}else{
							bala.setPosicionX(miX-1);
							bala.setPosicionY(miY);
						}
					}else
						bala=null;
					break;
				case 3:
					if(logica.getComponente(miX, miY-1)!=null){
						if(!logica.getComponente(miX, miY-1).movimientoPosibleDisparo()){
							bala=null;
							logica.eliminarColicion(miX,miY-1,deQuienEs);
						}else{
							bala.setPosicionX(miX);
							bala.setPosicionY(miY-1);
						}
					}else
						bala=null;
					break;
				case 4:
					if(logica.getComponente(miX, miY+1)!=null){
						if(!logica.getComponente(miX, miY+1).movimientoPosibleDisparo()){
							bala=null;
							logica.eliminarColicion(miX,miY+1,deQuienEs);
						}else{
							bala.setPosicionX(miX);
							bala.setPosicionY(miY+1);
						}
					}else
						bala=null;
					break;
			}
		return bala;
	}
	

	
	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	
}
