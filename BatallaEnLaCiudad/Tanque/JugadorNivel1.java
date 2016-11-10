package Tanque;

import Logica.Logica;

public class JugadorNivel1 extends Jugador{

	public JugadorNivel1 (int x, int y,Logica l){
		super(x,y);
		logica=l;
		velMovimiento=2;
		velDisparo=1;
		disparosSimultaneos=1;
		vida=1;
		deQuienEs=1;
	}

}
