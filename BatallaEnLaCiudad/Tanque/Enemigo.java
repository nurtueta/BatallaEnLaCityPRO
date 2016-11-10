package Tanque;

import Grafica.ComponenteGrafico;
import Logica.Disparo;
import Logica.Movimiento;
import Logica.MovimientoBalas;

public abstract class Enemigo extends Tanque{
	

	/*Constructor*/
	public	Enemigo(int x,int y){
		super(x,y);
		profundidad=4;
		disparosSimultaneos=1;
		deQuienEs=0;
		puntaje=500;
	}	
}
