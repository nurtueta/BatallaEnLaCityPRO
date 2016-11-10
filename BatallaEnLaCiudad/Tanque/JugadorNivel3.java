package Tanque;

import Logica.Logica;

public class JugadorNivel3 extends Jugador{

	public JugadorNivel3 (int x, int y,Logica l){
		super(x,y);
		logica=l;
		velMovimiento=2;
		velDisparo=2;
		disparosSimultaneos=2;
		vida=2;
		deQuienEs=3;
	}
	
}
