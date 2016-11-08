package Tanque;

public class JugadorNivel3 extends Jugador{

	public JugadorNivel3 (int x, int y){
		super(x,y);
	}
	
	public int disparosSimultaneos(){
		return 2;
	}
	
	public int velocidadDisparo(){
		return 2;
	}
}
