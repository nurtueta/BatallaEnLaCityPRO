package Grafica.Tanque.Enemigo;

import Grafica.Tanque.Tanque;

public abstract class Enemigo extends Tanque{
	

	/*Constructor*/
	public	Enemigo(int x,int y){
		super(x,y);
		disparosSimultaneos=1;
		deQuienEs=0;
	}	
}
