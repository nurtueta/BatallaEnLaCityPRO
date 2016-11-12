package Logica.Hilo.PowerUp;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Acero;
import Grafica.Bloque.Ladrillo;
import Logica.Logica;

public class HiloPowerUpGranada extends HiloPowerUp{
	
	public HiloPowerUpGranada(Logica l){
		super(l);
	}
	
	public void run()
	{
		try{
			sleep(500);
			miLogica.terminarPowerUpGranada();
		}catch(InterruptedException e){ e.printStackTrace();}
		stop();
	}

}
