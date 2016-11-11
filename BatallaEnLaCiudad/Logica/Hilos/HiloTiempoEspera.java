package Logica.Hilos;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloTiempoEspera extends Movimiento{
	
	
	public HiloTiempoEspera(Logica l){
		super(l);
	}
	
	public void run()
	{
		try{
			this.sleep(500);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		miLogica.finalizar();
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x){}

}
