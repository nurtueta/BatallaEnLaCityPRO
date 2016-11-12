package Logica.Hilo.PowerUp;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Acero;
import Grafica.Bloque.Ladrillo;
import Logica.Logica;

public class HiloPala extends HiloPowerUp{
	
	public HiloPala(Logica l){
		super(l);
	}
	
	public void run()
	{
		try{
			sleep(10000);
			for(ComponenteGrafico c : miLogica.getBase())
				if(!miLogica.finDelJuego())
					if(c.mejorar()){
						miLogica.eliminarGrafico(c);
						miLogica.setComponente(new Ladrillo(c.getPosicionX(), c.getPosicionY(),miLogica));
						miLogica.agregarGrafico(miLogica.getComponente(c.getPosicionX(), c.getPosicionY()));
					}
		}catch(InterruptedException e){ e.printStackTrace();}
		stop();
	}

}
