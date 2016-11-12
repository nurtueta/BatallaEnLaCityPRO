package Logica.Hilo.PowerUp;

import Logica.Logica;

public class HiloDetenerEnemigos extends HiloPowerUp{
	
	public HiloDetenerEnemigos(Logica l){
		super(l);
	}
	
	/**
	 * Detiene a los enemigos por 5 segundos, luego los vuelve a dejar en libertad.
	 */
	public void run()
	{
		try{
			sleep(5000);
			if(!miLogica.finDelJuego())
				miLogica.setDetenerTanque(false);
		}catch(InterruptedException e){ e.printStackTrace();}
		
		stop();
	}

}