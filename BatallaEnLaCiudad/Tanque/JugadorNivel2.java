package Tanque;

public class JugadorNivel2 extends Jugador{

	public JugadorNivel2 (int x, int y){
		super(x,y);
		
		//velocidad = velocidad * 1.5
	}
	
	public int velocidadDisparo(){
		return 2;
	}
}
