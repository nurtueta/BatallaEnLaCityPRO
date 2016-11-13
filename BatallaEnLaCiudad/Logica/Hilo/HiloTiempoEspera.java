package Logica.Hilo;

import Logica.Logica;

public class HiloTiempoEspera extends Thread{
	protected int tiempo;
	protected Logica miLogica;
	
	public	HiloTiempoEspera(int i){
		try {
			sleep(i);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public HiloTiempoEspera(Logica l){
		miLogica=l;
	}
	
	/**
	 * Espera 0,2 segundos para finalizar del todo el juego
	 */
	public void run()
	{
		try{
			sleep(200);
			miLogica.finalizar();
		}catch(InterruptedException e){ e.printStackTrace();}
		stop();
	}

}
