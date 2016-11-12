package Logica.Hilo.PowerUp;

import Logica.Logica;


public abstract class HiloPowerUp extends Thread{
	
	protected Logica miLogica;
	
	public HiloPowerUp(Logica l)
	{
		miLogica=l;
	}
	
	
}
