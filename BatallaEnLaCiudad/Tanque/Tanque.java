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
	
	protected Movimiento hiloFluido;
	
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
	
	public int getDisparosSimultaneos(){
		return disparosSimultaneos;
	}

	
}
