package Logica.Hilo.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloMantenerPowerUp extends HiloPowerUp{
	
	ComponenteGrafico powerUp;
	
	public HiloMantenerPowerUp(Logica l,ComponenteGrafico p){
		super(l);
		powerUp=p;
	}
	
	/**
	 * Mantiene el PowerUp vivo 8 segundos. si nadie lo agarra lo elimina
	 */
	public void run()
	{
		try{
			sleep(8000);
			if(powerUp.getVida()!=0 && !miLogica.finDelJuego())
				miLogica.eliminarPowerUp(powerUp);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		stop();
	}

}
