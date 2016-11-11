package Logica.Hilos;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloTiempoEspera extends Movimiento{
	protected int tiempo;
	
	public HiloTiempoEspera(Logica l,int x){
		super(l);
		tiempo=x;
	}
	
	public void run()
	{
		try{
			this.sleep(tiempo);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		miLogica.finalizar();
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x){}

}
