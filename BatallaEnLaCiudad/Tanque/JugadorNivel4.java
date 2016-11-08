package Tanque;

public class JugadorNivel4 extends Jugador{

	public JugadorNivel4 (int x, int y){
		super(x,y);
	}
	
	public int disparosSimultaneos(){
		return 3;
	}
	
	public int velocidadDisparo(){
		return 3;
	}
	
}
