package Logica.Hilo.PowerUp;

import Logica.Logica;

public class HiloDetenerEnemigos extends HiloPowerUp{
	
	public HiloDetenerEnemigos(Logica l){
		super(l);
	}
	
	public void run()
	{
		try{
			sleep(7000);
			if(!miLogica.finDelJuego())
				miLogica.setDetenerTanque(false);
		}catch(InterruptedException e){ e.printStackTrace();}
		
		stop();
	}

}