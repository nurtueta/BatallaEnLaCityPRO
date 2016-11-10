package Tanque;

import Logica.Logica;

public class JugadorNivel2 extends Jugador{

	public JugadorNivel2 (int x, int y,Logica l){
		super(x,y);
		logica=l;
		velMovimiento=3;
		velDisparo=2;
		disparosSimultaneos=1;
		vida=1;
		deQuienEs=2;
	}
	
}
