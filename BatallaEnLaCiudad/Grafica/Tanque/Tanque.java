package Grafica.Tanque;


import Grafica.ComponenteGrafico;
import Logica.Hilo.Movimiento.*;

public abstract class Tanque extends ComponenteGrafico {
	/*Constructor*/
	
	protected int disparosSimultaneos;
	protected int velMovimiento;
	protected int velDisparo;
	protected boolean puedeMover;
	protected int disparosAndando;
	
	protected Movimiento hiloFluido;
	
	public	Tanque(int x,int y){
		super(x,y);		
		disparosAndando=0;
		puedeMover=true;;
	}
	
	public int getVelMovimiento(){
		return velMovimiento;
	}
	
	public int getVelocidadDisparo(){
		return velDisparo;
	}
	
	/**
	 * Crea un disparo disparado por Tanque, si lo puede crear, empieza a moverlo;
	 * sino, elimina el disparo y con quien coliciono
	 */	
	public boolean movimientoPosible() {
		return false;
	}
	
	public boolean movimientoPosibleEnemigo(){
		return false;
	}
	
	public boolean movimientoPosibleDisparo() {
		return false;
	}
	
	public boolean mejorar() {
		return false;
	}
	
	public boolean getPuedeMover(){
		return puedeMover;
	}
	
	public void reducirDisparoAndando(){
		disparosAndando--;
	}
}
