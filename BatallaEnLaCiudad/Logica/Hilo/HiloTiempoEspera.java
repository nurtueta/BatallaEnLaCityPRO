package Logica.Hilo;

import Logica.Logica;

public class HiloTiempoEspera extends Thread{
	protected int tiempo;
	protected Logica miLogica;
	
	public HiloTiempoEspera(Logica l){
		miLogica=l;
	}
	
	public void run()
	{
		try{
			sleep(200);
			miLogica.finalizar();
		}catch(InterruptedException e){ e.printStackTrace();}
		stop();
	}

}
