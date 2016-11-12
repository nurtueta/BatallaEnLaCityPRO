package Logica.Hilo.PowerUp;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Logica.Logica;

public class HiloPala extends HiloPowerUp{
	protected int tiempo;
	
	public HiloPala(Logica l,int x){
		super(l);
		tiempo=x;
	}
	
	public void run()
	{
		try{
			this.sleep(tiempo);

		}catch(InterruptedException e){ e.printStackTrace();}
		
		this.stop();
	}

}
