package Tanque;

import Logica.Logica;

public class JugadorNivel4 extends Jugador{

	public JugadorNivel4 (int x, int y,Logica l){
		super(x,y);
		logica=l;
		velMovimiento=2;
		velDisparo=3;
		disparosSimultaneos=3;
		vida=4;
	}
	
}
