package Logica.Hilo.PowerUp;

import java.util.ArrayList;

import Grafica.ComponenteGrafico;
import Grafica.Bloque.Acero;
import Grafica.Bloque.Ladrillo;
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
			sleep(tiempo);
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
