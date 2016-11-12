package Logica.Hilo.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloMantenerPowerUp extends HiloPowerUp{
	
	ComponenteGrafico powerUp;
	
	public HiloMantenerPowerUp(Logica l,ComponenteGrafico p){
		super(l);
		powerUp=p;
	}
	
	public void run()
	{
		try{
			sleep(5000);
			if(powerUp.getVida()!=0 && !miLogica.finDelJuego())
				miLogica.eliminarPowerUp(powerUp);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		stop();
	}

}
