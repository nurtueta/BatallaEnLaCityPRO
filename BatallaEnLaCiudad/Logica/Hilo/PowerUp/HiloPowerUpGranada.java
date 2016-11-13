package Logica.Hilo.PowerUp;

import Logica.Logica;

public class HiloPowerUpGranada extends HiloPowerUp{
	
	public HiloPowerUpGranada(Logica l){
		super(l);
	}
	
	/**
	 * Desde que explota la granada, espera un tiempo para volver a crear a los enemigos.
	 */
	public void run()
	{
		try{
			sleep(300);
			if(!miLogica.finDelJuego())
				miLogica.terminarPowerUpGranada();
		}catch(InterruptedException e){ e.printStackTrace();}
		stop();
	}

}
