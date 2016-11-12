package Logica.Hilo.PowerUp;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloPowerUpCasco extends HiloPowerUp{
	
	public HiloPowerUpCasco(Logica l){
		super(l);
	}
	
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
