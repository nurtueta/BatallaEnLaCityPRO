package Tanque;

public class Jugador extends Tanque{
	//variables
	
	protected int vida;
	protected int powerUpDeTanque;
	protected int posFila;
	protected int posColumna;
	protected int tipo;
	
	//constructor
	public Jugador(){
		vida=100;
		powerUpDeTanque=0;
		tipo=1;
		posFila=1;
		posColumna=1;
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
	
	public int getPosFila(){
		return posFila;
	}
	
	public void setPosFila(int f){
		posFila=f;
	}
	
	public int getPosColumna(){
		return posColumna;
	}
	
	public void setPosColumna(int c){
		posColumna=c;
	}
	
	public int getTipo(){
		return tipo;
	}
	
	public void mover()
	{
		
	}

	@Override
	public boolean movimientoPosible() {
		return false;
	}
	
}
