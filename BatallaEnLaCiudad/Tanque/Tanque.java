package Tanque;


import Logica.Logica;
import Logica.Movimiento;
import Logica.MovimientoFluido;
import Logica.Bloque.Celda;

public abstract class Tanque extends Celda {
	/*Constructor*/
	
	protected Movimiento hiloFluido;
	protected Movimiento hiloDisparo;
	
	protected int disparosSimultaneos;
	protected int velMovimiento;
	protected int velDisparo;
	
	
	protected Logica logica;
	

	
	public	Tanque(int x,int y){
		super(x,y);		
		profundidad=3;
	}
	
	public boolean mover(int direccion) {
		hiloFluido=new MovimientoFluido(this, direccion,logica);
		hiloFluido.start();
		return false;
	}	
	
	public int getVelMovimiento(){
		return velMovimiento;
	}
	
	
}
