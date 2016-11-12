package Logica.Hilo;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Logica.Logica;
import Logica.Hilo.PowerUp.HiloPowerUp;

public class HiloTiempoEspera extends Thread{
	protected int tiempo;
	protected Logica miLogica;
	
	public HiloTiempoEspera(Logica l,int x){
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
