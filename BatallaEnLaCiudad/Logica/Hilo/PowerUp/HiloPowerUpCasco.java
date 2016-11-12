package Logica.Hilo.PowerUp;

import Logica.Logica;

public class HiloPowerUpCasco extends HiloPowerUp{
	
	public HiloPowerUpCasco(Logica l){
		super(l);
	}
	
	/**
	 * Le coloca un casco de invulnerabilidad al Jugador
	 */
	public void run()
	{
		try{
			sleep(10000);
			if(!miLogica.finDelJuego())
				miLogica.setCasco(false);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		stop();
	}

}
