package Logica.Hilos;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloTimer extends Movimiento{
	 int tiempo;
	
	public HiloTimer(Logica l,int x){
		super(l);
		tiempo=x;
	}
	
	public void run()
	{
		try{
			this.sleep(tiempo);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		this.stop();
	}

	public void addBala(ComponenteGrafico x) {
		
	}
	
	public void addEnemigo(ComponenteGrafico x){}

}
