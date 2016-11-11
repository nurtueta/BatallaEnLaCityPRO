package Grafica.Tanque.Enemigo;

import Grafica.ComponenteGrafico;
import Grafica.Tanque.Tanque;
import Logica.Hilos.Movimiento;
import Logica.Hilos.MovimientoBalas;

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
