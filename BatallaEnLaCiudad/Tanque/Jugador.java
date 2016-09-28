package Tanque;

public class Jugador extends Tanque{
	//variables
	
	
	
	//constructor
	public Jugador(){
		super();
	}
	
	//comandos
	public int getVida(){
		return vida;
	}
	
	public void setVida(int v){
		vida=v;
	}
	
	public int getPowerUpDeTanque(){
		return powerUpDeTanque;
	}
	
	public void setPowerUpDeTanque(int pu){
		powerUpDeTanque=pu;
	}
	
	public int getFila(){
		return posFila;
	}
	
	public void setFila(int f){
		posFila=f;
	}
	
	public int getColumna(){
		return posColumna;
	}
	
	public void setColumna(int c){
		posColumna=c;
	}
	
	
	
	public void mover()
	{
		
	}

	@Override
	public boolean movimientoPosible() {
		return false;
	}
	
}
