package Tanque;


import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.Logica;
import Logica.Movimiento;
import Logica.MovimientoFluido;
import Logica.MovimientoBalas;
import Logica.Bloque.Celda;

public abstract class Tanque extends Celda {
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
	
}
